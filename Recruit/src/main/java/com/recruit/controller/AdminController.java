package com.recruit.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recruit.domain.AmainVO;
import com.recruit.service.AmainService;
import com.recruit.service.ResumeService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	private AmainService aservice;
	private ResumeService rservice;
	
		
	@RequestMapping(value = "/A_main", method = RequestMethod.GET)
	public void mainGET(Model model) throws Exception {
		logger.info("show all list.......");
		model.addAttribute("list", aservice.listAll());
	}
	
	@RequestMapping(value = "/A_modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("id") String id, Model model) throws Exception {
//		model.addAttribute(rservice.read(id));
		System.out.println(rservice.listAll(id));
		model.addAttribute("AmainVO", aservice.read(id));
//		model.addAttribute("reslist", rservice.listAll(id));
	}
	
	
	@RequestMapping(value = "/A_modify", method = RequestMethod.POST)
	public String modifyPOST(AmainVO vo, RedirectAttributes rttr) throws Exception {
	
		logger.info("modify post...........");
		logger.info(vo.toString());
		
		aservice.modify(vo);
		
		rttr.addFlashAttribute("msg", "success");
		
		
		return "redirect:/admin/A_main";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("id") String id, RedirectAttributes rttr) throws Exception{
		aservice.remove(id);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/admin/A_main";
	}
}
