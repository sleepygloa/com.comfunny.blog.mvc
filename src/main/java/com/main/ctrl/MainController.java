package com.main.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.core.parameters.Params;
import com.main.svce.MainService;


/**
 * @author "KimSeonHo"
 *
 */
@Controller
@EnableWebMvc
@RequestMapping("")
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping("/")
	public ModelAndView home(Params inParams) throws Exception {
		ModelAndView mv = new ModelAndView("/main/main");

		return mv;
	}
	
	@RequestMapping("/main/loadingSession")
	public ModelAndView loadingSession(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		String s_userId = (String)session.getAttribute("s_userId");
		
		mv.addObject("s_userId", s_userId);
		return mv;
	}	
	
	@RequestMapping("/main/loadingMainBlogContent")
	public ModelAndView loadingMainBlogContent() throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			list = mainService.mainBlogContent();	
		}catch(Exception e) {
			
		}
		
		mv.addObject("list", list);
		
		return mv;
	}
	
	
	//블로그 글쓰기 콤보박스
	@RequestMapping("/main/getBlogAddDropdownList")
	public ModelAndView getBlogAddDropdownList() {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			list = mainService.getBlogAddDropdownList();
		}catch(Exception e) {
			
		}
		mv.addObject("list", list);
		return mv;
	}
	
	//블로그 글쓰기 완료
	@RequestMapping("/main/insertBlogAddContent")
	@ResponseBody
	public void insertBlogAddContent(Params inParams) {
		System.out.println("insertBlogAddContent"+inParams);
		try {
			mainService.insertBlogAddContent(inParams);
		}catch(Exception e) {
			System.out.println("에러에러");
		}
	}

	//블로그 글 페이지
	@RequestMapping("/main/viewPg")
	@ResponseBody
	public ModelAndView viewPg(Params inParams) {
		System.out.println("viewPg : "+inParams);
		ModelAndView mv = new ModelAndView("jsonView");
		
		mv.setViewName(inParams.getString("page"));
		return mv;
	}
	
	//블로그 글 불러오기
	@RequestMapping("/main/viewBlogContent")
	@ResponseBody
	public ModelAndView viewBlogContent(Params inParams) {
		System.out.println("viewBlogContent : "+inParams);
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			list = mainService.viewBlogContent(inParams);
		}catch(Exception e) {
			
		}
		
		mv.addObject("list", list);
		
		return mv;
	}
	
}
