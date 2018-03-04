package com.ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point_3DTest {

    @Test
    void equals() {
        assertEquals(new Point_3D(), new Point_3D());
        assertEquals(new Point_3D(1), new Point_3D(1));
        assertEquals(new Point_3D(1, 2), new Point_3D(1, 2));
        assertEquals(new Point_3D(1, 2, 3), new Point_3D(1, 2, 3));
        assertNotEquals(new Point_3D(1), new Point_3D(2));
        assertNotEquals(new Point_3D(1, 2), new Point_3D(2, 1));
        assertNotEquals(new Point_3D(1, 2, 3), new Point_3D(2, 1, 10));
    }

    @Test
    void get_z() {
        assertEquals(new Point_3D(1, 1, 2).get_z(), 2);
        assertEquals(new Point_3D(1, 1, -2).get_z(), -2);
        assertEquals(new Point_3D(1, 1, 0).get_z(), 0);
        assertEquals(new Point_3D(1, 1, 2.1).get_z(), 2.1);
        assertEquals(new Point_3D(1, 1, -2.1).get_z(), -2.1);
    }

    @Test
    void set_z() {
        Point_3D point_3D = new Point_3D(3, 5, 0);
        point_3D.set_z(10);
        assertNotEquals(point_3D, new Point_3D(3, 5, 0));
        assertEquals(point_3D, new Point_3D(3, 5, 10));
    }

    @Test
    void abs() {
        assertEquals(new Point_3D(2, 3, 6).abs(), 7);
        assertEquals(new Point_3D(0, 0, 0).abs(), 0);
    }

    @Test
    void add() throws NotMatchingDimensions {
        assertEquals(new Point_3D(2, 3, 6).add(new Point_3D(10, 20, 30)), new Point_3D(12, 23, 36));

        assertThrows(NotMatchingDimensions.class,
                () -> {
                    assertEquals(new Point_3D(3, 4, 0)
                                    .add(new Point_1D(10)),
                            new Point_3D(13, 4, 0));
                }
        );

        assertThrows(NotMatchingDimensions.class,
                () -> {
                    assertEquals(new Point_3D(3, 4, 0)
                                    .add(new Point_2D(10, 10)),
                            new Point_3D(13, 4, 0));
                }
        );
    }

    @Test
    void subtract() throws NotMatchingDimensions {
        assertEquals(new Point_3D(2, 3, 6).subtract(new Point_3D(10, 20, 30)), new Point_3D(-8, -17, -24));

        assertThrows(NotMatchingDimensions.class,
                () -> {
                    assertEquals(new Point_3D(3, 4, 0)
                                    .subtract(new Point_1D(10)),
                            new Point_3D(-7, 4, 0));
                }
        );

        assertThrows(NotMatchingDimensions.class,
                () -> {
                    assertEquals(new Point_3D(3, 4, 0)
                                    .subtract(new Point_2D(10, 10)),
                            new Point_3D(-7, -6, 0));
                }
        );
    }

    @Test
    void scalarProduct() throws NotMatchingDimensions {
        assertEquals(new Point_3D(2, 3, 6)
                        .scalarProduct(new Point_3D(10, 20, 30)),
                2 * 10 + 3 * 20 + 6 * 30);

        assertThrows(NotMatchingDimensions.class,
                () -> {
                    assertEquals(new Point_3D(0, 0, 0)
                                    .scalarProduct(new Point_1D(10)),
                            0);
                }
        );

        assertThrows(NotMatchingDimensions.class,
                () -> {
                    assertEquals(new Point_3D(0, 0, 0)
                                    .scalarProduct(new Point_2D(10, 10)),
                            0);
                }
        );
    }

    @Test
    void opposite() {
        assertEquals(new Point_3D(2, -3, 6).opposite(), new Point_3D(-2, 3, -6));
    }

    @Test
    void get_y() {
        assertEquals(new Point_3D(1, 2, 1).get_y(), 2);
        assertEquals(new Point_3D(1, -2, 1).get_y(), -2);
        assertEquals(new Point_3D(1, 0, 1).get_y(), 0);
        assertEquals(new Point_3D(1, 2.1, 1).get_y(), 2.1);
        assertEquals(new Point_3D(1, -2.1, 1).get_y(), -2.1);

    }

    @Test
    void set_y() {
        Point_3D point_3D = new Point_3D(3, 5, 0);
        point_3D.set_y(10);
        assertNotEquals(point_3D, new Point_3D(3, 5, 0));
        assertEquals(point_3D, new Point_3D(3, 10, 0));
    }

    @Test
    void get_x() {
        assertEquals(new Point_3D(2, 1, 1).get_x(), 2);
        assertEquals(new Point_3D(-2, 1, 1).get_x(), -2);
        assertEquals(new Point_3D(0, 1, 1).get_x(), 0);
        assertEquals(new Point_3D(2.1, 1, 1).get_x(), 2.1);
        assertEquals(new Point_3D(-2.1, 1, 1).get_x(), -2.1);
    }

    @Test
    void set_x() {
        Point_3D point_3D = new Point_3D(3, 5, 0);
        point_3D.set_x(10);
        assertNotEquals(point_3D, new Point_3D(3, 5, 0));
        assertEquals(point_3D, new Point_3D(10, 5, 0));
    }

    @Test
    void asString() {
        assertEquals(new Point_3D(-10, 0, -100).toString(), "[ -10.0 ; 0.0 ; -100.0 ]");
        assertEquals(new Point_3D(10, -1, 100).toString(), "[ 10.0 ; -1.0 ; 100.0 ]");
        assertEquals(new Point_3D(0, 1, 0).toString(), "[ 0.0 ; 1.0 ; 0.0 ]");
    }
}