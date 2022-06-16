package com.gumtree.interview.backend.data;

public class AddressBookEntryMapper {

    public static AddressBookEntryDTO addressBookEntryToDto(AddressBookEntryDAO dao) {
        AddressBookEntryDTO result = new AddressBookEntryDTO();
        result.setFirstName(dao.getFirstName());
        result.setLastName(dao.getLastName());
        return result;
    }
}
