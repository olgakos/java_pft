package ru.stqa.pft.sandbox;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2) {
        double x = this.x - p2.x;
        double y = this.y - p2.y;
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

    }

}// Это закрывающая } класса Point, не стирать ее!