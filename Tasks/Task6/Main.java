package com.company;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("--------------------------------1");
        //Задание 1 (Предложение в предложении)
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));

        //Задание 2 (Слова по группам)
        System.out.println("--------------------------------2");
        String[] words = collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15);
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        //Задание 3 (Меняем порядок букв)
        System.out.println("--------------------------------3");
        System.out.println(nicoCipher("andiloveherso", "tesha"));

        //Задание 4 (Числа дающие произведение)
        System.out.println("--------------------------------4");
        int[] arr = twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //Задание 5 (Факториал)
        System.out.println("--------------------------------5");
        System.out.println(isExact(40320)[1]);

        //Задание 6 (Дробь)
        System.out.println("--------------------------------6");
        System.out.println(fractions("0.(6)"));

        //Задание 7 (Пора прибухнуть)
        System.out.println("--------------------------------7");
        System.out.println(PiString("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICS"));

        //Задание 8 (Выч тех на минималках)
        System.out.println("--------------------------------8");
        System.out.println(generateNonconsecutive(4));

        //Задание 9 (Шерлок)
        System.out.println("--------------------------------9");
        System.out.println(isValid("aabbccddeefghi"));

        //Задание 10 (Сумма равна 8)
        System.out.println("--------------------------------10");
        ArrayList<int[]> spis = sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7});
        for(int i = 0; i < spis.size(); i++){
            System.out.println(spis.get(i)[0] + " " + spis.get(i)[1]);
        }

    }


    //Задание 1 (Предложение в предложении)
    public static String hiddenAnagram(String text1, String text2){
        text1 = text1.toLowerCase();
        text2 = text2.toLowerCase();
        text1 = text1.replaceAll("\\p{Punct}", "");
        text2 = text2.replaceAll("\\p{Punct}", "");
        text1 = text1.replaceAll("\\s", "");
        text2 = text2.replaceAll("\\s", "");
        String result = "";
        for(int i = 0; i < text1.length(); i++){
            if(text2.indexOf(text1.charAt(i)) != -1){
                result += text1.charAt(i);
                if(result.length() == text2.length()) return result;
            }
            else{
                result = "";
            }
        }
        return result;
    }

    //Задание 2 (Слова по группам)
    public static String[] collect(String text, int l){
        String[] words = new String[text.length() / l];

        int t = 0;
        for(int i = 0; i < words.length; i++){
            words[i] = text.substring(t, t+l);
            t += l;
        }
        sort(words);
        return words;
    }

    //Задание 3 (Меняем порядок букв)
    public static String nicoCipher(String message, String key){
        while(message.length() % key.length() != 0) message += " ";
        char[] kSort = key.toCharArray();
        int[] poriadok = new int[kSort.length];
        int[] index = new int[kSort.length];
        Arrays.sort(kSort);

        for(int i = 0; i < kSort.length; i++){
            poriadok[key.indexOf(kSort[i])] = i;
            index[i] = key.indexOf(kSort[i]);
        }

        String newString = "";
        int schet = 0;
        char[] t = new char[key.length()];
        for(int j = 0; j < message.length(); j+= key.length()) {
            for (int i = 0; i < t.length; i++) {
                t[i] = message.charAt(index[i] + schet);
            }
            for (int i = 0; i < t.length; i++) {
                newString += t[i];
                t[i] = '0';
            }
            schet += key.length();
        }
        return newString;
    }

    //Задание 4 (Числа дающие произведение)
    public static int[] twoProduct(int[] arr, int pr){
        int m = arr.length * 5;
        int[] nArr = new int[2];
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i+1; j < arr.length; j++){
                if (arr[i] * arr[j] == pr && j - i + (j + i)/2 < m){
                    nArr[0] = arr[i];
                    nArr[1] = arr[j];
                    m = j - i + (j + i)/2;
                }
            }
        }
        return nArr;
    }

    //Задание 5 (Факториал)
    public static int[] isExact(int val){
        int[] arr = new int[2];
        int fac = 1;
        int i = 1;
        while(fac < val){
            fac *= i;
            if(fac == val){
                arr[0] = fac;
                arr[1] = i;
            }
            i++;
        }
        return arr;
    }

    //Задание 6 (Дробь)
    public static String fractions(String s) {
        int numer;
        int denum;
        if (s.substring(s.indexOf('.'), s.indexOf('(')).length() > 2)
            numer = Integer.parseInt(s.substring(s.indexOf('.') + 1, s.indexOf('('))
                    + s.substring(s.indexOf('(') + 1, s.indexOf(')')))
                    - Integer.parseInt(s.substring(s.indexOf('.') + 1, s.indexOf('(')));
        else
            numer = Integer.parseInt(s.substring(s.indexOf('(') + 1, s.indexOf(')')));
        denum = Integer.parseInt("9".repeat(s.substring(s.indexOf('(') + 1, s.indexOf(')')).length()) + "0".repeat(s.substring(s.indexOf('.') + 1, s.indexOf('(')).length()));
        numer = Integer.parseInt(s.substring(0, s.indexOf('.'))) * denum + numer;
        int i = 1;
        while (i < numer && i < denum) {
            for (int j = 1; j < numer && j < denum; j++)
                if (numer % j == 0 && denum % j == 0) {
                    numer = numer / j;
                    denum = denum / j;
                }
            i++;
        }
        return numer + "/" + denum;
    }

    //Задание 7 (Пора прибухнуть)
    public static String PiString(String str){
        String newStr = str.substring(0,3) + " ";
        int num = 3;
        double pi = Math.PI;
        int t;

        for(int i = 0; i < 15; i++){
            pi *= 10;
            t = (int)pi %10;
            if (num + t > str.length()){
                newStr += str.substring(num, str.length());
                for(int j = 0; j < num + t - str.length(); j++){
                    newStr += String.valueOf(str.charAt(str.length()-1));
                }
                break;
            }
            newStr += str.substring(num, num + t) + " ";
            num += t;
        }
    return newStr;
    }

    //Задание 8 (Выч тех на минималках)
    public static String generateNonconsecutive(int val){
        String newStr = "";
        int kolStr = (int)Math.pow(2,val);
        String[] tabl = new String[kolStr];

        if(val > 0) {
            for (int i = 0; i < kolStr; i++) {
                if (i < kolStr / 2) {
                    tabl[i] = "0";
                } else {
                    tabl[i] = "1";
                }
            }
        }
        if(val > 1) {
            for (int i = 0; i < kolStr; i++) {
                if (i < kolStr / 4 || i >= kolStr * 2 / 4 && i < kolStr * 3 / 4) {
                    tabl[i] += "0";
                } else {
                    tabl[i] += "1";
                }
            }
        }
        if(val > 2) {
            for (int i = 0; i < kolStr; i++) {
                if (i < kolStr / 8 || i >= kolStr * 2 / 8 && i < kolStr * 3 / 8 || i >= kolStr * 4 / 8 && i < kolStr * 5 / 8 || i >= kolStr * 6 / 8 && i < kolStr * 7 / 8) {
                    tabl[i] += "0";
                } else {
                    tabl[i] += "1";
                }
            }
        }
        if(val > 3) {
            for (int i = 0; i < kolStr; i++) {
                if (i % 2 == 0) {
                    tabl[i] += "0";
                } else {
                    tabl[i] += "1";
                }
            }
        }

        String result = "";
        boolean fl = true;
        for(int i = 0; i < tabl.length; i++){
            for(int j = 0; j < tabl[0].length()-1; j++){
                if(tabl[i].charAt(j) == tabl[i].charAt(j+1) && tabl[i].charAt(j) == 49){
                    fl = false;
                    break;
                }
            }
            if(fl) result += tabl[i] + " ";
            fl = true;
        }


        return result;
    }

    //Задание 9 (Шерлок)
    public static int max(int[] arr){
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];}
        return max;
    }
    public static int minNotZero(int[] arr){
        int min = max(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min && arr[i] != 0)
                min=arr[i];}
        return min;
    }
    public static boolean isValid(String str){
        int[] st = new int[26];
        for (int i = 0; i < str.length(); i++){
            st[str.charAt(i) - 97] += 1;
        }
        boolean fl = true;
        int kol = minNotZero(st);
        for(int i = 0; i < st.length - 1; i++){
            if(st[i] == st[i+1] && st[i] != 0){
                if(st[i] != kol) return false;
            }
            else if(!fl && st[i] != 0 && st[i+1] != 0) return false;
            else if(st[i+1] - st[i] == 1) {fl = false; i+=1;}
            else if(st[i+1] - st[i] > 0 && st[i] != 0 && st[i+1] != 0)return false;
        }
        return true;
    }

    //Задание 10 (Сумма равна 8)
    public static ArrayList<int[]> sumsUp(int[] arr){
        ArrayList<int[]> newArr = new ArrayList<>();
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j< arr.length; j++){
                if(arr[i] + arr[j] == 8){
                    newArr.add(new int[]{arr[i], arr[j]});
                }
            }
        }
        return newArr;
    }
}
