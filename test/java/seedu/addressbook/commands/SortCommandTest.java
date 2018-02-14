package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.util.TestUtil;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {

    Person andy = TestUtil.generateTestPerson("Andy");
    Person bob = TestUtil.generateTestPerson("Bob");
    Person cathy = TestUtil.generateTestPerson("Cathy");
    Person donald = TestUtil.generateTestPerson("Donald");

    AddressBook addressBook = TestUtil.createAddressBook(bob, andy, donald, cathy);
    UniquePersonList expectedList = null;

    SortCommand sortCommand = initializeSortCommand();

    @Test
    public void execute(){
        try{
            expectedList = new UniquePersonList(andy, bob, cathy, donald);
        }catch (UniquePersonList.DuplicatePersonException e){
            e.printStackTrace();
        }
        assertSortCommandBehavior();
    }

    private void assertSortCommandBehavior(){
        sortCommand.execute();
        UniquePersonList personsinaddressbook = addressBook.getAllPersons();
        assertEquals(personsinaddressbook, expectedList);
    }

    private SortCommand createSortCommand(){
        return new SortCommand();
    }

    private SortCommand initializeSortCommand(){
        SortCommand sortCommand = createSortCommand();
        sortCommand.setData(addressBook, Collections.emptyList());
        return sortCommand;
    }
}
