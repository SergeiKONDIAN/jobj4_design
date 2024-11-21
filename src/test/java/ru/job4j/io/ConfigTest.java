package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenKeyAndValue() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Sergei");
    }

    @Test
    void whenDelimitterAtValue() {
        String path = "./data/ConfigTest/withDelimitterAtValue.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key")).isEqualTo("value=1");
    }

    @Test
    void whenNoValue() {
        String path = "./data/ConfigTest/noValue.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenCommentsAndBlankLines() {
        String path = "./data/ConfigTest/whenCommentsAndBlankLines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Key")).isEqualTo("Value");
    }

    @Test
    void whenNoDelimitter() {
        String path = "./data/ConfigTest/noDelimitter.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void whenOnlyDelimitter() {
        String path = "./data/ConfigTest/onlyDelimitter.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }
}