package com.sqisoft.eliga.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sqisoft.eliga.sample.service.SampleService;
import com.sqisoft.eliga.sample.vo.request.SampleAjaxRequestVO;
import com.sqisoft.eliga.sample.vo.request.SampleDataRequestVO;
import com.sqisoft.eliga.sample.vo.response.SampleResponseVO;

/**
 * 
 * @ClassName SampleController.java
 * @description 
 * @author JB
 * @since 2016. 4. 12.
 */
@Controller
public class SampleController {
	
	@Autowired private SampleService sampleService;
	
	/**
	 * 
	 * @name sample
	 * @description 
	 * @param Model, HttpServletRequest
	 * @return String
	 * @author JB
	 * @since 2016. 4. 12.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String sample(Model model, HttpServletRequest request) {
		model.addAttribute("serverTime", sampleService.getSample().getToday());
//		model.addAttribute("serverTime2", sampleService.getLombok().getToday());
		return "sample/sample";
	}
	
	/**
	 * 
	 * @name restSample
	 * @description RESTful
	 * @param 
	 * @return String
	 * @author JB
	 * @since 2016. 7. 5.
	 */
	@RequestMapping(value="/{id}/{name}", method=RequestMethod.GET)
	public String restSample(Model model, @PathVariable String id, @PathVariable String name) {
		model.addAttribute("serverTime", sampleService.getSample().getToday());
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "sample/sample";
	}
	
	/**
	 * 
	 * @name sampleTable
	 * @description 
	 * @param 
	 * @return String
	 * @author JB
	 * @since 2016. 7. 5.
	 */
	@RequestMapping(value="/tables", method=RequestMethod.GET)
	public String sampleTable(Model model, HttpServletRequest request, @ModelAttribute SampleDataRequestVO param) {
		model.addAttribute("data", sampleService.getSampleData(param));
		return "sample/tables";
	}
	
	/**
	 * 
	 * @name ajaxTest
	 * @description 
	 * @param 
	 * @return SampleResponseVO
	 * @author JB
	 * @since 2016. 7. 15.
	 */
	@RequestMapping(value="/ajaxTest", method=RequestMethod.POST)
	public @ResponseBody SampleResponseVO ajaxTest(HttpServletRequest request, @RequestBody SampleAjaxRequestVO param) {
		SampleResponseVO result = sampleService.getSample();
		return result;
	}
}
