package datacollection;

// make sure to figure out how to have the accept input for ticker symbol.

import java.io.IOException;

public class FetchOneYearPriceRange {
    public static Double method() throws IOException {
        // Obtains one year price range

        FetchHighPrice hp = new FetchHighPrice();
        String highPriceOutput = hp.method();

        FetchLowPrice lp = new FetchLowPrice();
        String lowPriceOutput = lp.method();

        double oneYearPriceRange = Math.round(((Double.parseDouble(highPriceOutput)) - (Double.parseDouble(lowPriceOutput))) * (100.0)) / 100.0;

        return oneYearPriceRange;
    }
}





