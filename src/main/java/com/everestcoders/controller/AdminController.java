package com.everestcoders.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.everestcoders.helper.MessageManager;
import com.everestcoders.model.Notice;
import com.everestcoders.model.User;
import com.everestcoders.model.VisaInformation;
import com.everestcoders.service.NoticeService;
import com.everestcoders.service.UserPersonalInformationService;
import com.everestcoders.service.UserService;
import com.everestcoders.service.VisaApplicationService;
import com.everestcoders.service.VisaDetailsService;
import com.everestcoders.service.VisaInformationService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	VisaDetailsService vtService;

	@Autowired
	VisaApplicationService vaService;

	@Autowired
	UserPersonalInformationService informationService;

	@Autowired
	NoticeService noticeService;

	@Autowired
	UserService userService;
	
	@Autowired
	VisaInformationService viservice;

	// show Admin home Page
	@GetMapping("/index")
	public String loadHomePage(Model model) {

		return "admin/index";
	}

	// show all visa types Page
	@GetMapping("/allvisalist")
	public String loadallvisatypes(Model model) {
		model.addAttribute("vtList", vtService.getAllVisaDetail());
		return "admin/visatypelist";
	}

	// show visa application list Page
	@GetMapping("/allvisaapplications")
	public String loadallvisaapplylist(Model model) {
		model.addAttribute("vl", vaService.getAll());
		return "admin/applyvisaform";
	}

	// show visa applied form review page
	@GetMapping("/formdetails/{formId}")
	public String showappliedVisaformreview(@PathVariable("formId") String formId, Model model) {

		model.addAttribute("vform", vaService.getDataById(formId));
		return "admin/visaformview";
	}

	// show visa applied form review page
	@GetMapping("/conformationform/{formId}")
	public String showappliedVisaformconformation(@PathVariable("formId") String formId, Model model) {

		model.addAttribute("vform", vaService.getDataById(formId));
		model.addAttribute("vc", new VisaInformation());
		return "admin/conformvisaproceed";
	}

	// saving visa issue detail
	@PostMapping("/conformingvisa")
	private String visaconformProcess(@ModelAttribute("vc") VisaInformation vi, Model model, HttpSession session) {
		viservice.saveVisaInformation(vi);
		System.out.println(vi.toString());
		session.setAttribute("message", new MessageManager("Visa succcessfully issued", "alert-success"));
		return "redirect:/admin/allvisaapplications";
	}

	// show conformed visa application list Page
	@GetMapping("/conformedvisalist")
	public String loadallconformedvisalist(Model model) {
		model.addAttribute("cvl", viservice.getAll());
		return "admin/conformvisalist";
	}

	// show create hr user Page
	@GetMapping("/createhr")
	public String loadcreatehrpage(Model model) {
		model.addAttribute("user", new User());
		return "admin/createhr";
	}

	// saving hr user
	@PostMapping("/doRegister")
	private String RegisterProcess(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		
		try {
			if (result.hasErrors()) {
				model.addAttribute("user", user);
				return "admin/createhr";
			}
			this.userService.saveHr(user);
			session.setAttribute("message", new MessageManager("Registration success", "alert-success"));
			return "admin/createhr";
		} catch (Exception e) {
			session.setAttribute("message", new MessageManager(e.getMessage()+". Try new email address", "alert-danger"));
			model.addAttribute("user", user);
			return "admin/createhr";
		}
	}

	// show all users Page
	@GetMapping("/listofusers")
	public String loadallusers(Model model) {
		model.addAttribute("users", userService.getAllUser());
		return "admin/allusers";
	}

	// show notice Page
	@GetMapping("/createnotice")
	public String loadnoticepage(Model model) {
		model.addAttribute("notice", new Notice());
		return "admin/notice";
	}

	// sending notice to user
	@PostMapping("/sendingNotice")
	public String sendingMessage(@RequestParam("notice_image") MultipartFile file,
			@ModelAttribute("notice") Notice notice, Model model, HttpSession session) {
		noticeService.saveAdminNotice(notice, file);
		session.setAttribute("message", new MessageManager("Send notice Successfully", "alert-success"));

		return "redirect:/admin/createnotice";
	}

	// common for all
	@ModelAttribute
	public void addCommonData(Model model) {
		model.addAttribute("title", "AdminDashboard-VisaProcessingSystem");
	}
}
