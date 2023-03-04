package com.main.GuideAPI.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class EntityController {

    @GetMapping("/index")
    fun getRoot():String{
        return "Hello"
    }




}