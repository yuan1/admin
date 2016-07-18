package com.funny.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/system")
public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());


	
}
