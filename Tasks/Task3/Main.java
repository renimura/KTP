package com.company;

public class Main {

    public static void main(String[] args) {
        //1 Номер
        Object[][] arrCity = {
                {"Nice", 942208},
                {"Abu Dhabi", 1482816},
                {"Naples", 2186853},
                {"Vatican City", 572}
        };

        arrCity = millionsRounding(arrCity);

        for(int i = 0; i < arrCity.length; i++){
            System.out.println(arrCity[i][0] + " " + arrCity[i][1]);
        }


        //2 Номер
        double[] arrStor = otherSides(2);
        for(int i = 0; i < arrStor.length; i++){
            System.out.println(arrStor[i]);
        }


        //3 Номер
        System.out.println(rps("ножницы", "бумага"));

        //4 Номер
        int[] arrVal = {5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243};
        System.out.println(warOfNumbers(arrVal));


        //5 Номер
        System.out.println(reverseCase("Hello World"));

        //6 Номер
        System.out.println(inatorInator("EvilClone"));
        //7 Номер
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));

        //8 Номер
        System.out.println(totalDistance(36.1, 8.6, 3, true));

        //9 Номер
        int[]arr = {2, 3, 2, 3};
        System.out.println(mean(arr));

        //10 Номер
        System.out.println(parityAnalysis(243));

    }

    public static Object[][] millionsRounding(Object[][] city){
        for(int i = 0; i < city.length; i++){
            if((int)(city[i][1]) % 1000000 >= 500000){
                city[i][1] = (int)city[i][1] + 1000000 - ((int)(city[i][1]) % 1000000);
            }
            else{
                city[i][1] = (int)city[i][1] - ((int)(city[i][1]) % 1000000);
            }
        }
        return city;
    }//Округление населения
    public static double[] otherSides(double st1){
        double st2, st3;
        st2 = 2 * st1;
        st3 =  Math.pow(Math.pow(st2, 2) - Math.pow(st1, 2), 0.5);
        double[] st = {st2, st3};
        return st;
    }//Нахождение сторон треугольника
    public static String rps(String hod1, String hod2){
        if(hod1.equals(hod2)) return "TIE";
        else if(hod1.equals("бумага")){
            if(hod2.equals("камень")) return "Player 1 wins";
            if(hod2.equals("ножницы"))return "Player 2 wins";
        }
        else if(hod1.equals("камень")){
            if(hod2.equals("ножницы")) return "Player 1 wins";
            if(hod2.equals("бумага"))return "Player 2 wins";
        }
        else if(hod1.equals("ножницы")){
            if(hod2.equals("бумага")) return "Player 1 wins";
            if(hod2.equals("камень"))return "Player 2 wins";
        }
        return "Введите камень, ножницы или бумага";
    }//Камень ножницы бумага
    public static int warOfNumbers(int[] arr){
        int sumchet = 0, sumnechet = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0){ sumchet += arr[i]; }
            else{ sumnechet += arr[i]; }
        }
        return sumchet - sumnechet;
    }//Разница между четными и нечетными
    public static String reverseCase(String str){
        char[] cstr = str.toCharArray();
        for(int i = 0; i < cstr.length; i++){
            if (cstr[i] > 64 && cstr[i] < 91) cstr[i] += 32;
            else if(cstr[i] > 96 && cstr[i] < 123) cstr[i] -= 32;
        }
        return new String(cstr);
    }//Смена регистра
    public static String inatorInator(String str) {
        String posSimv = "";
        posSimv += str.charAt(str.length()-1);

        int strLen = str.length();
        boolean test = posSimv.matches("^(?i:[aeiouy]).*");

        if(test){
            str += "-inator " + strLen + "000";
        }
        else{
            str += "inator " + strLen + "000";
        }
        return str;
    }//ТермИНАТОР
    public static boolean doesBrickFit(int dlin, int shir, int vis, int w, int h){
        return ((dlin <= w && (shir <= h || vis <= h)) || (shir <= w && (vis <= h || dlin <= h)) || (vis <= w && (shir <= h || dlin <= h)));
    }//Кирпич
    public static double totalDistance(double liters, double bazRashod, int pass, boolean cond){
        double finalRashod = bazRashod;
        if(pass > 0){
            finalRashod = bazRashod + (bazRashod/100 * 5 * pass);
        }
        if(cond) finalRashod += finalRashod / 10;
        return liters / finalRashod * 100;
    }//Валим на гелике
    public static double mean(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return (double)sum / arr.length;
    }//Среднее арифметическое
    public static boolean parityAnalysis(int val){
        int sumFig = 0, copyVal = val;
        while(val > 0){
            sumFig += val % 10;
            val /= 10;
        }
        return sumFig % 2 == copyVal % 2;
    }//Равна ли четность числа четности суммы его цифр


}
