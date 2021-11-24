package com.everestcoders.controller;

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
import com.everestcoders.model.Notice;
import com.everestcoders.model.VisaApplication;
import com.everestcoders.model.VisaDetails;
import com.everestcoders.service.NoticeService;
import com.everestcoders.service.UserPersonalInformationService;
import com.everestcoders.service.UserService;
import com.everestcoders.service.VisaApplicationService;
import com.everestcoders.service.VisaDetailsService;

@Controller
@RequestMapping("/hr")
public class HrController {

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

	// show HR home Page
	@GetMapping("/index")
	public String home(Model model) {

		return "hr/index";
	}

	// show add visa page
	@GetMapping("/addvisatype")
	public String loadAddVisatypePage(Model model) {
		model.addAttribute("vt", new VisaDetails());
		return "hr/addvisa";
	}

	// saving visa types
	@PostMapping("/savingvisatype")
	public String peocessvisatype(@ModelAttribute("vt") VisaDetails vt, Model model, HttpSession session) {
		vtService.saveVisaDetail(vt);
		session.setAttribute("message", new MessageManager("Added Successfully", "alert-success"));
		return "hr/addvisa";
	}

	// show all visa types
	@GetMapping("/showvisatype")
	public String loadShowVisatypePage(Model model) {
		model.addAttribute("vtList", vtService.getAllVisaDetail());
		return "hr/showvisa";
	}

	// deleting visa type
	@GetMapping("/deleteVisaDetail/{id}")
	public String deleteVisatypePage(@PathVariable("id") String id, Model model, HttpSession session) {
		System.out.println("id is" + id);
		vtService.deleteVisaDetail(id);
		session.setAttribute("message", new MessageManager("Deleted Successfully", "alert-success"));
		return "redirect:/hr/showvisatype";
	}

	// update visa page
	@GetMapping("/viewvisatype/{id}")
	public String loadUpdateVisatypePage(@PathVariable("id") String id, Model model) {
		model.addAttribute("vt", vtService.getVisaDetailById(id));

		return "hr/updatevisa";
	}

	// updating visa page
	@PostMapping("/updatingvisatype")
	public String updatingvisatype(@ModelAttribute("vt") VisaDetails vt, Model model, HttpSession session) {
		vtService.UpdateVisaDetail(vt);
		System.out.println(vt.toString());
		session.setAttribute("message", new MessageManager("Added Successfully", "alert-success"));
		return "hr/addvisa";
	}

	// show visa applied form list page
	@GetMapping("/showVisaAppliedFormsList")
	public String showappliedVisaformslist(Model model) {
		model.addAttribute("vl", vaService.getAll());
		return "hr/appliedvisalist";
	}

	// show visa applied form review page
	@GetMapping("/formdetails/{formId}")
	public String showappliedVisaformreview(@PathVariable("formId") String formId, Model model) {

		model.addAttribute("vform", vaService.getDataById(formId));
		return "hr/visaformreview";
	}

	// show visa applied user detail review page
	@GetMapping("/userDetails/{userId}")
	public String showuserdetailsreview(@PathVariable("userId") String userId, Model model) {

		model.addAttribute("pData", informationService.getUserPersonalInformationByUserId(userId));
		return "hr/reviewuserdetails";
	}

	// show notice sending page
	@GetMapping("/sendNoticeTo/{userId}")
	public String sendMessagetoUserPage(@PathVariable("userId") String userId, Model model) {
		model.addAttribute("user", userService.getUser(userId));
		model.addAttribute("notice", new Notice());
		return "hr/sendnoticetouser";
	}

	// show form forward page
	@GetMapping("/forwardvisaform/{formId}")
	public String forwardFormPage(@PathVariable("formId") String formId, Model model) {
		model.addAttribute("vt", vaService.getDataById(formId));
		return "hr/forwardform";
	}

	// updating apply visa form
	@PostMapping("/updatingvisaform")
	public String processApplyVisaPage(@ModelAttribute("vt") VisaApplication vt, Model model,HttpSession session) {
		System.out.println(vt.toString());
		vaService.updateData(vt);
		session.setAttribute("message", new MessageManager("form forwarded successfully", "alert-success"));

		return "redirect:/hr/showVisaAppliedFormsList";
	}

	// sending notice to user
	@PostMapping("/sendingNotice")
	public String sendingMessage(@RequestParam("notice_image") MultipartFile file,
			@ModelAttribute("notice") Notice notice, Model model, HttpSession session) {
		noticeService.saveNotice(notice, file);
		session.setAttribute("message", new MessageManager("Send notice Successfully", "alert-success"));

		return "redirect:/hr/showVisaAppliedFormsList";
	}

	// deleting applied visa form
	@GetMapping("/deleteVisaform/{id}")
	public String deleteVisaform(@PathVariable("id") String id, Model model, HttpSession session) {
		vaService.deleteDataById(id);
		session.setAttribute("message", new MessageManager("Deleted Successfully", "alert-success"));
		return "redirect:/hr/showVisaAppliedFormsList";
	}
	// deleting applied visa form
	@GetMapping("/showNoticeAll")
	public String showAllnotice( Model model, HttpSession session) {
		return "/hr/allnotice";
	}

	// common for all
	@ModelAttribute
	public void addCommonData(Model model) {
		model.addAttribute("title", "HRDashboard-VisaProcessingSystem");
	}
}
