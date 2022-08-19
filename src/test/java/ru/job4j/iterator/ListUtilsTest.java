package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.removeIf(input, (t) -> t == 3);
        assertThat(input).hasSize(1).containsSequence(1);
    }

    @Test
    void whenReplaceIf() {
        input.add(9);
        input.add(7);
        ListUtils.replaceIf(input, (t) -> t % 3 == 0, 22);
        assertThat(input).hasSize(4).containsSequence(1, 22, 22, 7);
    }

    @Test
    void whenRemoveAll() {
        input.add(5);
        input.add(6);
        input.add(6);
        input.add(7);
        List<Integer> removeList = new ArrayList<>(Arrays.asList(1, 6));
        ListUtils.removeAll(input, removeList);
        assertThat(input).hasSize(3).containsSequence(3, 5, 7);
    }
}