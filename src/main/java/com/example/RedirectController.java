package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redirect")
public class RedirectController {
	
	@ResponseBody
	@RequestMapping(value = "/response/{id}/{name}", method = RequestMethod.GET)
	public String hello(HttpServletRequest request, HttpServletResponse response, @PathVariable String id,	@PathVariable String name) {		
		return "Receive Params, id = "+id+", name = " +name;
	}
	
	@RequestMapping(value = "/send/{param1}/{param2}", method = RequestMethod.GET)
	public String redirectTest(HttpServletRequest request, HttpServletResponse response, @PathVariable String param1,	@PathVariable String param2) {		
		String url = "http://localhost:8888/redirect/response/"+param1+"/"+param2;
		return "redirect:"+url;
	}
}
