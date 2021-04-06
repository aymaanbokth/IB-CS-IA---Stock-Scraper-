package datacollection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FetchBookValue {
    public static String fetchBookValue() {
        String keyMetricsURL = KeyMetricsURL.onlyURL();
        StringBuilder result = new StringBuilder();
        try {
            Document bookValueDocument = Jsoup.connect(keyMetricsURL).get();
            for (Element row : bookValueDocument.select("div.snapshot")) {
                if (row.select("div.snapshot__data-item:nth-of-type(11)").text().equals("")) {
                    continue;
                } else {
                    final String bookValueValue = row.select("div.snapshot__data-item:nth-of-type(11)").text();
                    result.append(bookValueValue, 0, 5);
                }
            }
        } catch (Exception bookValueDocumentException) {
            bookValueDocumentException.printStackTrace();
        }
        return result.toString();
    }
}

