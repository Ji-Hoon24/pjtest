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
import com.recruit.persistence.AmainDAO;
import com.recruit.service.AmainService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	private AmainService service;
		
	@RequestMapping(value = "/A_main", method = RequestMethod.GET)
	public void mainGET(Model model) throws Exception {
		logger.info("show all list.......");
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/A_modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("id") String id, Model model) throws Exception {
//		model.addAttribute(service.read(id));
		model.addAttribute("AmainVO", service.read(id));
	}
	
	
	@RequestMapping(value = "/A_modify", method = RequestMethod.POST)
	public String modifyPOST(AmainVO vo, RedirectAttributes rttr) throws Exception {
	
		logger.info("modify post...........");
		logger.info(vo.toString());
		
		service.modify(vo);
		
		rttr.addFlashAttribute("msg", "success");
		
		
		return "redirect:/admin/A_main";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("id") String id, RedirectAttributes rttr) throws Exception{
		service.remove(id);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/admin/A_main";
	}
}
