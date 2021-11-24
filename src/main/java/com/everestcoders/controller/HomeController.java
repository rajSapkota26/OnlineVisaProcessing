package com.everestcoders.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.everestcoders.helper.MessageManager;
import com.everestcoders.model.User;
import com.everestcoders.service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home-VisaProcessingSystem");
		return "index";
	}

	@GetMapping("/login")
	private String LoadLoginPage(Model model) {
		model.addAttribute("title", "Signin-VisaProcessingSystem");
		model.addAttribute("user", new User());
		return "login";
	}

	@GetMapping("/createAcccount")
	private String LoadRegisterPage(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "Signup-VisaProcessingSystem");
		return "register";
	}

	@PostMapping("/doRegister")
	private String RegisterProcess(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			HttpSession session) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("user", user);
				return "register";
			}
			this.userService.saveUser(user);
			session.setAttribute("message", new MessageManager("Registration success", "alert-success"));
			return "login";
		} catch (Exception e) {
			session.setAttribute("message", new MessageManager(e.getMessage()+". Try new email address", "alert-danger"));
			e.printStackTrace();
			model.addAttribute("user", user);
			return "register";
		}

	}

	@GetMapping("/aboutUs")
	private String LoadAboutUsPage() {

		return "about";
	}

	@GetMapping("/contactUs")
	private String LoadContactUsPage() {

		return "contact";
	}
}
