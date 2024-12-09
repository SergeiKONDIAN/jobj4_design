package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Store store = new Store(true, 63, "Zarya", new Manager("Bob",
                88005555555L),
                new String[] {"apples", "bread"});

        /* Прямое преобразование store в json-строку. */
        final Gson gson = new GsonBuilder().create();
        String rsl = gson.toJson(store);
        System.out.println(rsl);

        /* Обратное преобразование json-строки  в объект */
        final Store storeReverse = gson.fromJson(rsl, Store.class);
        System.out.println(storeReverse);
    }
}
