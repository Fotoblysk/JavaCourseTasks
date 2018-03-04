package com.ex2;

import java.util.Objects;

public class Point_3D extends Point_2D implements IPoint{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point_3D)) return false;
        if (!super.equals(o)) return false;
        Point_3D point_3D = (Point_3D) o;
        return Double.compare(point_3D._z, _z) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), _z);
    }

    public double get_z() {
        return _z;
    }

    public void set_z(double _z) {
        this._z = _z;
    }

    private double _z;

    public Point_3D() {
        super();
        _z = 0;
    }

    public Point_3D(double x) {
        super(x);
        _z = 0;
    }

    public Point_3D(double x, double y) {
        super(x, y);
        _z = 0;
    }

    public Point_3D(double x, double y, double z) {
        super(x, y);
        _z = z;
    }

    @Override
    public double abs() {
        return Math.sqrt(Math.pow(_x, 2) + Math.pow(_y, 2) + Math.pow(_z, 2));
    }

    @Override
    public Point_1D add(Point_1D v2) throws NotMatchingDimensions {
        return super.add(v2);
    }

    @Override
    public Point_1D subtract(Point_1D v2) throws NotMatchingDimensions {
        return super.subtract(v2);
    }

    @Override
    public double scalarProduct(Point_1D v2) throws NotMatchingDimensions {
        return super.scalarProduct(v2);
    }

    public Point_3D opposite() {
        return new Point_3D(-_x, -_y, -_z);
    }

    @Override
    public Point_2D add(Point_2D v2) throws NotMatchingDimensions {
        throw new NotMatchingDimensions();
    }

    @Override
    public Point_2D subtract(Point_2D v2) throws NotMatchingDimensions {
        throw new NotMatchingDimensions();
    }

    @Override
    public double scalarProduct(Point_2D v2) throws NotMatchingDimensions {
        throw new NotMatchingDimensions();
    }

    public double scalarProduct(Point_3D v2) throws NotMatchingDimensions {
        return _x * v2._x + _y * v2._y + _z * v2._z;
    }

    public Point_3D add(Point_3D v2) throws NotMatchingDimensions {
        return new Point_3D(_x + v2._x, _y + v2._y, _z + v2._z);
    }

    public Point_3D subtract(Point_3D v2) throws NotMatchingDimensions {
        return new Point_3D(_x - v2._x, _y - v2._y, _z - v2._z);
    }

    @Override
    public String toString() {
        return new String("[ " + String.valueOf(_x) + " ; " + String.valueOf(_y) + " ; " + String.valueOf(_z) + " ]");
    }
}
