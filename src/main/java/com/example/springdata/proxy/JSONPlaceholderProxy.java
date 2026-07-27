package com.example.springdata.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "JSONPlaceholder", url="${custom.service.url}")
public interface JSONPlaceholderProxy {
    @GetMapping("/posts")
    List<JSONPlaceholderProxy> listAllResources();
}
