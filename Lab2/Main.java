package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /**Пример из лабы**/
        Point2d myPoint = new Point2d ();//создает точку (0,0)
        Point2d myOtherPoint = new Point2d (5,3);//создает точку (5,3)
        Point2d aThirdPoint = new Point2d ();

        /**Создаем объекты класса Point3d**/
        Point3d myPoint2 = new Point3d(0,0,0);
        Point3d myOtherPoint2 = new Point3d();
        /**Сравниваем объекты**/
        System.out.println(myPoint2.rav(myOtherPoint2));
        /**Находим дисьанцию между обхектами**/
        System.out.println(myPoint2.distanceTo(myOtherPoint2));


        Point3d point1 = new Point3d();
        Point3d point2 = new Point3d();
        Point3d point3 = new Point3d();

        /**Создаем сканер для ввода с клавиатуры**/
        Scanner in = new Scanner(System.in);


        /**Вводим координаты трех точек**/
        System.out.println("Чтобы посчитать площадь треугольника, введите координаты вершин");
        System.out.println("Введите координаты первой точки");
        System.out.print("X = ");
        point1.setX(in.nextDouble());
        System.out.print("Y = ");
        point1.setY(in.nextDouble());
        System.out.print("Z = ");
        point1.setZ(in.nextDouble());


        System.out.println("Введите координаты второй точки");
        System.out.print("X = ");
        point2.setX(in.nextDouble());
        System.out.print("Y = ");
        point2.setY(in.nextDouble());
        System.out.print("Z = ");
        point2.setZ(in.nextDouble());


        System.out.println("Введите координаты третей точки");
        System.out.print("X = ");
        point3.setX(in.nextDouble());
        System.out.print("Y = ");
        point3.setY(in.nextDouble());
        System.out.print("Z = ");
        point3.setZ(in.nextDouble());

        /**Если точки не совпадоют, выводим их площадь**/
        if(point1.rav(point2) || point2.rav(point3) || point3.rav(point1)){
            System.out.println("Данного треугольника не существует, так как две точки равны между собой");
        }
        else{
            System.out.println(computeArea(point1, point2, point3));
        }


    }
    /**Находит площадь треугольника по 3 точкам**/
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){
        double d1 = p1.distanceTo(p2);
        double d2 = p2.distanceTo(p3);
        double d3 = p3.distanceTo(p1);
        double p = (d1 + d2 + d3) / 2;
        double S = Math.pow(p * (p - d1) * (p - d2) * (p - d3), 0.5);
        return (double)(Math.round(S * 100)) / 100;
    }
}
