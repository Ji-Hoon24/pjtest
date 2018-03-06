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
import com.recruit.domain.CsqnaVO;
import com.recruit.service.CsfaqService;
import com.recruit.service.CsqnaService;

@Controller
@RequestMapping("/cs/*")
public class CsController {

private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	private CsfaqService fservice;
	
	@Inject
	private CsqnaService qservice;
	
	@RequestMapping(value = "/S_faq", method = RequestMethod.GET)
	public void faqGET(Model model) throws Exception {
		logger.info("faq..........");
		model.addAttribute("list", fservice.listAll());
	}
	
	@RequestMapping(value = "/S_faqread", method = RequestMethod.GET)
	public void faqreadGET(@RequestParam("bno") Integer bno, Model model) throws Exception {
		logger.info("faqread..........");
		model.addAttribute("CsfaqVO", fservice.read(bno));
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
	
	@RequestMapping(value = "/S_qna", method = RequestMethod.GET)
	public void qnaGET(Model model) throws Exception {
		logger.info("qna..........");
		model.addAttribute("list", qservice.listAll());
	}
	
	@RequestMapping(value = "/S_qnareg", method = RequestMethod.GET)
	public void qnaRegisterGET(Model model) throws Exception {
		logger.info("qna Register..........");
	}
	
	@RequestMapping(value = "/S_qnareg", method = RequestMethod.POST)
	public String qnaRegisterPOST(CsqnaVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("qna Register..........");
		logger.info(vo.toString());
		
		qservice.regist(vo);
		
		rttr.addFlashAttribute("msg", "regist");
		
		return "redirect:/cs/S_qna";
	}
	
	@RequestMapping(value = "/S_qnaread", method = RequestMethod.GET)
	public void qnareadGET(@RequestParam("bno") Integer bno, Model model) throws Exception {
		logger.info("qna read..........");
		model.addAttribute("CsqnaVO", qservice.read(bno));
	}
	
	@RequestMapping(value = "/qremove", method = RequestMethod.POST)
	public String qnaremove(@RequestParam("bno") Integer bno, RedirectAttributes rttr) throws Exception{
		qservice.remove(bno);
		
		rttr.addFlashAttribute("msg", "remove");
		
		return "redirect:/cs/S_qna";
	}
	
	@RequestMapping(value = "/S_qnamod", method = RequestMethod.GET)
	public void qnaModifyGET(@RequestParam("bno") Integer bno, Model model) throws Exception {
		logger.info("qna Modify Get..........");
		model.addAttribute("CsqnaVO", qservice.read(bno));
	}
	
	@RequestMapping(value = "/S_qnamod", method = RequestMethod.POST)
	public String qnaModifyPOST(CsqnaVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("qna Modify Post..........");
		logger.info(vo.toString());
		
		qservice.modify(vo);
		
		rttr.addFlashAttribute("msg", "modify");
		
		return "redirect:/cs/S_qna";
	}
	
}
