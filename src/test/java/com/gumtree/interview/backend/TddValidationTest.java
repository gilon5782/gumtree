package com.gumtree.interview.backend;

import com.gumtree.interview.backend.service.AddressBookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TddValidationTest {
    static AddressBookService service;

    @BeforeAll
    public static void init() throws IOException {
        service = new AddressBookService();
    }

    @Test
    public void canReadDbFile() {
        Assertions
                .assertThat(service.getEntriesCount())
                .as("total number of entries")
                .isGreaterThan(0);
    }
}
