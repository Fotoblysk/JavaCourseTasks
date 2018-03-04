package com.ex2;

import java.util.Objects;

class NotMatchingDimensions extends Exception {

}

public class Point_2D extends Point_1D implements IPoint{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point_2D)) return false;
        if (!super.equals(o)) return false;
        Point_2D point_2D = (Point_2D) o;
        return Double.compare(point_2D._y, _y) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), _y);
    }

    public double get_y() {
        return _y;
    }

    public void set_y(double _y) {
        this._y = _y;
    }

    protected double _y = 0;

    public Point_2D() {
        super();
        _y = 0;
    }

    public Point_2D(double x) {
        super(x);
        _y = 0;
    }

    public Point_2D(double x, double y) {
        super(x);
        _y = y;
    }

    @Override
    public double abs() {
        return Math.sqrt(Math.pow(_x, 2) + Math.pow(_y, 2));
    }

    @Override
    public Point_1D add(Point_1D v2) throws NotMatchingDimensions {
        throw new NotMatchingDimensions();
    }

    @Override
    public Point_1D subtract(Point_1D v2) throws NotMatchingDimensions {
        throw new NotMatchingDimensions();
    }

    @Override
    public double scalarProduct(Point_1D v2) throws NotMatchingDimensions {
        throw new NotMatchingDimensions();
    }

    public Point_2D opposite() {
        return new Point_2D(-_x, -_y);
    }

    public Point_2D add(Point_2D v2) throws NotMatchingDimensions {
        return new Point_2D(_x + v2._x, _y + v2._y);
    }

    public Point_2D subtract(Point_2D v2) throws NotMatchingDimensions {
        return new Point_2D(_x - v2._x, _y - v2._y);
    }

    public double scalarProduct(Point_2D v2) throws NotMatchingDimensions {
        return _x * v2._x + _y * v2._y;
    }

    @Override
    public String toString() {
        return new String("[ " + String.valueOf(_x) + " ; " + String.valueOf(_y) + " ]");
    }
}

