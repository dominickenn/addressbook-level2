package seedu.addressbook.data.person.Address;

public class Street {
    String value;

    public Street(String street) {
        value = street;
    }

    public static boolean isValid(String value){
        String regex = "[a-zA-Z0-9 ]+";
        return value.matches(regex);
    }

    public boolean equals(Object other){
        return value.equals(((Street) other).toString());
    }

    @Override
    public String toString() {
        return value;
    }
}
