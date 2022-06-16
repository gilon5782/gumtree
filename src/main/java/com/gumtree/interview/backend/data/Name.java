package com.gumtree.interview.backend.data;

import lombok.Getter;
import lombok.Setter;

public class Name {
    @Getter
    @Setter
    private String name;

    public Name(String name) {
        this.name = name;
    }
}
