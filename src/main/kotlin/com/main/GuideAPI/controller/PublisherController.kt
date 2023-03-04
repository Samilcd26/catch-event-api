package com.main.GuideAPI.controller


import com.main.GuideAPI.business.services.PublisherServices
import com.main.GuideAPI.data.models.PublisherModel
import org.apache.tomcat.util.json.JSONParser
import org.springframework.boot.configurationprocessor.json.JSONArray
import org.springframework.boot.configurationprocessor.json.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Objects


@RestController
@RequestMapping("/api/v1/publisher")
class PublisherController(
    val publisherServices: PublisherServices) {




    @GetMapping("/index")
    fun getRoot():String{

        return "Hello"
    }

    @GetMapping("/all")
    fun getAllPublisherByCity(@RequestParam city:String):List<PublisherModel>?{
        return publisherServices.getAllPublisherByCity(city)
    }

    @PostMapping("/create")
    fun createNewPublisher(@RequestBody publisher:PublisherModel):ResponseEntity<PublisherModel>{
       return ResponseEntity.ok(publisherServices.createNewPublisher(publisher))
    }
}