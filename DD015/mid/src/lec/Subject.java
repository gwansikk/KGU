package lec;

import java.util.Scanner;

public class Subject {
	// DD746 	â�Ǳ��ʼ���	1 �� 123
	String code;
	String title;
	int year;
	String date;
	String time;
	Subject(String code) {
		this.code = code;
	}
	void read(Scanner scan) {
		title = scan.next();
		year = scan.nextInt();
		date = scan.next();
		time = scan.next();
	}
	void print() {
		System.out.format("[%s] %s %d�г� %s%s\n", 
				code, title, year, date, time);
	}
	boolean matches(String token) {
		// TODO Auto-generated method stub
		if (token.equals(code))
			return true;
		return false;
	}
}









