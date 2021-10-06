package com.demo.mvc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.demo.mvc.model.CategoryAndManufacturer;
import com.demo.mvc.model.Manufacturer;
import com.demo.mvc.service.ApplicationService;
import com.demo.mvc.service.CategoryManufacturerServiceImpl;
import com.demo.mvc.validator.CategoryManufacturerFormValidator;

@Controller
@RequestMapping(value = "/categoryAndManufacturer")
public class CategoryManufacturerController {

	private final Logger logger = LoggerFactory.getLogger(CategoryManufacturerController.class);

	@Autowired
	CategoryManufacturerFormValidator cmfValidator;

	@Autowired
	private CategoryManufacturerServiceImpl cmfService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(cmfValidator);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("Entered index....");
		return "redirect:/categoryAndManufacturer/create";
	}

	// show  form to insert
	@RequestMapping(value = "/showform", method = RequestMethod.GET)
	public String showAddForm(Model model) {
		logger.info("Entered showAddForm ....");
		model.addAttribute("cmform", new CategoryAndManufacturer());
		return "users/category_manufacturer_form";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveCategoryManufacturer(@ModelAttribute("cmform") @Validated CategoryAndManufacturer cmf,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.info("saveCategoryManufacturer() : {}", cmf);

		if (result.hasErrors()) {
			logger.info("Bean Validation Error in saveCategoryManufacturer");
			return "users/category_manufacturer_form";
		} else {
			cmfService.save(cmf);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Manufacturer added successfully!");
			return "redirect:/categoryAndManufacturer/showform/";
		}
	}

}
