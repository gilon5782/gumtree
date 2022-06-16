package com.gumtree.interview.backend.data;

public class AddressBookEntryMapper {

    public static AddressBookEntryDTO addressBookEntryToDto(AddressBookEntryDAO dao) {
        AddressBookEntryDTO result = new AddressBookEntryDTO();
        result.setName(dao.getName());
        return result;
    }
}
