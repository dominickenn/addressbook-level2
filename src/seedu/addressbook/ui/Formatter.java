package seedu.addressbook.ui;

import java.util.List;

import static seedu.addressbook.common.Messages.*;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    private static String commandPrompt = joinStrings(LINE_PREFIX, "Enter command: ");

    private static final String[] goodByeMessage = {MESSAGE_GOODBYE, DIVIDER, DIVIDER};

    private static final String[] initFailedMessage = {MESSAGE_INIT_FAILED, DIVIDER, DIVIDER};

    public static String getCommandPrompt(){
        return commandPrompt;
    }

    public static String returnCommandEntered(String command){
        String result = joinStrings("[Command entered:", command, "]");
        return result;
    }

    public static String formatOutputMessage(String m){
        String result = joinStrings(LINE_PREFIX, m.replace("\n", joinStrings(LS + LINE_PREFIX)));
        return result;
    }

    public static String[] formatWelcomeMessage(String version, String storageFileInfo){
        String[] result = {DIVIDER, DIVIDER, MESSAGE_WELCOME, version, MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo, DIVIDER};
        return result;
    }

    public static String[] formatResult(String feedback){
        String[] result = {feedback, DIVIDER};
        return result;
    }

    /** Formats a list of strings as a viewable indexed list. */
    public static String formatIndexedList(List<String> listItems){
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

    public static String[] getGoodbyeMessage(){
        return goodByeMessage;
    }

    public static String[] getInitFailedMessage(){
        return initFailedMessage;
    }

    /**
     * Return a String containing list of strings
     * @param strings
     * @return res
     */
    private static String joinStrings(String... strings){
        String res = "";
        for(String s : strings){
            res += s;
        }
        return res;
    }
}
