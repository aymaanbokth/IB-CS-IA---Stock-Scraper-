package datacollection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class FetchPreviousClose {

    public static String previousClose () {
        String keyMetricsURL = "https://markets.businessinsider.com/stocks/ko-stock";

        StringBuilder result = new StringBuilder();
        try {
            Document previousCloseDocument = Jsoup.connect(keyMetricsURL).get();
            for (Element row : previousCloseDocument.select("div.snapshot")) {
                if (row.select("div.snapshot__data-item:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {
                    final String previousCloseValue = row.select("div.snapshot__data-item:nth-of-type(1)").text();
                    result.append(previousCloseValue, 0, 5);
                }
            }
        } catch (Exception previousCloseValueDocumentException) {
            previousCloseValueDocumentException.printStackTrace();
        }
        System.out.println(result.toString());
        return result.toString();
    }
}


