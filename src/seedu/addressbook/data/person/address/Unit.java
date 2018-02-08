package seedu.addressbook.data.person.address;

public class Unit {

    String value;

    public Unit(String unit) {
        value = unit;
    }

    public static boolean isValid(String value){
        String regex = "#[0-9]+-[0-9]+";
        return value.matches(regex);
    }

    public boolean equals(Object other){
        return value.equals(((Unit) other).toString());
    }

    @Override
    public String toString() {
        return value;
    }
}
