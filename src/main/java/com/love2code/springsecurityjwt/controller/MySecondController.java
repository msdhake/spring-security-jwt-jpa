package com.love2code.springsecurityjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySecondController {

	@GetMapping({ "/say" })
	public String secondPage() {
		return "chal bhag chutiya hain tu";
	}
}
