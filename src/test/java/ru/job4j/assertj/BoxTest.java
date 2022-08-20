package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 8);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(3, 6);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void checkVertexNumberCube() {
        Box box = new Box(8, 8);
        assertThat(box.getNumberOfVertices()).isEqualTo(8);
    }

    @Test
    void checkVertexNumberTetrahedron() {
        Box box = new Box(4, 6);
        assertThat(box.getNumberOfVertices()).isEqualTo(4);
    }

    @Test
    void checkVertexNumberUnknown() {
        Box box = new Box(3, 6);
        assertThat(box.getNumberOfVertices()).isEqualTo(-1);
    }

    @Test
    void checkIsExistForUnknown() {
        Box box = new Box(3, 6);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void checkIsExistForCube() {
        Box box = new Box(8, 8);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void checkSphereArea() {
        Box box = new Box(0, 3);
        assertThat(box.getArea()).isEqualTo(4 * Math.PI * 3 * 3);
    }

    @Test
    void checkUnknownArea() {
        Box box = new Box(2, 3);
        assertThat(box.getArea()).isEqualTo(0);
    }
}