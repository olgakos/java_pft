package ru.stqa.pft.sandbox;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 4);
    System.out.println("Расстояние между двумя точками:" + "(" + p1.x + "," + p1.y + ")" + " и " + "(" + p2.x + "," + p2.y + ")" + " = " + distance(p1, p2));
    System.out.println("Расстояние между двумя точками:" + "(" + p1.x + "," + p1.y + ")" + " и " + "(" + p2.x + "," + p2.y + ")" + " = " + p2.distance(p1));
    // w2 строки "Расстояние..." это "4. Реализовать то же самое (вычисление расстояния между двумя точками) при помощи метода в классе Point, и добавить в созданный в предыдущем пункте запускаемый класс примеры использования метода вместо ранее созданной функции."


} // Это закрывающая } верхней части программы HelloWorld

    public static double distance(Point p1, Point p2) {
        double x = p1.x - p2.x;
        double y = p1.y - p2.y;
        return Math.sqrt(Math.pow(x, 4) + Math.pow(y, 4));
    }

} // Это финальная закрывающая } программы HelloWorld, не стирать!



