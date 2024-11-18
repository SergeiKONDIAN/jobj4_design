package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {

    @Test
    void checkEmptyNames() {
        NameLoad nameLoad = new NameLoad();
        String[] names = new String[0];
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void checkCorrectSplitSymbolHasMessage() {
        NameLoad nameLoad = new NameLoad();
        String[] str = {"key:value", "key1=value1"};
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void checkCorrectSplitSymbolWithMessage() {
        NameLoad nameLoad = new NameLoad();
        String[] str = {"key:value", "key1=value1"};
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str[0])
                .hasMessageContaining("does not contain the symbol '='");
    }

    @Test
    void checkContainigKey() {
        NameLoad nameLoad = new NameLoad();
        String[] str = {"key=value", "=value1"};
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str[1])
                .hasMessageContaining("does not contain a key");
    }

    @Test
    void checkContainigValue() {
        NameLoad nameLoad = new NameLoad();
        String[] str = {"key=", "key1=value1"};
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str[0])
                .hasMessageContaining("does not contain a value");
    }

    @Test
    void checkContansNoData() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("collection contains no data");
    }
}