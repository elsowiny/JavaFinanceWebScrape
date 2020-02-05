package elsowiny.finance;

import java.util.HashMap;

public class App {

	public static void main(String[] args) {
		//Array of Stocks
		String[] stocks = {"GS","S","AAPL","JPM"};
		
		//hash map with key being the ticker name, and the value being an
		//array that holds the company name in index 0
		//and the price of the stock in index 1
		HashMap<String,String[]> stockAndInfo = new HashMap<String,String[]>();
		
		//Given the Array of stock tickers, we will scrape each stock
		//and add the associated data to our hashmap for later use
		for (String stockVar: stocks) {
			Stock tempStock = new Stock();
			tempStock.stockScraper(stockVar);
			String[] compNameAndPrice = {tempStock.companyName,tempStock.price};
			stockAndInfo.put(stockVar, compNameAndPrice );
		}
		
		printStockInfo(stockAndInfo,stocks);
		
	}

	private	static void printStockInfo(HashMap<String, String[]> stockAndInfoHash, 
			String[] stocksArray) {
		
			for(String ticker: stocksArray) {
				String companyName = stockAndInfoHash.get(ticker)[0];
				String price = stockAndInfoHash.get(ticker)[1];
			
				System.out.print(companyName + " ");
				System.out.println(price);
		}
		
	}

	
}
