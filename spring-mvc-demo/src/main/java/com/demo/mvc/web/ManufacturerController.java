package com.demo.mvc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.mvc.model.Manufacturer;
import com.demo.mvc.service.AppService;
import com.demo.mvc.service.ApplicationService;
import com.demo.mvc.service.UserService;
import com.demo.mvc.validator.ManufacturerFormValidator;

@Controller
@RequestMapping(value = "/manufacturers")
public class ManufacturerController {
	
	private final Logger logger = LoggerFactory.getLogger(ManufacturerController.class);
	
	@Autowired
	ManufacturerFormValidator mfValidator;
	
	@Autowired
	@Qualifier("manufacturerService")
	private ApplicationService<Manufacturer> appService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(mfValidator);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("Entered index....");
		return "redirect:/manufacturers/";
	}
	
	// list page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listAllManufacturers(Model model) {
		logger.info("Entered listAllManufacturers....");	
		SecurityContext securityContext=SecurityContextHolder.getContext();
		if(securityContext!=null && securityContext.getAuthentication()!=null ) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			logger.info("Principal is "+principal);
		}
		
		model.addAttribute("manufacturers", appService.findAll());
		return "users/list_manufacturer";
	}

	// show update form
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String showUpdateManufacturerForm(@PathVariable("id") int id, Model model) {

		logger.info("Entered showUpdateManufacturerForm with id " + id);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.info("Principal is "+principal);

		Manufacturer mf = appService.findById(id);
		logger.info("Manufacturer Details = " + mf);

		model.addAttribute("manufacturerForm", mf);

		// populateDefaultModel(model);

		return "users/manufacturer_form";

	}

	// save or update Manufacturer
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String saveOrUpdateManufacturer(@ModelAttribute("manufacturerForm") @Validated Manufacturer mf,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.info("saveOrUpdateManufacturer() : {}", mf);

		if (result.hasErrors()) {
			logger.info("Bean Validation Error in saveOrUpdateManufacturer");
			return "users/manufacturer_form";
		} else {
			redirectAttributes.addFlashAttribute("css", "success");
			if (mf.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "Manufacturer added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "Manufacturer updated successfully!");
			}
			appService.saveOrUpdate(mf);
			return "redirect:/manufacturers/";
		}
	}

	// show manufacturer
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showManufacturer(@PathVariable("id") int id, Model model) {

		logger.info("showManufacturer() id: {}", id);

		Manufacturer mf = appService.findById(id);
		logger.info("Retrieved Manufacturer " + mf);

		if (mf == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Manufacturer not found");
		}
		model.addAttribute("manufacturer", mf);
		return "users/show_manufacturer";
	}

	// delete manufacturer
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String deleteManufacturer(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

		logger.info("deleteManufacturer() : {}", id);

		appService.delete(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/manufacturers";

	}
	
}


