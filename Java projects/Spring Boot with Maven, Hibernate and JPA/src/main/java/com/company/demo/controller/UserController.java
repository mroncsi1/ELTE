package com.company.demo.controller;

import com.company.demo.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController<UserService> {
}
