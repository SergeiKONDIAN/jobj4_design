package ru.job4j.generics;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenUsernameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Hero"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Hero");
    }

    @Test
    void whenAddAndFindThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Hero"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindUsernameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Hero"));
        store.add(new Role("1", "Villain"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Hero");
    }

    @Test
    void whenReplaceThenUsernameIsMaxim() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Hero"));
        store.replace("1", new Role("1", "Villain"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Villain");
    }

    @Test
    void whenNoReplaceUserThenNoChangeUsername() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Hero"));
        store.replace("10", new Role("10", "Villain"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Hero");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Hero"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenUsernameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Hero"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Hero");
    }
}