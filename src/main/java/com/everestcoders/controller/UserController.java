package com.everestcoders.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.everestcoders.helper.MessageManager;
import com.everestcoders.model.User;
import com.everestcoders.model.UserPersonalInformation;
import com.everestcoders.model.VisaApplication;
import com.everestcoders.model.VisaDetails;
import com.everestcoders.service.NoticeService;
import com.everestcoders.service.UserPersonalInformationService;
import com.everestcoders.service.UserService;
import com.everestcoders.service.VisaApplicationService;
import com.everestcoders.service.VisaDetailsService;
import com.everestcoders.service.VisaInformationService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	UserPersonalInformationService informationService;

	@Autowired
	VisaDetailsService vtService;

	@Autowired
	VisaApplicationService vaService;

	@Autowired
	NoticeService noticeService;

	@Autowired
	VisaInformationService viservice;

	// getting user homePage
	@GetMapping("/index")
	public String home(Model model, Principal p) {
		return "user/index";
	}

	// get personal information page
	@GetMapping("/information")
	public String loadInformationPage(Model model, Principal p) {
		UserPersonalInformation information = informationService
				.getUserPersonalInformationByUserId(userService.getUserByUserName(p.getName()).getId());
		if (information != null) {
			return "redirect:visas";
		}
		model.addAttribute("upi", new UserPersonalInformation());

		return "user/information";
	}

	// saving personal information
	@PostMapping("/submitInformation")
	public String processingInformation(@ModelAttribute("upi") UserPersonalInformation upi,
			@RequestParam("pf_image") MultipartFile file, Model model, HttpSession session, Principal p) {
		upi.setUserId(userService.getUserByUserName(p.getName()).getId());
		informationService.saveUserPersonalInformation(upi, file);
		return "redirect:/user/visas";
	}

	// getting all visa item list page
	@GetMapping("/visas")
	public String visaPage(Model model, Principal p) {
		model.addAttribute("vtList", vtService.getAllVisaDetail());
		return "user/visaItems";
	}

	// getting apply visa page
	@GetMapping("/applyvisa/{id}")
	public String applyVisaPage(@PathVariable("id") String id, Model model, Principal p,HttpSession session) {
		System.out.println(id);
		VisaDetails details = vtService.getVisaDetailById(id);
		User user = userService.getUserByUserName(p.getName());
		VisaApplication application = vaService.getDataByUserId(user.getId());
		if (application == null) {
			model.addAttribute("vt", details);
			model.addAttribute("vf", new VisaApplication());
			return "user/applyvisa";
		}
		session.setAttribute("message", new MessageManager("You cant apply more visa at a time", "alert-danger"));
		
		return "redirect:/user/visas";
	}

	// uploading visa application
	@PostMapping("/processingvisas")
	public String processApplyVisaPage(@ModelAttribute("vf") VisaApplication vf,
			@RequestParam("pictures") List<MultipartFile> files, Model model, Principal p) {
		vaService.saveData(vf, files);
		return "redirect:index";
	}

	// getting profile page
	@GetMapping("/profile")
	public String loadProfilePage(Model model, Principal p) {
		model.addAttribute("pData", informationService
				.getUserPersonalInformationByUserId(userService.getUserByUserName(p.getName()).getId()));
		return "user/profile";
	}
	// getting current visa application status page
	@GetMapping("/currentapplyvisareport")
	public String loadcurrentapplyvisaPage(Model model, Principal p) {
		model.addAttribute("va", vaService
				.getDataByUserId(userService.getUserByUserName(p.getName()).getId()));
		return "user/currentapplyvisareport";
	}
//getting visa history

	@GetMapping("/history")
	public String getvisahistory(Model model, Principal p) {
		model.addAttribute("cvl",
				viservice.getAllByPassportNo(informationService
						.getUserPersonalInformationByUserId(userService.getUserByUserName(p.getName()).getId())
						.getPassportNo()));
		return "user/visahistory";
	}

	// getting notice page
	@GetMapping("/notice")
	public String loadnoticePage(Model model, Principal p) {
		model.addAttribute("notices",
				noticeService.getAllNoticeByUserId(userService.getUserByUserName(p.getName()).getId()));
		model.addAttribute("officenotice", noticeService.getAllAdminNotice());
		return "user/notice";
	}

	// common part for all handler
	@ModelAttribute
	public void addCommonData(Model m, Principal p) {
		User user = userService.getUserByUserName(p.getName());
		m.addAttribute("title", "UserDashboard-VisaProcessingSystem");
		m.addAttribute("user", user);
	}

}
