package datacollection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class FetchCashFlow {
    public static String fetchCashFlow() throws IOException {
        String keyMetricsURL = KeyMetricsURL.onlyURL();
        StringBuilder result = new StringBuilder();
        try {
            Document cashFlowDocument = Jsoup.connect(keyMetricsURL).get();
            for (Element row : cashFlowDocument.select("div.snapshot")) {
                if (row.select("div.snapshot__data-item:nth-of-type(12)").text().equals("")) {
                    continue;
                } else {
                    final String cashFlowValue = row.select("div.snapshot__data-item:nth-of-type(12)").text();
                    result.append(cashFlowValue, 0, 5);
                }
            }
        } catch (Exception cashFlowDocumentException) {
            cashFlowDocumentException.printStackTrace();
        }
        return result.toString();
    }
}

