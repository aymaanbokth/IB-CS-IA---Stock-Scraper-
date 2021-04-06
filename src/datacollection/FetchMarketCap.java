package datacollection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FetchMarketCap {
    public static String fetchMarketCap() {
        String keyMetricsURL = KeyMetricsURL.onlyURL();
        StringBuilder result = new StringBuilder();
        try {
            Document marketCapDocument = Jsoup.connect(keyMetricsURL).get();
            for (Element row : marketCapDocument.select("div.snapshot")) {
                if (row.select("div.snapshot__data-item:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    String marketCapValue = row.select("div.snapshot__data-item:nth-of-type(3)").text();
                    String[] workingMarketCapValue = marketCapValue.split("\\s+");
                    String workingMarketCapValue0 = workingMarketCapValue[0];
                    String workingMarketCapValue1 = workingMarketCapValue[1];
                    String finalMarketCapValue = workingMarketCapValue0 + " " + workingMarketCapValue1;
                    result.append(finalMarketCapValue);
                }
            }
        } catch (Exception marketCapDocumentException) {
            marketCapDocumentException.printStackTrace();
        }
        return result.toString();
    }
}
