package com.premsai.rest.webservices.restful_web_services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource){
		this.messageSource=messageSource;
	}
	@GetMapping(path= "/hello-world")
	public String helloWorld() {
		return "Hello World";
	} 
	
	@GetMapping(path= "/hello-world-bean")
	public  HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("prem World");
	}
	
	@GetMapping(path= "/hello-world-bean-varaible/{name}/{id}")
	public  HelloWorldBean helloWorldPathVariable(@PathVariable String name, @PathVariable int id) {
		return new HelloWorldBean(String.format("Hello World, %s, %d",name, id));
	}
	
	@GetMapping(path= "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		//return "Hello World v2";
	} 
}
