//package ru.job4j.map;
//
//import java.util.*;
//
//public class User {
//
//    private String name;
//    private int children;
//    private Calendar birthday;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
//    }
//
////    @Override
////    public int hashCode() {
////        return Objects.hash(name, children, birthday);
////    }
//
//    public User(String name, int children, Calendar birthday) {
//        this.name = name;
//        this.children = children;
//        this.birthday = birthday;
//    }
//
//    public static void main(String[] args) {
//        Calendar calendar = new GregorianCalendar(1990, 1, 1);
//        User user1 = new User("Bob", 0, calendar);
//        User user2 = new User("Bob", 0, calendar);
//        Map<User, Object> map = new HashMap<>();
//        int hashCode1 = user1.hashCode();
//        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
//        int bucket1 = hash1 & 15;
//        int hashCode2 = user2.hashCode();
//        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
//        int bucket2 = hash2 & 15;
//
//        map.put(user1, new Object());
//        map.put(user2, new Object());
//
//        System.out.println(map);
//
//
//
//    }
//}
