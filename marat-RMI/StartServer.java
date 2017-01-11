package com.marat.Lesson_10_RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class StartServer {

	public static void main(String[] args) {

		try {
			
			StockServerImpl ssi = new StockServerImpl();
			Naming.rebind("rmi://localhost:1099/QuoteService", ssi);
			
			System.out.println("<QuoteService> server is ready...");
			
		}catch(MalformedURLException e1){
			System.out.println(e1.getMessage());
		}catch(RemoteException ex){
			ex.printStackTrace();
		}
	}
}
