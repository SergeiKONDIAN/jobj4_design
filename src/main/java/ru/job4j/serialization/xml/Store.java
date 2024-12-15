package ru.job4j.serialization.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.*;

import java.io.StringWriter;
import java.util.Arrays;


@XmlRootElement(name = "store")
@XmlAccessorType(XmlAccessType.FIELD)
public class Store {

    @XmlAttribute
    private boolean workStatus;
    private int storeNumber;
    private String storeName;
    private Manager manager;

    @XmlElementWrapper(name = "goods")
    @XmlElement(name = "good")
    private String[] goodsList;

    public Store() { }

    public Store(boolean workStatus, int storeNumber, String storeName, Manager manager, String[] goodsList) {
        this.workStatus = workStatus;
        this.storeNumber = storeNumber;
        this.storeName = storeName;
        this.manager = manager;
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Store{"
                + "workStatus=" + workStatus
                + ", storeNumber=" + storeNumber
                + ", storeName='" + storeName + '\''
                + ", manager=" + manager
                + ", goodsList='" + Arrays.toString(goodsList) + '\''
                + '}';
    }

    public static void main(String[] args) throws JAXBException {

        Store store = new Store(true, 51, "Zarya",
                new Manager("Bob",
                88005555555L),
                new String[] {"bread", "cheese"});

        JAXBContext context = JAXBContext.newInstance(Store.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(store, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
