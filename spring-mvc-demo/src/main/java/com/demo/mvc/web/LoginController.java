package com.demo.mvc.web;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	private final Logger logger = Logger.getLogger(LoginController.class.getName());
	
	@RequestMapping(value = "/dologin", method = RequestMethod.GET)
	public String login(ModelMap model) {
		logger.info("Entered login....");
		return "users/login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		logger.info("Entered loginerror....");
		model.addAttribute("error", "true");
		return "users/denied";
	}

	@RequestMapping(value = "/dologout", method = RequestMethod.GET)
	public void logout(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Entered logout....");
		logger.info("Servlet Context Path...."+request.getServletContext().getContextPath());
		request.getSession().invalidate();
		response.sendRedirect(request.getServletContext().getContextPath()+"/welcome.jsp?logoutSuccessFlag=1");
		
	}
}
