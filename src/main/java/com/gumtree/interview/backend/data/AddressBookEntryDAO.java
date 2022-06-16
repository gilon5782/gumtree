package com.gumtree.interview.backend.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class AddressBookEntryDAO {

    @Getter
    @Setter
    private Name firstName;

    @Getter
    @Setter
    private Name lastName;

    @Getter
    @Setter
    private Gender gender;

    @Getter
    @Setter
    private Date dob;

    public static AddressBookEntryDAO fromString(String line) {
        String[] fields = line.split(",");
        AddressBookEntryDAO result = new AddressBookEntryDAO();
        String[] names = fields[0].trim().split(" ");
        result.setFirstName(new Name(names[0]));
        result.setLastName(new Name(names[1]));
        result.setGender(Gender.byRepr(fields[1].trim()));
        result.setDob(parseDate(fields[2].trim()));
        return result;
    }

    private static Date parseDate(String dateStr) {
        String[] dateParts = dateStr.split("/");
        return Date.from(LocalDate.of(1900 + Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]),
                Integer.parseInt(dateParts[0])).atStartOfDay().toInstant(ZoneOffset.UTC));
    }
}
