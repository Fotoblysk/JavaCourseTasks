package com.ex2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException, NotSupportedDimensionsException {
        // write your code here
        Point_3D point_3D = new Point_3D(1, 2, 3);
        Point_3D point_3DMinus = new Point_3D(-1, -2, -3);
        Point_2D point_2DMinus = new Point_2D(-1000, -2);
        Point_1D point_1DMinus = new Point_1D(-10);
        IPoint[] pointD = {point_1DMinus, point_2DMinus, point_3DMinus, point_3D};
        PointHelpers.saveToFile(pointD, "test.wtf", "w+");
        IPoint[] pointOD = PointHelpers.readFromFile("test.wtf");
        for (IPoint i : pointOD)
            System.out.println(i.toString());
        Arrays.sort(pointOD, Comparator.comparingDouble(IPoint::abs));
        System.out.println("\n");
        for (IPoint i : pointOD)
            System.out.println(i.toString());
    }
}
