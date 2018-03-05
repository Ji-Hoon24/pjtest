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

import com.recruit.domain.CsfaqVO;
import com.recruit.service.CsfaqService;

@Controller
@RequestMapping("/cs/*")
public class CsController {

private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	private CsfaqService fservice;
	
	@RequestMapping(value = "/S_faq", method = RequestMethod.GET)
	public void faqGET(Model model) throws Exception {
		logger.info("faq..........");
		model.addAttribute("list", fservice.listAll());
	}
	
	@RequestMapping(value = "/S_faqreg", method = RequestMethod.GET)
	public void faqRegisterGET(Model model) throws Exception {
		logger.info("faq Register..........");
	}
	
	@RequestMapping(value = "/S_faqreg", method = RequestMethod.POST)
	public String faqRegisterPOST(CsfaqVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("faq Register..........");
		logger.info(vo.toString());
		
		fservice.regist(vo);
		
		rttr.addFlashAttribute("msg", "regist");
		
		return "redirect:/cs/S_faq";
	}
	
	@RequestMapping(value = "/S_faqread", method = RequestMethod.GET)
	public void faqreadGET(@RequestParam("bno") Integer bno, Model model) throws Exception {
		logger.info("faqread..........");
		model.addAttribute("CsfaqVO", fservice.read(bno));
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") Integer bno, RedirectAttributes rttr) throws Exception{
		fservice.remove(bno);
		
		rttr.addFlashAttribute("msg", "remove");
		
		return "redirect:/cs/S_faq";
	}
	
	@RequestMapping(value = "/S_faqmod", method = RequestMethod.GET)
	public void faqModifyGET(@RequestParam("bno") Integer bno, Model model) throws Exception {
		logger.info("faq Modify Get..........");
		model.addAttribute("CsfaqVO", fservice.read(bno));
	}
	
	@RequestMapping(value = "/S_faqmod", method = RequestMethod.POST)
	public String faqModifyPOST(CsfaqVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("faq Modify Post..........");
		logger.info(vo.toString());
		
		fservice.modify(vo);
		
		rttr.addFlashAttribute("msg", "modify");
		
		return "redirect:/cs/S_faq";
	}
	
}
