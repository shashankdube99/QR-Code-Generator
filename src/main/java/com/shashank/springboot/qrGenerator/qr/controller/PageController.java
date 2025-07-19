package com.shashank.springboot.qrGenerator.qr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/")
	public String home() {
		return "index"; // Will resolve to: /META-INF/resources/WEB-INF/jsp/index.jsp
	}
}