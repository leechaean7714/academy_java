package com.cal01;

import java.util.Scanner;

public class DayOfCalendar {

	// java.util.Calendar 클래스를 사용하지 않고 달력을 출력하자
	// hint : year년 month월 -> year.month.1일의 요일 -> 공백

	// 해당요일만큼 공백 출력 / 나머지부터 날짜 출력

	// 윤년 계산

	public static boolean isLeapYear(int year) {
		boolean leap = false;

		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			leap = true;
		}
		return leap;
	}

	// 일수 계산 (year, month) : int

	public static int dates(int year, int month) {
		int res = 0;

		if (isLeapYear(year)) {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				res = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				res = 30;
				break;
			case 2:
				res = 29;
				break;
			}

		} else {

			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				res = 31;

			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				res = 30;

			} else if (month == 2) {
				res = 28;
			}

		}

		return res;
	}

	// 해당 월의 첫번째 요일

	private static int whatDay(int year, int month) {
		int dayOfWeek = 0;

		int sum = 0;
		// 1.1.1 ~ year-1.12.31
		for (int i = 1; i < year; i++) {
			for (int j = 1; j <= 12; j++) {
				sum += dates(i, j);

			}
		}
		// year.1.1. ~ year.month-1.last
		for (int i = 1; i < month; i++) {
			sum += dates(year, i);
		}

		// +1 (year.month.1의 요일)
		sum += 1;

		// 요일 계산
		dayOfWeek = sum % 7;

		return dayOfWeek;

	}

	// 출력

	public static void prn(int year, int month) {

		System.out.printf("\t\t%d년 %d월\n", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");

		// 시작 요일
		int start = whatDay(year, month);

		// 마지막 날짜
		int last = dates(year, month);

		// 해당 시작 요일만큼 빈칸
		for (int i = 0; i < start; i++) {
			System.out.print("\t");
		}

		// 출력

		int cnt = start;
		for (int i = 1; i <= last; i++) {
			System.out.printf("%d\t", i);
			cnt++;
			if (cnt % 7 == 0) {
				System.out.println();
			}
		}
	}

}
