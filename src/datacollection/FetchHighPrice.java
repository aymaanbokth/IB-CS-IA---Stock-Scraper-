package datacollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class FetchHighPrice {
    String method() throws IOException {
        URLConnection highPriceURLConnection = KeyMetricsURL.fetchKeyMetricsURL();
        InputStreamReader highPriceInputStream = new InputStreamReader(highPriceURLConnection.getInputStream());
        BufferedReader highPriceBuff = new BufferedReader(highPriceInputStream);
        String highPrice = "not found";
        String highPriceLine = highPriceBuff.readLine();
        while (highPriceLine != null) {
            if (highPriceLine.contains("high52weeksDisplay: '")) {
                int highPriceTarget = highPriceLine.indexOf("high52weeksDisplay: '");
                int highPriceDecimal = highPriceLine.indexOf(".", highPriceTarget);
                int highPriceStart = highPriceDecimal;
                while (highPriceLine.charAt(highPriceStart) != '\'') {
                    highPriceStart--;
                }
                highPrice = highPriceLine.substring(highPriceStart + 1, highPriceDecimal + 3);
            }
            highPriceLine = highPriceBuff.readLine();
        }
        return highPrice.toString();
    }
}
