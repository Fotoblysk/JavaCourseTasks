package com.ex2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NotSupportedDimensionsException extends Throwable {
}

public class PointHelpers { // TODO write tests
    public static void saveToFile(IPoint[] iPoints, String name, String mode) throws IOException {
        String toWrite = "";
        for (IPoint i : iPoints)
            toWrite += i.toString() + "\n";
        Path path = Paths.get(name);
        if (mode == "a+")
            Files.write(path, Arrays.asList(toWrite), StandardCharsets.UTF_8,
                    Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
        else if (mode == "a")
            Files.write(path, Arrays.asList(toWrite), StandardCharsets.UTF_8,
                    StandardOpenOption.APPEND);
        else if (mode == "w")
            Files.write(path, Arrays.asList(toWrite), StandardCharsets.UTF_8,
                    StandardOpenOption.WRITE);
        else if (mode == "w+")
            Files.write(path, Arrays.asList(toWrite), StandardCharsets.UTF_8,
                    Files.exists(path) ? StandardOpenOption.WRITE : StandardOpenOption.CREATE);
    }

    private static double[] stringToDoubles(String s) {
        Matcher matcher = Pattern
                .compile("(-?(\\d)+(\\.)?(\\d)*)")
                .matcher(s);
        ArrayList<Double> arrayList = new ArrayList<Double>();
        while (matcher.find())
            arrayList.add(Double.parseDouble(matcher.group().toString()));
        return (double[]) arrayList.stream().mapToDouble(v -> v.doubleValue()).toArray();
    }

    public static IPoint stringToIPoint(String s) throws NotSupportedDimensionsException {
        double[] list = stringToDoubles(s);
        if (list.length == 1)
            return new Point_1D(list[0]);
        else if (list.length == 2)
            return new Point_2D(list[0], list[1]);
        else if (list.length == 3)
            return new Point_3D(list[0], list[1], list[2]);
        else
            throw new NotSupportedDimensionsException();
    }

    public static IPoint[] readFromFile(String name) throws IOException, NotSupportedDimensionsException {
        String toWrite = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(name), "UTF-8"));
        String line = "";
        ArrayList<IPoint> iPoints = new ArrayList<IPoint>();
        line = br.readLine();
        while (line != null) {
            if (!line.equals(""))
                iPoints.add(stringToIPoint(line));
            line = br.readLine();
        }
        return (IPoint[]) iPoints.toArray(new IPoint[iPoints.size()]);
    }
}
