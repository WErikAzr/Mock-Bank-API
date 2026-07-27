package com.example.springdata.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "JSONPlaceholder", url="${custom.service.url}")
public interface JSONPlaceholderProxy {

    @GetMapping("/post")
    JSONPlaceholderProxy listAllResources();
}
