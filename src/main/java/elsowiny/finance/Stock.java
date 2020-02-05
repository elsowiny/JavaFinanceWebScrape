package elsowiny.finance;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Stock 
{
	String url = "https://finance.yahoo.com/quote/%s?p=%s";
	String priceElementClassName = "Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)";
	String companyNameClassName = "D(ib) Fz(18px)";
	//program will scrape for this information
	String price;
	String companyName;
	
      void stockScraper(String stockSymbol) {
		try {
			Document doc = Jsoup.connect(
					String.format(url, stockSymbol,stockSymbol)).get();
			
			Elements stockPriceElement = doc.getElementsByClass(priceElementClassName);
			//check for valid Stock ticker
				if (stockPriceElement.isEmpty()){
					this.companyName = "invalid company";
					this.price = "##";
				}else {
					this.price = stockPriceElement.text();
					Elements companyNameElement = doc.getElementsByClass(companyNameClassName);
					this.companyName = companyNameElement.text();
		}
				}
				catch (IOException e) {
					e.printStackTrace();
		}
		
	}

}
