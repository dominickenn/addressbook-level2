package seedu.addressbook.commands;


import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

/**
 * Sorts all persons in lexiographic order in the address book.
 */
public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_SUCCESS = "Address book sorted";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book in lexiographic order and lists them with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersonsLexiographically().immutableListView();
        return new CommandResult(MESSAGE_SUCCESS, getMessageForPersonListShownSummary(allPersons), allPersons, CommandResult.FEEDBACK_FULLLIST_TO_USER);
    }
}
