package com.gumtree.interview.backend.service;

import com.gumtree.interview.backend.data.AddressBookEntryDAO;
import com.gumtree.interview.backend.data.AddressBookEntryDTO;
import com.gumtree.interview.backend.data.Gender;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class AddressBookService {

    List<AddressBookEntryDAO> data;

    public AddressBookService() throws IOException {
        init();
    }

    private void init() throws IOException {
        try {
            log.info("Loading data");

            try (Stream<String> lines = Files.lines(
                    Path.of(Objects.requireNonNull(
                            this.getClass().getResource("/AddressBook")).toURI()))) {
                data = lines.map(AddressBookEntryDAO::fromString)
                        .collect(Collectors.toList());
            }
            log.info("Loaded data");
        } catch (URISyntaxException e) {
            throw new IOException("The AddressBook is missing", e);
        }
    }

    public long getEntriesCount() {
        return data.size();
    }

    public long countByGender(Gender gender) {
        return data.stream().filter(entry -> entry.getGender().equals(gender)).count();
    }

    public AddressBookEntryDTO getOldestPerson() {
        return null;
    }
}
