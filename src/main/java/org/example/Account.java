package org.example;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return checkNameLength() && checkNameOneSpace() && checkNameSpaceStartOrEnd();
    }

    public boolean checkNameLength() {
        return (name.length() >= 3 && name.length() <= 19);
    }

    public boolean checkNameOneSpace() {
        return name.split(" ").length == 2;
    }

    public boolean checkNameSpaceStartOrEnd() {
        return !name.startsWith(" ") && !name.endsWith(" ");
    }

}
