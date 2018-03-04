package com.ex1;

public class Complex {
    private double _re = 0;
    private double _im = 0;

    public Complex() {
        _re = 0;
        _im = 0;
    }

    public Complex(double re) {
        _re = re;
        _im = 0;
    }

    public Complex(double re, double im) {
        _re = re;
        _im = im;
    }

    public double abs() {
        return Math.sqrt(Math.pow(_re, 2) + Math.pow(_im, 2));
    }

    public Complex conjugate() {
        return new Complex(_re, -_im);
    }

    public Complex add(Complex b) {
        return new Complex(_re + b._re, _im + b._im);
    }

    public Complex subtract(Complex b) {
        return new Complex(_re - b._re, _im - b._im);
    }

    public Complex product(double b) {
        return new Complex(b * _re, b * _im);
    }

    public void print() {
        if (_im == 0)
            System.out.println(String.valueOf(_re));
        else if (_re == 0)
            System.out.println(String.valueOf(_im) + "i");
        else if (_im > 0)
            System.out.println(String.valueOf(_re) + "+" + String.valueOf(_im) + "i");
        else if (_im < 0)
            System.out.println(String.valueOf(_re) + String.valueOf(_im) + "i");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        Complex obj = (Complex) o;
        return _re == obj._re && _im == obj._im;
    }
}
