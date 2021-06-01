import java.util.Random;
import java.io.*;  
import java.util.Scanner;

import java.util.ArrayList;  
import java.util.Arrays;    
import java.util.*;

public class Main {
	public static void main(String[] args)throws Exception  {
		
	

		Scanner sc = new Scanner(new File("CENG112_HW4.csv"));  
		sc.useDelimiter("[\\r?\\n,]+"); 
		  //sets the delimiter pattern  
		int count = 0;
		List <String> fNames = new ArrayList<String>();
		List <String> fPrices = new ArrayList<String>();
		List <String> fStocks = new ArrayList<String>();
		List <String> rNames = new ArrayList<String>();
		List <String> rRatings = new ArrayList<String>();
		List <String> rCuisines = new ArrayList<String>();
		List <String> rDeliveries = new ArrayList<String>();

		while (sc.hasNext())  // her tablodaki her elemanı ilgli array liste atıyorum. 
		//Datayı daha temiz hala çektim , gerektiği yerde kolayca kullanak diye.
		{ 
			count +=1;
			if(count ==1){
				fNames.add(sc.next());
			}
			else if(count ==2){
				fPrices.add(sc.next());
			}
			else if(count ==3){
				fStocks.add(sc.next());
			}
			else if(count ==4){
				rNames.add(sc.next());
			}
			else if(count ==5){
				rRatings.add(sc.next());
			}
			else if(count ==6){
				rCuisines.add(sc.next());
			}
			else if(count == 7){
				rDeliveries.add(sc.next());
				count = 0;
			}
		}
		System.out.println("fNmes:" + fNames);
		System.out.println(" ");
		System.out.println("fStocks:" + fStocks);
		System.out.println(" ");
		System.out.println("rDeliveries:" + rDeliveries);
	
		sc.close();
	}
}
