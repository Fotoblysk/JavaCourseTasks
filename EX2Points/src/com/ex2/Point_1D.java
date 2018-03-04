package com.ex2;

import java.util.Objects;

public class Point_1D implements IPoint{

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point_1D)) return false;
        Point_1D point_1D = (Point_1D) o;
        return Double.compare(point_1D._x, _x) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(_x);
    }

    public double get_x() {
        return _x;
    }

    public void set_x(double _x) {
        this._x = _x;
    }

    protected double _x = 0;

    public Point_1D() {
        _x = 0;
    }

    public Point_1D(double x) {
        _x = x;
    }

    public double abs() {
        return Math.abs(_x);
    }

    public Point_1D add(Point_1D v2) throws NotMatchingDimensions {
        return new Point_1D(_x + v2._x);
    }

    public Point_1D subtract(Point_1D v2) throws NotMatchingDimensions {
        return new Point_1D(_x - v2._x);
    }

    public double scalarProduct(Point_1D v2) throws NotMatchingDimensions {
        return _x * v2._x;
    }

    public Point_1D opposite() {
        return new Point_1D(-_x);
    }

    @Override
    public String toString() {
        return new String("[ "+String.valueOf(_x)+" ]");
    }
}
