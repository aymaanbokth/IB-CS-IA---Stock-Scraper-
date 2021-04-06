package datacollection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FetchPERatio {
    public static String fetchPERatio() {
        String keyMetricsURL = KeyMetricsURL.onlyURL();
        StringBuilder result = new StringBuilder();
        try {
            Document peRatioDocument = Jsoup.connect(keyMetricsURL).get();
            for (Element row : peRatioDocument.select("div.snapshot")) {
                if (row.select("div.snapshot__data-item:nth-of-type(8)").text().equals("")) {
                    continue;
                } else {
                    final String peRatioValue = row.select("div.snapshot__data-item:nth-of-type(8)").text();
                    result.append(peRatioValue, 0, 6);
                }
            }
        } catch (Exception peDocumentException) {
            peDocumentException.printStackTrace();
        }
        return result.toString();
    }
}


