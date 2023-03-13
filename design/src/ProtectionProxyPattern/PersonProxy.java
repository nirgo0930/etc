package ProtectionProxyPattern;

public class PersonProxy implements Person {

    private boolean permission;
    private Person person;

    public PersonProxy(boolean permission, Person person) {
        this.permission = permission;
        this.person = person;
    }

    public String getName() {
        return person.getName();
    }

    public String getGender() {
        return person.getGender();
    }

    public String getInterests() {
        return person.getInterests();
    }

    public int getHotOrNotRating() {
        return person.getHotOrNotRating();
    }

    public void setName(String name) throws IllegalAccessException {
        if (permission) {
            person.setName(name);
            return;
        }
        throw new IllegalAccessException();
    }

    public void setGender(String gender) throws IllegalAccessException {
        if (permission) {
            person.setGender(gender);
            return;
        }
        throw new IllegalAccessException();
    }

    public void setInterests(String interests) throws IllegalAccessException {
        if (permission) {
            person.setInterests(interests);
            return;
        }
        throw new IllegalAccessException();
    }

    public void setHotOrNotRating(int rating) throws IllegalAccessException {
        if (!permission) {
            person.setHotOrNotRating(rating);
            return;
        }
        throw new IllegalAccessException();
    }
}
