package seedu.addressbook.data.person.Address;

public class Block {

    String value;

    public Block(String block) {
        value = block;
    }

    public static boolean isValid(String value){
        String regex = "[a-zA-Z0-9]+";
        return value.matches(regex);
    }

    public boolean equals(Object other){
        return value.equals(((Block) other).toString());
    }

    @Override
    public String toString() {
        return value;
    }
}
