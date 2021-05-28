package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        //Задание 1
        System.out.println("-------------------------------------1");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));

        //Задание 2
        System.out.println("-------------------------------------2");
        System.out.println(spiderVsFly("B2", "H3"));

        //Задание 3
        System.out.println("-------------------------------------3");
        System.out.println(digitsCount(1234));

        //Задание 4
        System.out.println("-------------------------------------4");
        String[] str =  {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(totalPoints(str, "tossed"));

        //Задание 5
        System.out.println("-------------------------------------5");
        int[] arr = {1, 2, 3, 5, 6, 7, 8, 9};
        System.out.println(longestRun(arr));

        //Задание 6
        System.out.println("-------------------------------------6");
        String[] str1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        System.out.println(takeDownAverage(str1));

        //Задание 7
        System.out.println("-------------------------------------7");
        System.out.println(rearrange("tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));

        //Задание 8
        System.out.println("-------------------------------------8");
        System.out.println(maxPossible(9132, 5564));

        //Задание 9
        System.out.println("-------------------------------------9");
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));


        //Задание 10
        System.out.println("-------------------------------------10");
        System.out.println(isNew(300456));








    }
    //Задание 1(Одинаковый шаблон)
    public static boolean sameLetterPattern(String first, String second){
        char[] f = first.toCharArray();
        char[] s = second.toCharArray();
        for(int i = 0; i < f.length-1; i++){
            if(f[i+1] - f[i] != s[i+1] - s[i]){
                return false;
            }
        }
        return true;
    }

    //Задание 2(Паук)
    public static String spiderVsFly(String start, String finish){
        start = start.toLowerCase();
        finish = finish.toLowerCase();

        int[] st = new int[]{start.charAt(0) - 97, start.charAt(1) - 48};
        int[] fn = new int[]{finish.charAt(0) - 97, finish.charAt(1) - 48};

        double lenPr = 3;
        double lenKr = 2.3;
        double tL = 0;
        String marshrut = "";
        String marshrutT = (char)(st[0] + 97) + ":" + (char)(st[1] + 48) + "-";

        while(st[1] != 0){
            st[1] -= 1;
            tL += lenPr;
            marshrutT += (char)(st[0] + 97) + ":" + (char)(st[1] + 48) + "-";
        }
        st[0] = fn[0];
        while(st[1] != fn[1]){
            st[1] += 1;
            tL += lenPr;
            marshrutT += (char)(st[0] + 97) + ":" + (char)(st[1] + 48) + "-";
        }

        double minL = tL;
        marshrut = marshrutT;
        st = new int[]{start.charAt(0) - 97, start.charAt(1) - 48};
        marshrutT = (char)(st[0] + 97) + ":" + (char)(st[1] + 48) + "-";
        tL = 0;

        if(st[1] >= fn[1]) {
            while (st[1] != fn[1]) {
                st[1] -= 1;
                tL += lenPr;
                marshrutT += (char) (st[0] + 97) + ":" + (char) (st[1] + 48) + "-";
            }
            while (st[0] != fn[0]) {
                st[0] -= 1;
                tL += lenKr * st[1];
                if(st[0] == -1) st[0] += 8;
                marshrutT += (char) (st[0] + 97) + ":" + (char) (st[1] + 48) + "-";
            }

            if (tL < minL) {
                minL = tL;
                marshrut = marshrutT;
            }
            st = new int[]{start.charAt(0) - 97, start.charAt(1) - 48};
            tL = 0;
            marshrutT = (char)(st[0] + 97) + ":" + (char)(st[1] + 48) + "-";

            while (st[1] != fn[1]) {
                st[1] -= 1;
                tL += lenPr;
                marshrutT += (char) (st[0] + 97) + ":" + (char) (st[1] + 48) + "-";
            }
            while (st[0] != fn[0]) {
                st[0] += 1;
                tL += lenKr * st[1];
                if(st[0] == 8) st[0] -= 8;
                marshrutT += (char) (st[0] + 97) + ":" + (char) (st[1] + 48) + "-";
            }

            if (tL < minL) {
                minL = tL;
                marshrut = marshrutT;
            }
        }
        else{
            while (st[0] != fn[0]) {
                st[0] += 1;
                tL += lenKr*st[1];
                if(st[0] == 8) st[0] -= 8;
                marshrutT += (char) (st[0] + 97) + ":" + (char) (st[1] + 48) + "-";
            }
            while (st[1] != fn[1]) {
                st[1] += 1;
                tL += lenPr;
                marshrutT += (char) (st[0] + 97) + ":" + (char) (st[1] + 48) + "-";
            }

            if (tL < minL) {
                minL = tL;
                marshrut = marshrutT;
            }
            st = new int[]{start.charAt(0) - 97, start.charAt(1) - 48};
            tL = 0;
            marshrutT = (char)(st[0] + 97) + ":" + (char)(st[1] + 48) + "-";

            while (st[0] != fn[0]) {
                st[0] -= 1;
                tL += lenKr*st[1];
                if(st[0] == -1) st[0] += 8;
                marshrutT += (char) (st[0] + 97) + ":" + (char) (st[1] + 48) + "-";
            }
            while (st[1] != fn[1]) {
                st[1] += 1;
                tL += lenPr;
                marshrutT += (char) (st[0] + 97) + ":" + (char) (st[1] + 48) + "-";
            }
            if (tL < minL) {
                minL = tL;
                marshrut = marshrutT;
            }
        }




        return marshrut;
    }

    //Задание 3(Подсчитываем рекурсией кол-во цифр)
    public static int digitsCount(int val){
        if(val > 9){
            return digitsCount(val / 10) + 1;
        }
        return 1;
    }

    //Задание 4(Игра в составление слов)
    public static int totalPoints(String[] otv, String slovo){
        String slovoT;
        int kolBal = 0;
        int kolBalZaSlovo;

        for(int i = 0; i < otv.length; i++){
            slovoT = slovo;
            char[] otvet = otv[i].toCharArray();
            kolBalZaSlovo = otv[i].length() - 2;
            if(otv[i].length() == 6) kolBalZaSlovo += 50;
            kolBal += kolBalZaSlovo;

            for(int j = 0; j < otvet.length; j++){
                if(slovoT.indexOf(otvet[j]) != -1){
                    if(slovoT.indexOf(otvet[j]) != slovoT.length()-1) {
                        slovoT = slovoT.substring(0, slovoT.indexOf(otvet[j])) + slovoT.substring(slovoT.indexOf(otvet[j]) + 1, slovoT.length());
                    }
                    else{
                        slovoT = slovoT.substring(0, slovoT.length() - 1);
                    }
                }
                else{
                    kolBal -= kolBalZaSlovo;
                    break;
                }
            }

        }
        return kolBal;
    }

    //Задание 5(максимальна длинна прогона)
    public static int longestRun(int[] arr){
        int maxDlinna = 0;
        int dlinnna = 1;

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i+1] - arr[i] == 1) dlinnna += 1;
            else {
                if (dlinnna > maxDlinna) maxDlinna = dlinnna;
                dlinnna = 1;
            }
        }
        if (dlinnna > maxDlinna) maxDlinna = dlinnna;
        return maxDlinna;
    }

    //Задание 6(Средний процент баллов снизился на 5)
    public static int takeDownAverage(String[] str){
        int[] arr = new int[str.length];
        int sumDo = 0;
        int kolOtm = str.length;
        for (int i = 0; i < str.length; i++){
            arr[i] = Integer.parseInt(str[i].substring(0, str[i].length()-1));
            sumDo += arr[i];
        }
        int srDo = sumDo / kolOtm;

        return (kolOtm+1) * (srDo-5) - sumDo;
    }

    //Задание 7(Пронумерованные слова)
    public static boolean isNumeric(char str) {
        try {
            Integer.parseInt(String.valueOf(str));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static String rearrange(String str){
        String[] stroka = str.split(" ");
        String[] newStroka = new String[stroka.length];
        int num;
        int indexNum;

        for(int i = 0; i < stroka.length; i++){

            for (int j = 0; j < stroka[i].length(); j++){

                if(isNumeric(stroka[i].charAt(j))){
                    num = Integer.parseInt(String.valueOf(stroka[i].charAt(j)));
                    indexNum = stroka[i].indexOf(String.valueOf(num));
                    if(indexNum != stroka[i].length()-1){
                        newStroka[num-1] = stroka[i].substring(0, indexNum) + stroka[i].substring(indexNum + 1, stroka[i].length());
                    }
                    else{
                        newStroka[num-1] = stroka[i].substring(0, stroka[i].length()-1);
                    }
                }
            }
        }
        return String.join(" ", newStroka);
    }

    //Задание 8(Меняет цифры из первого числа на цифры из второго)
    public static int[] sort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-1; j++){
                if(arr[j] < arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
        return arr;
    }
    public static int maxPossible(int val1, int val2){
        int[] num1 = new int[String.valueOf(val1).length()];
        int[] num2 = new int[String.valueOf(val2).length()];

        for(int i = num1.length-1; i >= 0; i--){
            num1[i] = val1 % 10;
            val1 /= 10;
        }
        for(int i = num2.length-1; i >= 0; i--){
            num2[i] = val2 % 10;
            val2 /= 10;
        }
        num2 = sort(num2);
        for(int i = 0; i < num1.length; i++){
            for(int j = 0; j < num2.length; j++){

                if(num1[i] < num2[j]){
                    num1[i] = num2[j];
                    num2[j] = -1;
                    break;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < num1.length; i++){
            result = result * 10 + num1[i];
        }

        return result;

    }

    //Задание 9(Дата в двух городах)
    public static String timeDifference(String first, String time, String second) {
        HashMap<String, Double> ArrCity = new HashMap<String, Double>();
        {
            ArrCity.put("Los Angeles", -8d);
            ArrCity.put("New York", -5d);
            ArrCity.put("Caracas", -4.5);
            ArrCity.put("Buenos Aires", -3d);
            ArrCity.put("London", 0d);
            ArrCity.put("Rome", 1d);
            ArrCity.put("Moscow", 3d);
            ArrCity.put("Tehran", 3.5);
            ArrCity.put("New Delhi", 5.5d);
            ArrCity.put("Beijing", 8d);
            ArrCity.put("Canberra", 10d);
        }
        HashMap<String, Integer> ArrMonth = new HashMap<String, Integer>();
        {
            ArrMonth.put("January", 1);
            ArrMonth.put("February", 2);
            ArrMonth.put("March", 3);
            ArrMonth.put("April", 4);
            ArrMonth.put("May", 5);
            ArrMonth.put("June", 6);
            ArrMonth.put("July", 7);
            ArrMonth.put("August", 8);
            ArrMonth.put("September", 9);
            ArrMonth.put("October", 10);
            ArrMonth.put("November", 11);
            ArrMonth.put("December", 12);
        }


        String[] timeArr = new String[5];
        {
            String[] t = time.split(" ");
            t[1] = t[1].substring(0, t[1].length() - 1);

            for (int i = 0; i < 3; i++) {
                timeArr[i] = t[i];
            }
            timeArr[3] = t[3].substring(0, 2);
            timeArr[4] = t[3].substring(3, 5);
        }

        int min = Integer.parseInt(timeArr[4]);
        int hour = Integer.parseInt(timeArr[3]);
        int day = Integer.parseInt(timeArr[1]);
        int month = ArrMonth.get(timeArr[0]);
        int year = Integer.parseInt(timeArr[2]);

        if (ArrCity.get(first) < ArrCity.get(second)){

            min = (int)(min - (ArrCity.get(first) * 10) % 10 * 6  + (ArrCity.get(second) * 10) % 10 * 6);
            if(min < 0) {hour -= 1; min +=60;}
            else if(min > 60) {hour += 1; min -= 60;}

            hour = hour - ArrCity.get(first).intValue() + ArrCity.get(second).intValue();
            if(hour < 0) {day -= 1; hour += 24;}
            else if(hour > 23) {day += 1; hour -= 24;}
        }

        if (ArrCity.get(first) > ArrCity.get(second)){

            min = (int)(min + (ArrCity.get(first) * 10) % 10 * 6  - (ArrCity.get(second) * 10) % 10 * 6);
            if(min < 0) {hour -= 1; min +=60;}
            else if(min > 60) {hour += 1; min -= 60;}

            hour = hour + ArrCity.get(first).intValue() - ArrCity.get(second).intValue();
            if(hour < 0) {day -= 1; hour += 24;}
            else if(hour > 23) {day += 1; hour-= 24;}
        }

        int[] dayToMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            dayToMonth[1] = 29;


        if(day < 1) {
            day += dayToMonth[month - 2];
            month -= 1;
        }
        else if(day > dayToMonth[month - 1]) {
            day -= dayToMonth[month - 1];
            month += 1;
        }


        if(month < 1) {
            year -= 1;
            month += 12;
        }
        else if(month > 12) {
            year += 1;
            month -= 12;
        }

        return (year + "-" + month + "-" + day + " "+ hour + ":" + min);
    }

    //Задание 10(Числа не являющиеся перестановкой цифр меньшего числа)
    public static int[] sort2(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
        return arr;
    }
    public static boolean isNew(int val){
        int[] num1 = new int[String.valueOf(val).length()];
        int minNotZer = 9;

        //Создаем из числа массив цифр
        for(int i = num1.length-1; i >= 0; i--){
            num1[i] = val % 10;
            val /= 10;
        }

        //Ищем наименьшую ненулевую цифру
        for(int i = 0; i < num1.length; i++){
            if(num1[i] < minNotZer && num1[i] != 0) minNotZer = num1[i];
        }

        //Проверяем чтобы первая цифра была минимальной ненулевой, а все последующие меньше или равны следующей
        if(num1[0] != minNotZer) return false;
        for(int i = 1; i < num1.length-1; i++){
            if(!(num1[i] <= num1[i+1])) return false;
        }
        return true;
    }
}
