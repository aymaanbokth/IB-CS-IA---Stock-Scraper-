package datacollection;
import gui.MainGUI;

public class KeyMetricsURL {

    public static String onlyURL() {
        if (MainGUI.usableInput != null) {
            String tickerSymbol = MainGUI.usableInput.toLowerCase();
            String urlBody1 = "https://markets.businessinsider.com/stocks/";
            String urlBody2 = "-stock";
            String finalURL = urlBody1 + tickerSymbol + urlBody2;
            return finalURL;
        }
        return "https://markets.businessinsider.com/stocks/";
    }
}


