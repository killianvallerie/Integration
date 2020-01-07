package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MissionController {
	
	@RequestMapping(value ="/mission", method=RequestMethod.GET)
	@ResponseBody
	
	public String string() {
		return "Hello World!";
	}
}
