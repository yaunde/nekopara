package com.java.ppdinum;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PPDINumber {

    public static List<Integer> numPPDI(Integer minNum, Integer maxNum) {
        List<Integer> result = new ArrayList<Integer>(); // 返回的水仙花数

        if (minNum <= maxNum){
            for(int i = minNum; i<= maxNum; i++){
                int quotient = 0; // 保存商
                int remainder = 0; // 保存余数
                int k = 0; // 保存位数
                int sum = 0; // 保存总数

                int num = i; //保存当前数，防止被修改

                // 判断当前数字的位数
                do {
                    k+=1;
                    num = num/10;
                } while(num > 0);

                // 如果当前数是各位数，则不必运算，一定是水仙花数
                if (k==1){
                    sum = i;
                } else {
                    num = i;
                    // 对数字位数进行幂运算
                    for(int j=(k-1); j>=0; j--){
                        quotient = num/(int)Math.pow(10,j);
                        remainder = num%(int)Math.pow(10,j);

                        sum += (int)Math.pow(quotient, k);
                        num = remainder;
                    }
                }
                if (sum == i){
                    result.add(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int minNum = sc.nextInt();
            int maxNum = sc.nextInt();

            if(100<=minNum && minNum<=999 && 100<=maxNum && maxNum<=999){
                List<Integer> result = numPPDI(minNum,maxNum);
                if (result.size()==0){
                    System.out.println("no");
                } else {
                    for(int i=0; i<result.size()-1;i++){
                        System.out.print(result.get(i)+" ");
                    }
                    System.out.println(result.get(result.size()-1));
                }
            }
        }


    }
}