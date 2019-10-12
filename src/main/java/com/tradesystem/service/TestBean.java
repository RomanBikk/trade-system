package com.tradesystem.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TestBean {
    private String name;

    public TestBean() {
    }

    public TestBean(String name) {
        this.name = name;
    }
}
