package com.example.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.Hello;

@Controller
public class HATEOASGreetingController {

	private static final String TEMPLATE = "Hello, %s!";

	@RequestMapping("/hello")
	@ResponseBody
	public ResponseEntity<Hello> greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {

		Hello hello = new Hello(String.format(TEMPLATE, name));
		hello.add(linkTo(methodOn(HATEOASGreetingController.class).greeting(name)).withSelfRel());

		return new ResponseEntity<Hello>(hello, HttpStatus.OK);
	}
}
