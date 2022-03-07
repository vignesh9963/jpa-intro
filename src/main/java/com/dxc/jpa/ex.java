package com.dxc.jpa;

import java.util.Arrays;
import java.util.Scanner;

public class ex {
    public static  void main(String[] args) {



        Scanner scanner=new Scanner(System.in);
        int n1,size1,size2;
       n1= scanner.nextInt();


        for(int i=1;i<=n1;i++) {
            size1 = scanner.nextInt();
            int[] arr = new int[size1];

            for (int j = 0; j < size1; j++) {
                arr[j] = scanner.nextInt();
            }

            Arrays.sort(arr);
            for (int k = 0; k < size1; k++) {
                System.out.print(arr[k] + " ");
            }



        }


    }

}
