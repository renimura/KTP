package com.company;

public class Main {

    public static void main(String[] args) {

        //№1
        for(int i = 3; i < 101; i++){
            if(isPrime(i)) System.out.println(i);
        }



    }
    //Простота числа
    public static boolean isPrime (int val){
        for(int i = 2; i < val; i++){
            if(val % i == 0) return false;
        }
        return true;
    }


}
