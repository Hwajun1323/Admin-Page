package com.example.study2.controller;

import com.example.study2.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    // HTML <Form>
    //ajax 검색

    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody  SearchParam searchParam){

        return searchParam;
    }
}
