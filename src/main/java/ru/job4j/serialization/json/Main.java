package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Store store = new Store(true, 63, "Zarya", new Manager("Bob",
                88005555555L),
                new String[] {"apples", "bread"});

        System.out.println("GsonBuilder");
        /* Прямое преобразование store в json-строку. */
        final Gson gson = new GsonBuilder().create();
        String rsl = gson.toJson(store);
        System.out.println(rsl);

        /* Обратное преобразование json-строки  в объект */
        final Store storeReverse = gson.fromJson(rsl, Store.class);
        System.out.println(storeReverse);

        System.out.println("JSONObject");
        /* JSONObject из json-строки строки */
        JSONObject jsonManager = new JSONObject("{\"name\":\"Bob\", \"phoneNumber\":\"88005555555\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("apples");
        list.add("bread");
        JSONArray jsonGoods = new JSONArray(list);

        /* JSONObject напрямую методом put */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("workStatus", store.getWorkStatus());
        jsonObject.put("storeNumber", store.getStoreNumber());
        jsonObject.put("storeName", store.getStoreName());
        jsonObject.put("manager", jsonManager);
        jsonObject.put("goodsList", jsonGoods);

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(store).toString());
    }
}
