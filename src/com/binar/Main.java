package com.binar;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        int arr[] = {6,6,3,9,9,3};
//        int arr[] = {5, 7, 9, 13, 11, 6, 6, 3, 3};

        System.out.println("Hasilnya : "+sumOf12(arr, 12));
    }

    static int sumOf12(int[] arr, int target){


        // Jika ada jumlah 2 Index = 12, maka jumlah profile target +1

        // Jika jumlah angka pertama dan angka kedua sama persis, maka tidak dihitung
        // Contoh seperti jumlah 9 dan 3

        int totalSumOf12 = 0;

        //Loop untuk setiap index
        ArrayList<PairOfNumber> listOfNumber = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            int bil1 = arr[i];

            //Loop untuk membandingkan dengan index selain dirinya sendiri
            for(int j = 0; j < arr.length; j++){
                int sumTemp;

                int bil2 = arr[j];

                //Menyeleksi agar tidak menjumlahkan dengan dirinya sendiri
                if(j != i){
                    sumTemp = bil1 + bil2;
                    if(sumTemp == target){
                            listOfNumber.add(new PairOfNumber(i,j));
                            totalSumOf12++;
                    }
                }
            }
        }

        listOfNumber = distincArray(listOfNumber);
        System.out.println("Distinc array : "+listOfNumber.size());
        return totalSumOf12;
    }

    static ArrayList<PairOfNumber> distincArray(ArrayList<PairOfNumber> arrOfIndex){
        ArrayList<PairOfNumber> newArr = new ArrayList<>();


        for(int i=0; i<arrOfIndex.size(); i++){
            if(newArr.isEmpty()){
                newArr.add(arrOfIndex.get(i));
            }else{
                //Loop bil 2 di index sebelumnya
                // TODO : Distinc Inversed Array again arrOfIndex ([2,3] != [3,2])
                for(int k=0; k<newArr.size(); k++){
                    if(arrOfIndex.get(i).indexBil1 != newArr.get(k).indexBil2){
                        newArr.add(arrOfIndex.get(i));
                        break;
                    }
                }
            }
        }
        return newArr;
    }
}
