package seedu.addressbook.data.person.Address;

public class PostalCode {

    String value;

    public PostalCode(String postalCode) {
        value = postalCode;
    }

    public static boolean isValid(String value){
        String regex = "[0-9]+";
        return value.matches(regex);
    }

    public boolean equals(Object other){
        return value.equals(((PostalCode) other).toString());
    }

    @Override
    public String toString() {
        return value;
    }
}
