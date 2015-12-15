package com.example.bean;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Hello extends ResourceSupport {

    private final String content;

    @JsonCreator
    public Hello(@JsonProperty("content") String content) {
        this.content = content;
    }


	public String getContent() {
        return content;
    }
}

