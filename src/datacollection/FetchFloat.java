package datacollection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FetchFloat {
    public static String fetchFloat() {
        String keyMetricsURL = KeyMetricsURL.onlyURL();
        StringBuilder result = new StringBuilder();
        try {
            Document floatDocument = Jsoup.connect(keyMetricsURL).get();
            for (Element row : floatDocument.select("div.snapshot")) {
                if (row.select("div.snapshot__data-item:nth-of-type(4)").text().equals("")) {
                    continue;
                } else {
                    String floatValue = row.select("div.snapshot__data-item:nth-of-type(4)").text();
                    String[] workingFloatValue = floatValue.split("\\s+");
                    String workingFloatValue0 = workingFloatValue[0];
                    String workingFloatValue1 = workingFloatValue[1];
                    String finalFloatValue = workingFloatValue0 + " " + workingFloatValue1;

                    result.append(finalFloatValue);
                }
            }
        } catch (Exception floatDocumentException) {
            floatDocumentException.printStackTrace();
        }
        return result.toString();
    }
}