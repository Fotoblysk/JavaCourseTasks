package com.ex1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComplexTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    void abs() {
        assertEquals(new Complex(3, 4).abs(), 5);
        assertEquals(new Complex(3, 5).abs(), new Complex(5, 3).abs());
        assertEquals(new Complex(3, 5).abs(), new Complex(3, -5).abs());
        assertEquals(new Complex(3, 5).abs(), new Complex(-3, 5).abs());
    }

    @Test
    void conjugate() {
        assertEquals(new Complex(3, 4).conjugate(), new Complex(3, -4));
        assertEquals(new Complex(3, -4).conjugate(), new Complex(3, 4));
        assertEquals(new Complex(0, 0).conjugate(), new Complex(0, 0));
    }

    @Test
    void add() {
        assertEquals(new Complex(10, 10).add(new Complex(3, 5)),
                new Complex(13, 15));
        assertEquals(new Complex(-10, -10).add(new Complex(5, 15)), new Complex(-5, 5));
        assertEquals(new Complex(10, 10).add(new Complex(-5, -15)), new Complex(5, -5));
    }

    @Test
    void subtract() {
        assertEquals(new Complex(10, 10)
                        .subtract(new Complex(3, 5)),
                new Complex(7, 5));

        assertEquals(new Complex(-10, -10)
                        .subtract(new Complex(5, 15)),
                new Complex(-15, -25));

        assertEquals(new Complex(10, 10)
                        .subtract(new Complex(-5, -15)),
                new Complex(15, 25));
    }

    @Test
    void product() {
        assertEquals(new Complex(1, 1).product(2), new Complex(2, 2));
        assertEquals(new Complex(1, 1).product(-2), new Complex(-2, -2));
        assertEquals(new Complex(1, 1).product(0), new Complex(0, 0));
    }

    @Test
    void print() {
        new Complex(1, 1).print();
        new Complex(1, -1).print();
        new Complex(1).print();
        new Complex(-1).print();
        new Complex(0, 1).print();
        new Complex(0, -1).print();
        new Complex(0, 0).print();

        assertEquals(outContent.toString(), "1.0+1.0i\n" +
                "1.0-1.0i\n" +
                "1.0\n" +
                "-1.0\n" +
                "1.0i\n" +
                "-1.0i\n" +
                "0.0\n");
    }
}