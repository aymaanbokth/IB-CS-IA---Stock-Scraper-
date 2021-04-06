package datacollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class FetchCurrentPrice {
    public static String method() throws IOException {
        URLConnection currentPriceURLConnection = KeyMetricsURL.fetchKeyMetricsURL();
        // obtains the current price
        InputStreamReader currentPriceInputStream = new InputStreamReader(currentPriceURLConnection.getInputStream());
        BufferedReader currentPriceBuff = new BufferedReader(currentPriceInputStream);
        String currentPrice = "not found";
        String currentPriceLine = currentPriceBuff.readLine();
        while (currentPriceLine != null) {
            if (currentPriceLine.contains("priceDisplay: '")) {
                int currentPriceTarget = currentPriceLine.indexOf("priceDisplay: '");
                int currentPriceDecimal = currentPriceLine.indexOf(".", currentPriceTarget);
                int currentPriceStart = currentPriceDecimal;
                while (currentPriceLine.charAt(currentPriceStart) != '\'') {
                    currentPriceStart--;
                }
                currentPrice = currentPriceLine.substring(currentPriceStart + 1, currentPriceDecimal + 2);
            }
            currentPriceLine = currentPriceBuff.readLine();
        }
        return currentPrice.toString();
    }
}


