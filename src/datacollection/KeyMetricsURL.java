package datacollection;


import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class KeyMetricsURL {

    public static URLConnection fetchKeyMetricsURL() throws IOException
    {
        URL keyMetricsURL = new URL ("https://markets.businessinsider.com/stocks/KO-stock");
        URLConnection PriceURLConnection = keyMetricsURL.openConnection();
        return PriceURLConnection;
    }

    public static String onlyURL() {
        String onlyURL =  "https://markets.businessinsider.com/stocks/KO-stock";
        return onlyURL;
    }

}


