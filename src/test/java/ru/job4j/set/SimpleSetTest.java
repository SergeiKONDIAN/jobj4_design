package ru.job4j.set;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SimpleSetTest {

    @Test
    void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
    }

    @Test
    void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.contains(null)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenIteratorHasNext() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void whenFinishIterator() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    void whenGetIteratorFromEmptySetThenNextThrowException() {
        Set<Integer> set = new SimpleSet<>();
        assertThatThrownBy(set.iterator()::next)
                .isInstanceOf(NoSuchElementException.class);
    }
}