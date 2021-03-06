package com.gumtree.interview.backend.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class AddressBookEntryDTO {
    @Getter
    @Setter
    Name firstName;

    @Getter
    @Setter
    Name lastName;
}
