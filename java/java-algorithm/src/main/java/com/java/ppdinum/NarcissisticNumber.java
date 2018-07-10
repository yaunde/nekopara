package com.java.ppdinum;

import java.util.Scanner;

public class NarcissisticNumber {
    public static Integer numPPDI(Integer minNum, Integer maxNum) {

        int total = 0; // 总的个数E
        if (minNum <= maxNum) {
            for (int i = minNum; i < maxNum; i++) {
                int k = 0; // 保存几位数
                int quotient = 0; // 保存商
                int remainder = 0; // 保存余数
                int sum = 0; // 保存和

                int num = i;

                // 判断几位数
                do {
                    k += 1;
                    num = num/10;
                } while (num > 0);

                // 如果是一位数，则一定是水仙花数
                if (k == 1){
                    sum = i;
                } else {
                    num = i;
                    for (int j = (k-1); j >= 0; j--) {
                        quotient = num/(int)Math.pow(10, j);
                        remainder = num%(int)Math.pow(10, j);
                        sum += (int)Math.pow(quotient, k);
                        num = remainder;
                    }
                }

                if (sum == i){
                    System.out.print(sum + " ");
                    total+=1;
                }
            }
            System.out.println("");
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);
        System.out.println("请输入两个整数（空格隔开）：a, b");

        int a = scan.nextInt();//输入的数字
        int b = scan.nextInt();//输入的数字

        if(a > b) {
            int total = numPPDI(b,a);
            System.out.println("数字"+b+"与数字"+a+"水仙花数的个数"+ total);
        }else {
            int total = numPPDI(a,b);
            System.out.println("数字"+a+"与数字"+b+"水仙花数的个数"+ total);
        }

//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        System.out.println(i);
        /*if(a > b) {
            System.out.println("最大值为："+a);
            System.out.println("最小值为："+b);
        }else {
            System.out.println("最大值为："+b);
            System.out.println("最小值为："+a);
        }*/
    }
}
