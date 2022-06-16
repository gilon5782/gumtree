package com.gumtree.interview.backend;

import com.gumtree.interview.backend.service.AddressBookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TddValidationTest {
    AddressBookService service = new AddressBookService();

    @Test
    public void canReadDbFile() {
        Assertions
                .assertThat(service.getEntriesCount())
                .as("total number of entries")
                .isGreaterThan(0);
    }
}
