package ru.job4j.serialization.xml;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "manager")
@XmlAccessorType(XmlAccessType.FIELD)
public class Manager {

    @XmlAttribute(name = "managerName")
    private String name;

    @XmlAttribute(name = "managerPhone")
    private long phoneNumber;

    public Manager() { }

    public Manager(String name, long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @SuppressWarnings("checkstyle:OperatorWrap")
    @Override
    public String toString() {
        return "Manager{"
                + "name=" + name
                + ", phoneNumber=" + phoneNumber
                + '}';
    }
}
