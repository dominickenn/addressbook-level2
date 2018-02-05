package seedu.addressbook.data.person.Address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String, String[])}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must contain a Block, Street, Unit, and Postal Code in this order";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] splitAddress = address.split(", ");
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress, splitAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.block = new Block(splitAddress[0]);
        this.street = new Street(splitAddress[1]);
        this.unit = new Unit(splitAddress[2]);
        this.postalCode = new PostalCode(splitAddress[3]);
    }

    /**
     * Returns true if a given string and string[] is a valid person address.
     */
    public static boolean isValidAddress(String test1, String[] test2) {
        return test1.matches(ADDRESS_VALIDATION_REGEX) &&
                test2.length == 4 &&
                Block.isValid(test2[0]) &&
                Street.isValid(test2[1]) &&
                Unit.isValid(test2[2]) &&
                PostalCode.isValid(test2[3]);
    }

    @Override
    public String toString() {
        return block.toString() + ", "
                + street.toString() + ", "
                + unit.toString() + ", "
                + postalCode.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && (this.block.equals(((Address) other).getBlock())
                && this.street.equals(((Address) other).getStreet())
                && this.unit.equals(((Address) other).getUnit())
                && this.postalCode.equals(((Address) other).getPostalCode()))); // state check
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public Block getBlock(){return block;}

    public Street getStreet(){return street;}

    public Unit getUnit(){return unit;}

    public PostalCode getPostalCode(){return postalCode;}
}
