package com.example.springdata.proxy;

import com.example.springdata.model.JSONPlaceholderModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "JSONPlaceholder", url="${custom.service.url}")
public interface JSONPlaceholderProxy {
    @GetMapping("/posts")
    List<JSONPlaceholderModel> listAllResources();

    @PostMapping("/post")
    void createResource(@RequestHeader String contentType, @RequestBody JSONPlaceholderModel jsonPlaceholderModel);
}
