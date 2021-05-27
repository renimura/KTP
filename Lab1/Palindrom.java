package com.company;

public class Palindrom{
    public static void main(String[] args) {

        String str = "java Palindrome madam racecar apple kayak song noon";
        String[] slova = str.split(" ");

        for(int i = 0; i < slova.length; i++) System.out.println(isPalindrome(slova[i]));


    }

    //Переворачивает строку
    public static String reverseString(String str){
        String newStr = "";
        for(int i = str.length() - 1; i >= 0; i--) newStr += str.charAt(i);
        return newStr;
    }
    //Возвращает палиндром слово или нет
    public static boolean isPalindrome(String str){
        String newStr = reverseString(str).toLowerCase();
        str = str.toLowerCase();
        if(str.equals(newStr)) return true;
        return false;
    }

}
