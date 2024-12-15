package ru.job4j.serialization.json;

import java.util.Arrays;

public class Store {
    private boolean workStatus;
    private final int storeNumber;
    private final String storeName;
    private Manager manager;
    private String[] goodsList;

    public boolean getWorkStatus() {
        return workStatus;
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    public String getStoreName() {
        return storeName;
    }

    public Manager getManager() {
        return manager;
    }

    public String[] getGoodsList() {
        return goodsList;
    }

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
}
