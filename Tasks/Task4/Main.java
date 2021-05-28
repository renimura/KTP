package com.company;

public class Main {

    public static void main(String[] args) {

        //Задание 1
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(sevenBoom(arr1));

        //Задание 2
        int[] arr2 = {5, 6, 7, 8, 9, 9};
        System.out.println(cons(arr2));

        //Задание 3
        System.out.println(unmix("hTsii  s aimex dpus rtni.g"));

        //Задание 4
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!"));

        //Задание 5
        System.out.println(xPronounce("The x ray is excellent"));

        //Задание 6
        int[] arr3 = {14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7};
        System.out.println(largestGap(arr3));

        //Задание 7
        System.out.println(func(149));

        //Задание 8
        System.out.println(commonLastVowel("Watch the characters dance!"));

        //Задание 9
        System.out.println(memeSum(122, 81));

        //Задание 10
        System.out.println(unrepeated(("call 911")));


    }

    public static int[] sort(int[] arr){
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
    public static String charToString(char[] strC){
        String str = "";
        for(int i = 0; i < strC.length; i++){
            str += strC[i];
        }
        return str;
    }
    public static String delsimv(String str, int index){
        String newStr = "";
        for(int i = 0; i < str.length(); i++){
            if(i != index){
                newStr += str.charAt(i);
            }
        }
        return newStr;
    }
    public static String zamenSimv(String str, int ind, String zam){
        String nStr = "";
        for(int i = 0; i < str.length(); i++){
            if(i == ind){
                nStr += zam;
            }
            else{
                nStr += str.charAt(i);
            }
        }
        return nStr;
    }
    public static int indexMax(int[] arr){
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if (arr[i] > max) max = arr[i];
        }
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == max) return i;
        }
        return -1;
    }


    public static String sevenBoom(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 7) return "BOOM";
        }
        return "there is no 7 in the array";
    }//Если есть 7 то BOOM
    public static boolean cons(int[] arr){
        arr = sort(arr);
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i+1] - arr[i] != 1) return false;
        }
        return true;
    }//Последовательность увеличивающихся чисел
    public static String unmix(String str){
        char[] strC = str.toCharArray();

        for(int i = 0; i < strC.length; i++){
            if(i % 2 == 0 && i != strC.length-1){
                char t = strC[i];
                strC[i] = strC[i+1];
                strC[i+1] = t;
            }
        }

        //return strC.toString();
        return charToString(strC);
    }//Поменять местами соседние буквы
    public static String noYelling(String str){
        for(int i = str.length()-1; i > 0; i--){
            if((str.charAt(i) == str.charAt(i-1) && str.charAt(i) == '!') || (str.charAt(i) == str.charAt(i-1) && str.charAt(i) == '?')){
                str = delsimv(str, str.length()-1);
            }
            else break;

        }
        return str;
    }//Удаляем в конце предложения лишние знаки
    public static String xPronounce(String str){

       String[] slova = str.split(" ");
       for(int i = 0; i < slova.length; i++){
           if(slova[i].equals("x")){
               slova[i] = zamenSimv(slova[i], 0, "ecks");
           }
           else if(slova[i].charAt(0) == 'x'){
               slova[i] = zamenSimv(slova[i], 0, "z");
           }
           for(int j = 1; j < slova[i].length(); j++){
               if(slova[i].charAt(j) == 'x'){
                   slova[i] = zamenSimv(slova[i], j, "cks");
               }
           }
       }

       String nStr = "";
        for(int i = 0; i < slova.length; i++){
            nStr += slova[i] + " ";
        }

       return nStr;
    }//Заменяем  x
    public static int largestGap(int [] arr){
        arr = sort(arr);
        int maxRazr = arr[1] - arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i-1] > maxRazr) maxRazr = arr[i] - arr[i-1];
        }
        return maxRazr;
    }//Максимальная разница между двумя соселними числами массива
    public static String commonLastVowel(String str){
        str = str.toLowerCase();
        String[] slova = str.split(" ");
        int[] buk = {0,0,0,0,0,0};

        for(int i = 0; i < slova.length; i++){
            if(slova[i].charAt(slova[i].length()-1) == 'a') buk[0] += 1;
            else if(slova[i].charAt(slova[i].length()-1) == 'e') buk[1] += 1;
            else if(slova[i].charAt(slova[i].length()-1) == 'i') buk[2] += 1;
            else if(slova[i].charAt(slova[i].length()-1) == 'o') buk[3] += 1;
            else if(slova[i].charAt(slova[i].length()-1) == 'u') buk[4] += 1;
            else if(slova[i].charAt(slova[i].length()-1) == 'y') buk[5] += 1;
        }

        if(indexMax(buk) == 0)return "a";
        else if(indexMax(buk) == 1)return "e";
        else if(indexMax(buk) == 2)return "i";
        else if(indexMax(buk) == 3)return "o";
        else if(indexMax(buk) == 4)return "u";
        else return "e";

    }//Часто встречаемая глассная на конце
    public static int memeSum(int val1, int val2){
        String st = "";
        while (val1 > 0 || val2 > 0){
            st = (val1 % 10 + val2 %10) + st;
            val1 /= 10;
            val2 /= 10;
        }
        return Integer.parseInt(st);
    }//Как считают гуманитарии
    public static String unrepeated(String str){
        boolean[] simv = new boolean[90];
        String nStr = "";

        for(int i = 0; i < simv.length; i++){
            simv[i] = false;
        }

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                nStr += str.charAt(i);
            }
            else {
                boolean b = simv[str.charAt(i) - 33];
                if (!b) {
                    nStr += str.charAt(i);
                    simv[str.charAt(i) - 33] = !b;
                }
            }
        }
        return nStr;
    }//Убираем повторяющиеся символы
    public static int func(int val){
        int kolSimv = 0;
        int valT = val;
        int val2 = val;
        while(valT > 0){
            valT /= 10;
            kolSimv++;
        }
        if(kolSimv % 2 == 1){
            for (int i = 0; i < kolSimv; i++){
                valT = valT * 10 + val2 % 10;
                val2 /= 10;
            }
        }
        else{
           int val3 = (int) (val % (Math.pow(10, kolSimv/2)));
           int val4 = (int) (val / (Math.pow(10, kolSimv/2)));

           valT = Integer.parseInt(Integer.toString(val3) + Integer.toString(val4));
        }
        if(val - valT < 0)return 0;
        return val - valT;
    }//Режем числа
    

}
