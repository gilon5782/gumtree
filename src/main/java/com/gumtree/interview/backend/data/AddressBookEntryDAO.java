package com.gumtree.interview.backend.data;

import lombok.Getter;
import lombok.Setter;

public class AddressBookEntryDAO {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Gender gender;

    @Getter @Setter
    private String dob;

    public static AddressBookEntryDAO fromString(String line) {
        String[] fields = line.split(",");
        AddressBookEntryDAO result = new AddressBookEntryDAO();
        result.setName(fields[0].trim());
        result.setGender(Gender.byRepr(fields[1].trim()));
        result.setDob(fields[2].trim());
        return result;
    }
}
