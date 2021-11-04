package com.example.study2.controller;

import com.example.study2.model.SearchParam;
import com.example.study2.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){
        return "Hi, getMethod";
    }

    // don't need typing address
    @GetMapping("/getParameter") //localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){
        String password = "bbbbb";

        System.out.println("id :" + id);
        System.out.println("password : " + password);

        return id + pwd;
    }

    //localhost:8080/api/GetMultiParameter?account=abcd&eamil=study@gmail.comc&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //return "OK";
        //{"account" : "", "email" : "", "page" : 0}
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){

        // {"result Code" : "OK", "description" : "OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }
}


