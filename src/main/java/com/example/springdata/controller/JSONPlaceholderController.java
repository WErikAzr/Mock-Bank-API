package com.example.springdata.controller;

import com.example.springdata.model.JSONPlaceholderModel;
import com.example.springdata.proxy.JSONPlaceholderProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/jsonplaceholder")
public class JSONPlaceholderController {

    private final JSONPlaceholderProxy jsonPlaceholderProxy;

    public JSONPlaceholderController(JSONPlaceholderProxy jsonPlaceholderProxy) {
        this.jsonPlaceholderProxy = jsonPlaceholderProxy;
    }

    @GetMapping("/getAllResources")
    public ResponseEntity<List<JSONPlaceholderModel>> getAllResources(){
        List<JSONPlaceholderModel> allResources = jsonPlaceholderProxy.listAllResources();
        return ResponseEntity.status(HttpStatus.OK).body(allResources);
    }
}
