package com.defray.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ControllerTest {

	@RequestMapping("/list")
	public String list(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> modelMap){
		return "/index";
	}
	
}
