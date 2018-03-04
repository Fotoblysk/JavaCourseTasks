package com.ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point_2DTest {

    @Test
    void equals() {
        assertEquals(new Point_2D(), new Point_2D());
        assertEquals(new Point_2D(1), new Point_2D(1));
        assertEquals(new Point_2D(1, 2), new Point_2D(1, 2));
        assertNotEquals(new Point_2D(1), new Point_2D(2));
        assertNotEquals(new Point_2D(1, 2), new Point_2D(2, 1));
    }

    @Test
    void get_y() {
        assertEquals(new Point_2D(1, 2).get_y(), 2);
        assertEquals(new Point_2D(1, -2).get_y(), -2);
        assertEquals(new Point_2D(1, 0).get_y(), 0);
        assertEquals(new Point_2D(1, 2.1).get_y(), 2.1);
        assertEquals(new Point_2D(1, -2.1).get_y(), -2.1);
    }

    @Test
    void set_y() {
        Point_2D point_2D = new Point_2D(3, 5);
        point_2D.set_y(10);
        assertNotEquals(point_2D, new Point_2D(3, 5));
        assertEquals(point_2D, new Point_2D(3, 10));
    }

    @Test
    void abs() {
        assertEquals(new Point_2D(3, 4).abs(), 5);
        assertEquals(new Point_2D(0, 0).abs(), 0);
    }

    @Test
    void add() throws NotMatchingDimensions {
        assertEquals(new Point_2D(3, 4)
                        .add(new Point_2D(10, 20)),
                new Point_2D(13, 24));

        assertThrows(NotMatchingDimensions.class,
                () -> {
                    assertEquals(new Point_2D(3, 4)
                                    .add(new Point_1D(10)),
                            new Point_2D(13, 4));
                }
        );
    }

    @Test
    void subtract() throws NotMatchingDimensions {
        assertEquals(new Point_2D(3, 4)
                        .subtract(new Point_2D(10, 20)),
                new Point_2D(-7, -16));

        assertThrows(NotMatchingDimensions.class,
                () -> {
                    assertEquals(new Point_2D(3, 4)
                                    .subtract(new Point_1D(10)),
                            new Point_2D(-7, 4));
                }
        );
    }

    @Test
    void scalarProduct() throws NotMatchingDimensions {
        assertEquals(new Point_2D(3, 4)
                        .scalarProduct(new Point_2D(10, 20)),
                3 * 10 + 4 * 20);

        assertThrows(NotMatchingDimensions.class,
                () -> {
                    assertEquals(new Point_2D(3, 4)
                                    .subtract(new Point_1D(10)),
                            new Point_2D(30, 4));
                }
        );
    }

    @Test
    void opposite() {
        assertEquals(new Point_2D(3, 4).opposite(),
                new Point_2D(-3, -4));
        assertEquals(new Point_2D(-3, -4).opposite(),
                new Point_2D(3, 4));
        assertEquals(new Point_2D(3, -4).opposite(),
                new Point_2D(-3, 4));
    }

    @Test
    void get_x() {
        assertEquals(new Point_2D(2, 1).get_x(), 2);
        assertEquals(new Point_2D(-2, 1).get_x(), -2);
        assertEquals(new Point_2D(0, 1).get_x(), 0);
        assertEquals(new Point_2D(2.1, 1).get_x(), 2.1);
        assertEquals(new Point_2D(-2.1, 1).get_x(), -2.1);
    }

    @Test
    void set_x() {
        Point_2D point_2D = new Point_2D(3, 5);
        point_2D.set_x(10);
        assertNotEquals(point_2D, new Point_2D(3, 5));
        assertEquals(point_2D, new Point_2D(10, 5));
    }

    @Test
    void asString() {
        assertEquals(new Point_2D(-10,0).toString(), "[ -10.0 ; 0.0 ]");
        assertEquals(new Point_2D(10,-1).toString(), "[ 10.0 ; -1.0 ]");
        assertEquals(new Point_2D(0,1).toString(), "[ 0.0 ; 1.0 ]");
    }
}