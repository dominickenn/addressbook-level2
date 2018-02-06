package seedu.addressbook.data.person;

public class Contact {

    private boolean isPrivate;
    public String value;

    @Override
    public String toString() {
        return value;
    }

    public boolean isPrivate() {
        return isPrivate;
    }


    public void setPrivacy(boolean isPrivate){
        this.isPrivate = isPrivate;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
