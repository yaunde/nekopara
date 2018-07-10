package hihocode.java;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("start1");
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int A = input.nextInt();
			int B = input.nextInt();
			if (A <= 100 && A >= 0 && B <= 100 && B >= 0) {
				System.out.println("----------------------------" + A + "++++++++++++++++++++++" + B);

			} else {
				System.out.println("请输入小于一百的正整数");
			}
		}
		System.out.println("end ");
		input.close();

	}

	public static void test() {

		System.out.println("请输入若干个数,每输入一个数用回车确认");
		System.out.println("最后输入一个非数字结束输入操作");
		Scanner reader = new Scanner(System.in);
		double sum = 0;
		int m = 0;
		while (reader.hasNextDouble()) {
			double x = reader.nextDouble();
			m = m + 1;
			sum = sum + x;
		}
		System.out.printf("%d个数的和为%f/n", m, sum);
		System.out.printf("%d个数的平均值是%f/n", m, sum / m);
	}

}