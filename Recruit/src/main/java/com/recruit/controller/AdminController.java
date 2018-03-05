package com.recruit.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recruit.domain.AdminSearchCriteria;
import com.recruit.domain.AmainVO;
import com.recruit.domain.AdminPageMaker;
import com.recruit.service.AmainService;
import com.recruit.service.ResumeService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	private AmainService aservice;
	
	@Inject
	private ResumeService rservice;
	
		
	@RequestMapping(value = "/A_main", method = RequestMethod.GET)
	public void mainGET(@ModelAttribute("cri") AdminSearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString());
		
//		model.addAttribute("list", aservice.listCriteria(cri));
		model.addAttribute("list", aservice.listSearchCriteria(cri));
		
		AdminPageMaker pageMaker = new AdminPageMaker();
		pageMaker.setCri(cri);
		
//		pageMaker.setTotalCount(aservice.listCountCriteria(cri));
		pageMaker.setTotalCount(aservice.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/A_modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("id") String id, @ModelAttribute("cri") AdminSearchCriteria cri , Model model) throws Exception {
//		model.addAttribute(rservice.read(id));
//		System.out.println(id);
//		System.out.println(rservice.listAll(id));
		model.addAttribute("AmainVO", aservice.read(id));
		model.addAttribute("reslist", rservice.listAll(id));
	}
	
	
	@RequestMapping(value = "/A_modify", method = RequestMethod.POST)
	public String modifyPOST(AmainVO vo, AdminSearchCriteria cri, RedirectAttributes rttr) throws Exception {
	
		logger.info("modify post...........");
		logger.info(vo.toString());
		
		aservice.modify(vo);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		
		rttr.addFlashAttribute("msg", "modify");
		
		
		return "redirect:/admin/A_main";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("id") String id, RedirectAttributes rttr) throws Exception{
		aservice.remove(id);
		
		rttr.addFlashAttribute("msg", "remove");
		
		return "redirect:/admin/A_main";
	}
	
	@RequestMapping(value = "/A_amodify", method = RequestMethod.GET)
	public void amodifyGET(Model model) throws Exception {
		model.addAttribute("AmainVO", aservice.aread());
	}
	
	@RequestMapping(value = "/A_amodify", method = RequestMethod.POST)
	public String amodifyPOST(AmainVO vo, RedirectAttributes rttr) throws Exception {
	
		logger.info("modify post...........");
		logger.info(vo.toString());
		
		aservice.amodify(vo);
		
		rttr.addFlashAttribute("msg", "amodify");
		
		
		return "redirect:/admin/A_main";
	}
}
