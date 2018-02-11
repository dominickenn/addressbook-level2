package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;
import java.util.Optional;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    public final static boolean FEEDBACK_FULLLIST_TO_USER = true;

    /** The feedback message to be shown to the user if required to show full list of users */
    public final String fullListFeedBack;

    /** The feedback message to be shown to the user. Contains a description of the execution result */
    public final String feedbackToUser;

    /** Boolean to decide whether to show user full list of users after command execution */
    public final boolean toFeedbackFullListtoUser;

    /** The full list of persons to feedback to the user */
    private final List<? extends ReadOnlyPerson> allPersons;

    /** The list of persons that was produced by the command */
    private final List<? extends ReadOnlyPerson> relevantPersons;

    public CommandResult(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
        relevantPersons = null;
        toFeedbackFullListtoUser = false;
        fullListFeedBack = null;
        allPersons = null;
    }

    public CommandResult(String feedbackToUser, List<? extends ReadOnlyPerson> relevantPersons) {
        this.feedbackToUser = feedbackToUser;
        this.relevantPersons = relevantPersons;
        toFeedbackFullListtoUser = false;
        fullListFeedBack = null;
        allPersons = null;
    }

    public CommandResult(String feedbackToUser, String fullListFeedBack, List<? extends ReadOnlyPerson> allPersons, boolean toFeedbackFullListtoUser) {
        this.feedbackToUser = feedbackToUser;
        relevantPersons = null;
        this.toFeedbackFullListtoUser = toFeedbackFullListtoUser;
        this.fullListFeedBack = fullListFeedBack;
        this.allPersons = allPersons;
    }

    /**
     * Returns a list of persons relevant to the command command result, if any.
     */
    public Optional<List<? extends ReadOnlyPerson>> getRelevantPersons() {
        return Optional.ofNullable(relevantPersons);
    }

    /**
     * Returns a list of persons relevant to the command command result, if any.
     */
    public Optional<List<? extends ReadOnlyPerson>> getAllPersons() {
        return Optional.ofNullable(allPersons);
    }

}
