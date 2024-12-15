package ru.job4j.serialization.json;

public class Manager {
    private final String name;
    private final long phoneNumber;

    public String getName() {
        return name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public Manager(String name, long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name=" + name
                + "phoneNumber=" + phoneNumber
                + '}';
    }
}
