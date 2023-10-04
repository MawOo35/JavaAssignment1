package SampleMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmapleMethodProject {

	public static void main(String[] args) {
		List<String> posts = new ArrayList<>();
		while(true) {
			 System.out.println("実施したい処理を選択してください");
			 System.out.println("1:評価ポイントとコメントを入力する");
	         System.out.println("2:今までの結果を確認する");
	         System.out.println("3:終了する");
	         Scanner sc = new Scanner(System.in);
	         String num = sc.nextLine();
	         switch(num) {
	         case "1":
	        	 calculateFileWrite(sc,posts);
	        	 break;
	         case "2":
	        	 calculateFileRead();
	        	 break;
	         case "3":
	        	 System.out.println("終了します");
                 System.exit(0);
             default:
                 System.out.println("1から3で入力してください");	         
	         }			
		}
	}

    private static void calculateFileWrite(Scanner sc,List<String> posts) {
    	while(true) {
    		System.out.println("1から5で評価を入力してください");
    		 String input = sc.nextLine();
    		 if(input.matches("[+-]?\\d*(\\.\\d+)?")) {
    			 int point = Integer.parseInt(input);
    			 if(0 >= point || point > 5) {
    				 System.out.println("1から5の数字を入力してください");
    			 }else {
    				 System.out.println( "コメントを入力してください");
        			 String comment  = sc.nextLine();
        			 posts.add(String.format("ポイント：%s コメント：%s\r\n", point, comment));
        			 try {
        				 File file = new File("C:\\workspace\\sample\\data.txt");
                         FileWriter filewriter = new FileWriter(file);
                         for (String post : posts) {
                             filewriter.write(post);
                         }
                         filewriter.close();
        			 }catch(FileNotFoundException e) {
        				 System.out.print(e); 
        			 }catch(IOException e) {
        				 System.out.print(e); 
        				 	 }break;
    			 }    			 
    		 }else {
    			 System.out.println("数字を入力してください");
    		 }   		 
    	}  	
    }
    
    private static void calculateFileRead() {
    	 try {
    		 File file = new File("C:\\workspace\\sample\\data.txt");
             FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             String text;
             while ((text = bufferedReader.readLine()) != null) {
                 System.out.println((String)text);
             }
             bufferedReader.close();
             fileReader.close();  		 
    	 }catch(FileNotFoundException e) {
    		 System.out.println(e);
    	 }catch(IOException e) {
    		 System.out.println(e);		 
    	 }	 
    }
}
