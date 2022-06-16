package com.gumtree.interview.backend;

import com.gumtree.interview.backend.data.AddressBookEntryDTO;
import com.gumtree.interview.backend.data.Gender;
import com.gumtree.interview.backend.data.Name;
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

    @Test
    public void canDifferentiateGender() {
        Assertions.assertThat(service.countByGender(Gender.MALE))
                .as("male count")
                .isEqualTo(3);
    }

    @Test
    public void canFindOldestPerson() {
        AddressBookEntryDTO expected = new AddressBookEntryDTO();
        expected.setName("Wes Jackson");
        Assertions.assertThat(service.getOldestPerson())
                .as("oldest person")
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    public void canCalculateAgeDifferenceInDays() {
        Assertions.assertThat(service.getAgeDifferenceInDays(new Name("Bill"), new Name("Paul")))
                .as("days between birth of Bill and Paul")
                .isEqualTo(100);
    }
}
