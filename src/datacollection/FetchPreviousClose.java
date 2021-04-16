package datacollection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FetchPreviousClose {
    public static String previousClose () {
        String keyMetricsURL = KeyMetricsURL.onlyURL();
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
        String finalPreviousclose = result.toString();
        return finalPreviousclose;
    }
}


