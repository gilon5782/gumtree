package com.gumtree.interview.backend.data;

import java.util.Objects;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private final String strRepr;

    Gender(String strRepr) {
        this.strRepr = strRepr;
    }

    public static Gender byRepr(String repr) {
        for (Gender g : Gender.values()) {
            if (Objects.equals(g.strRepr, repr)) {
                return g;
            }
        }
        throw new IllegalArgumentException("Unknown gender " + repr);
    }
}
