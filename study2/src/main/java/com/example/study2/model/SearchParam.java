package com.example.study2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
@AllArgsConstructor
public class SearchParam {

    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private String email;
    private int page;

}
