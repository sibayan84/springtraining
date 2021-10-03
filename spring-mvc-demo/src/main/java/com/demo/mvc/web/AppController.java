package com.demo.mvc.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.mvc.model.Manufacturer;
import com.demo.mvc.model.User;
import com.demo.mvc.service.AppService;
import com.demo.mvc.service.UserService;
import com.demo.mvc.validator.ManufacturerFormValidator;
import com.demo.mvc.validator.UserFormValidator;
//import javax.validation.Valid;

//http://www.tikalk.com/redirectattributes-new-feature-spring-mvc-31/
//https://en.wikipedia.org/wiki/Post/Redirect/Get
//http://www.oschina.net/translate/spring-mvc-flash-attribute-example
//@Controller
public class AppController {

	private final Logger logger = LoggerFactory.getLogger(AppController.class);

	@Autowired
	ManufacturerFormValidator mfValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(mfValidator);
	}

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	private AppService appService;

	//@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("Entered index....");
		return "redirect:/manufacturers";
	}
	
	// list page
	//@RequestMapping(value = "/manufacturers", method = RequestMethod.GET)
	public String showAllManufacturers(Model model) {
		logger.info("Entered showAllManufacturers....");	
		SecurityContext securityContext=SecurityContextHolder.getContext();
		if(securityContext!=null && securityContext.getAuthentication()!=null ) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			logger.info("Principal is "+principal);
		}
		
		model.addAttribute("manufacturers", appService.findAllManufacturer());
		return "users/list_manufacturer";
	}

	// show update form
	//@RequestMapping(value = "/manufacturers/{id}/update", method = RequestMethod.GET)
	public String showUpdateManufacturerForm(@PathVariable("id") int id, Model model) {

		logger.info("Entered showUpdateManufacturerForm with id " + id);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.info("Principal is "+principal);

		Manufacturer mf = appService.findManufacturerById(id);
		logger.info("Manufacturer Details = " + mf);

		model.addAttribute("manufacturerForm", mf);

		// populateDefaultModel(model);

		return "users/manufacturer_form";

	}

	// save or update Manufacturer
	//@RequestMapping(value = "/manufacturers", method = RequestMethod.POST)
	public String saveOrUpdateManufacturer(@ModelAttribute("manufacturerForm") @Validated Manufacturer mf,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.info("saveOrUpdateManufacturer() : {}", mf);

		if (result.hasErrors()) {
			logger.info("Bean Validation Error in saveOrUpdateManufacturer");
			//populateDefaultModel(model);
			return "users/manufacturer_form";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if (mf.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "Manufacturer added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "Manufacturer updated successfully!");
			}

			appService.saveOrUpdate(mf);

			// POST/REDIRECT/GET
			// return "redirect:/manufacturers/" + mf.getId();
			return "redirect:/manufacturers/";

			// POST/FORWARD/GET
			// return "users/list_manufacturer";

		}

	}

	// show manufacturer
	//@RequestMapping(value = "/manufacturers/{id}", method = RequestMethod.GET)
	public String showManufacturer(@PathVariable("id") int id, Model model) {

		logger.info("showManufacturer() id: {}", id);

		Manufacturer mf = appService.findManufacturerById(id);
		logger.info("Retrieved Manufacturer " + mf);

		if (mf == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Manufacturer not found");
		}
		model.addAttribute("manufacturer", mf);
		return "users/show_manufacturer";
	}

	// delete manufacturer
	//@RequestMapping(value = "/manufacturers/{id}/delete", method = RequestMethod.POST)
	public String deleteManufacturer(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

		logger.info("deleteManufacturer() : {}", id);

		appService.deleteManufacturer(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/manufacturers";

	}

}