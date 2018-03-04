package com.ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point_1DTest {

    @Test
    void equals() {
        assertEquals(new Point_1D(), new Point_1D());
        assertEquals(new Point_1D(1), new Point_1D(1));
        assertNotEquals(new Point_1D(1), new Point_1D(2));
    }

    @Test
    void get_x() {
        assertEquals(new Point_1D(1).get_x(), 1);
    }

    @Test
    void set_x() {
        Point_1D point_1d = new Point_1D(1);
        point_1d.set_x(2);
        assertEquals(point_1d, new Point_1D(2));
    }

    @Test
    void abs() {
        assertEquals(new Point_1D(2).abs(), 2);
        assertEquals(new Point_1D(0).abs(), 0);
    }

    @Test
    void add() throws NotMatchingDimensions {
        assertEquals(new Point_1D(2).add(new Point_1D(3)), new Point_1D(5));
    }

    @Test
    void subtract() throws NotMatchingDimensions {
        assertEquals(new Point_1D(2).subtract(new Point_1D(3)), new Point_1D(-1));
    }

    @Test
    void scalarProduct() throws NotMatchingDimensions {
        assertEquals(new Point_1D(2).scalarProduct(new Point_1D(5)), 10);
        assertEquals(new Point_1D(-2).scalarProduct(new Point_1D(-5)), 10);
        assertEquals(new Point_1D(2).scalarProduct(new Point_1D(-5)), -10);
        assertEquals(new Point_1D(2).scalarProduct(new Point_1D(-5)), -10);
    }

    @Test
    void opposite() {
        assertEquals(new Point_1D(10).opposite(), new Point_1D(-10));
        assertEquals(new Point_1D(-10).opposite(), new Point_1D(10));
        // TODO floating point precision issue
        //assertEquals(new Point_1D(0).opposite(), new Point_1D(0));
    }

    @Test
    void asString() {
        assertEquals(new Point_1D(-10).toString(), "[ -10.0 ]");
        assertEquals(new Point_1D(10).toString(), "[ 10.0 ]");
        assertEquals(new Point_1D(0).toString(), "[ 0.0 ]");
    }
}