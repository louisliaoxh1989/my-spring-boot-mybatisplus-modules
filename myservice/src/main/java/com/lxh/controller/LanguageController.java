package com.lxh.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class LanguageController {
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/changeLanauage")
	@ResponseBody
	public String changeLanauage(HttpServletRequest request, HttpServletResponse response, String lang) {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		if ("zh".equals(lang)) {
			localeResolver.setLocale(request, response, new Locale("zh", "CN"));
		} else if ("en".equals(lang)) {
			localeResolver.setLocale(request, response, new Locale("en", "US"));
		}
		return "ok";
	}
	@GetMapping("/langtest")
	public String languageTest(Model model) {
		//Locale locale = LocaleContextHolder.getLocale();
		//model.addAttribute("world", messageSource.getMessage("welcome", null, locale));
		return "langtest";
	}
}
