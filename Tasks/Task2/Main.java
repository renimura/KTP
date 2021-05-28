package com.company;

public class Main {

    public static void main(String[] args) {
                System.out.println(oppositeHouse(5, 46));
                System.out.println(nameShuffle2("Kirill Abramov"));
                System.out.println(discount(89, 20));

                int[] arr1 = {1,2,3,4,5};
                System.out.println(differenceMaxMin(arr1));

                System.out.println(equal(3, 2, 3));
                System.out.println(reverse("Hello world"));
                System.out.println(programmers(147, 33, 526));
                System.out.println(getXO("ooxXmpxOOx"));
                System.out.println(bomb("asfBoMb"));
                System.out.println(sameAscii("AA", "B@"));


            }



            public static int oppositeHouse(int numH, int lSt){
                return lSt * 2 - numH + 1;
            } //Номер дома
            public static String nameShuffle(String allName){
                String name = "";
                String fam = "";
                boolean prob = false;
                for(int i = 0; i < allName.length(); i++){
                    if(allName.charAt(i) != ' ') {
                        if (!prob) {
                            name += allName.charAt(i);
                        } else {
                            fam += allName.charAt(i);
                        }
                    }
                    else prob = true;
                }
                return fam + " " + name;
            }//Меняем местами имя и фамилию
            public static String nameShuffle2(String allName){
                String[] allN;
                allN = allName.split(" ");
                return allN[1] + " " + allN[0];
            }//Меняем местами имя и фамилию(2)
            public static double discount(double price, int sale){
                return price - (price / 100 * sale);
            }//Высчитываем стоимость
            public static int differenceMaxMin(int[] arr){
                int min = arr[0];
                int max = arr[0];

                for(int i = 0; i < arr.length; i++){
                    if (arr[i] < min){
                        min = arr[i];
                    }
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }

                return max - min;
            }//Разность между минимумом и максимумом
            public static int equal(int val1, int val2, int val3){
                if(val1 == val2 && val1 == val3){
                    return 3;
                }
                else if(val1 == val2 || val1 == val3 || val2 == val3){
                    return 2;
                }
                return 0;
            }//Количество одинаковы чисел
            public static String reverse(String str){
                String t = "";
                for(int i = str.length() - 1; i >= 0; i--){
                    t += str.charAt(i);
                }
                return t;
            }//Разворачиваем строку
            public static int programmers(int zp1, int zp2, int zp3){
                int[] arr = {zp1, zp2, zp3};
                return differenceMaxMin(arr);
            }//Разница между ЗП
            public static boolean getXO(String str){
                int kolx = 0, kolo = 0;
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == 'o' || str.charAt(i) == 'O') kolo += 1;
                    else if(str.charAt(i) == 'x' || str.charAt(i) == 'X') kolx += 1;
                }
                return kolo == kolx;
            }//Крестики нолики
            public static String bomb(String str){
                String strT = str.toLowerCase();
                int indexBomb = strT.indexOf("bomb");
                if(indexBomb == -1)return "VSE OK";
                return "BOMB";
            }//Бомба
            public static boolean sameAscii(String str1, String str2){
                int sumStr1 = 0, sumStr2 = 0;
                for(int i = 0; i < str1.length(); i++){
                    sumStr1 += str1.charAt(i);
                }
                for(int i = 0; i < str2.length(); i++){
                    sumStr2 += str2.charAt(i);
                }
                return sumStr1 == sumStr2;
            }//Сумма символов ASCII



        }

