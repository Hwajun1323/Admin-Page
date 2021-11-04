package com.example.study2.controller.api;

import com.example.study2.ifs.CrudInterface;
import com.example.study2.model.entity.User;
import com.example.study2.model.network.Header;
import com.example.study2.model.network.request.UserApiRequest;
import com.example.study2.model.network.response.UserApiResponse;
import com.example.study2.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping("")
    public Header<List<UserApiResponse>> search(Pageable pageable){

        log.info("{}", pageable);
        return null;
    }

    @Override
    @PostMapping("")    // api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        log.info("read : {}", id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request){

        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")  //
    public Header delete(@PathVariable Long id) {
        log.info("delete : {}", id);
        return userApiLogicService.delete(id);
    }
}
