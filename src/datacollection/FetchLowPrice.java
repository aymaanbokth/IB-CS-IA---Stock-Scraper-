package datacollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;

public class FetchLowPrice {
    String method() throws IOException {
        URLConnection lowPriceURLConnection = KeyMetricsURL.fetchKeyMetricsURL();
        InputStreamReader lowPriceInputStream = new InputStreamReader(lowPriceURLConnection.getInputStream());
        BufferedReader lowPriceBuff = new BufferedReader(lowPriceInputStream);
        String lowPrice = "not found";
        String lowPriceLine = lowPriceBuff.readLine();
        while (lowPriceLine != null) {
            if (lowPriceLine.contains("low52weeksDisplay: '")) {
                int lowPriceTarget = lowPriceLine.indexOf("low52weeksDisplay: '");
                int lowPriceDecimal = lowPriceLine.indexOf(".", lowPriceTarget);
                int lowPriceStart = lowPriceDecimal;
                while (lowPriceLine.charAt(lowPriceStart) != '\'') {
                    lowPriceStart--;
                }
                lowPrice = lowPriceLine.substring(lowPriceStart + 1, lowPriceDecimal + 3);
            }
            lowPriceLine = lowPriceBuff.readLine();
        }
        return lowPrice.toString();
    }
}
