package com.cbx.controller;

import com.cbx.mapper.FooddataMapper;
import com.cbx.service.FooddataService;
import com.cbx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author cbx
 * @date 2022/3/22
 * @apiNote
 */
public class BaseController {

    @Autowired
    public FooddataService fooddataService;

    @Autowired
    public UserService userService;

    @Autowired
    public FooddataMapper fooddataMapper;



}
