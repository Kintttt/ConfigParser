package main.java;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		String str = "";
		if (args.length > 0)
			str = args[0];
		ConfigParser configParser = new ConfigParser(str);
		System.out.println("Please Enter A key To get the value");
		System.out.println(configParser.get(userInput.next()));


	}

}
