package com.funny.admin.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected Long getCurrentLoginUserId() {
        return 1L;
    }
}
