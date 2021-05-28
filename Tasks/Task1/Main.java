package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println(minToSec(5));
        System.out.println(basketPoints(13,12));
        System.out.println(footballPoints(3,4,2));
        System.out.println(divisibleByFive(-55));
        System.out.println(and(true, false));
        System.out.println(howManyWalls(85, 1, 43));
        System.out.println(squared(5));
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(frames(10, 1));
        System.out.println(mod(218,5));

    }





    public static int basketPoints(int two, int three){
        return two * 2 + three * 3;
    }//Баскетбол
    public static int minToSec(int kol_min){
        return kol_min * 60;
    }//Минуты в секунды
    public static int footballPoints(int p1, int X, int p2) {
        return p1 * 3 + X;
    }//Очки за футбольные матчи
    public static boolean divisibleByFive(int val){
        if(val % 5 == 0) return true;
        return false;
    }//Делится ли число на 5
    public static boolean and(boolean a, boolean b){
        return a && b;
    }//Логическое перемножение
    public static int howManyWalls(int kolM, int w, int h){
        return kolM / (w * h);
    }//Том Сойер
    public static int squared(int a) {
        return a * a;
    }//Квадрат
    public static boolean profitableGamble(double prob, int prize, double pay){
        return prob * prize > pay;
    }//Молодой предпрениматель
    public static int frames(int minute, int FPS){
        return minute * FPS * 60;
    }//FPS
    public static int mod(int delimoe, int delitel){
        while(delimoe >= delitel){
            delimoe -= delitel;
        }
        return delimoe;
    }//Остаток от деления


}