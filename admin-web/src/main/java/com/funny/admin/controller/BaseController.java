package com.funny.admin.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());


	
}
