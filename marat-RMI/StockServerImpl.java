package com.marat.Lesson_10_RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StockServerImpl extends UnicastRemoteObject implements StockServer{

	private String price = null;
	private ArrayList<String> nasdaqSymbols = new ArrayList<>();
	
	public StockServerImpl() throws RemoteException {
		super();
		LocateRegistry.createRegistry(1099); // регистр
		
		nasdaqSymbols.add("AAPL");
		nasdaqSymbols.add("MSFT");
		nasdaqSymbols.add("YHOO");
		nasdaqSymbols.add("AMZN");
		nasdaqSymbols.add("MOT");
	}

	@Override
	public String getQuote(String symbol) throws RemoteException {
		
		if(nasdaqSymbols.indexOf(symbol.toUpperCase()) != -1){
			//generate a random price
			price = (new Double(Math.random() * 100)).toString();
		}
		
		return price;
	}

	@Override
	public List<String> getNasdaqSymbols() throws RemoteException {

		return nasdaqSymbols;
	}
	
}
