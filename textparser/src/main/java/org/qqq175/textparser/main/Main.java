package org.qqq175.textparser.main;

public class Main {
	public static String DEFAULT_FILEPATH = "text.txt";
	public static void main(String[] args) {
		String filePath = null;
		if(args.length == 0){
			filePath = DEFAULT_FILEPATH;
		}else{
			filePath = args[0];
		}
		App app = new App(filePath);
		app.start();
	}
}
