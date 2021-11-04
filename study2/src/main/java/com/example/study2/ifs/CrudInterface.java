package com.example.study2.ifs;

import com.example.study2.model.network.Header;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Header<Req> request);    // todo request object

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);
}
