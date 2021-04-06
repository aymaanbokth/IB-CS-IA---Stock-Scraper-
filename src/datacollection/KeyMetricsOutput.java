package datacollection;

import sentimenttracker.ScoreRating;

import java.io.IOException;

public class KeyMetricsOutput {
    public static void main (String [] args) throws IOException {
        String marketCapOutput = FetchMarketCap.fetchMarketCap();
        System.out.println("Market cap: " + marketCapOutput);

        String floatOutput = FetchFloat.fetchFloat();
        System.out.println("Float: " + floatOutput);


        String peRatioOutput = FetchPERatio.fetchPERatio();
        System.out.println("PE Ratio: " + peRatioOutput);

        String bookValueOutput = FetchBookValue.fetchBookValue();
        System.out.println("Book Value per Share: " + bookValueOutput);

        String cashFlowOutput = FetchCashFlow.fetchCashFlow();
        System.out.println("Cash Flow per Share: " + cashFlowOutput);


        FetchCurrentPrice cp = new FetchCurrentPrice();
        String currentPriceOutput = cp.method();
        System.out.println("Current Price: " + currentPriceOutput);

        FetchHighPrice hp = new FetchHighPrice();
        String highPriceOutput = hp.method();
        System.out.println("Yearly High Price: " + highPriceOutput);

        FetchLowPrice lp = new FetchLowPrice();
        String lowPriceOutput = lp.method();
        System.out.println("Yearly Low Price: " + lowPriceOutput);

        FetchOneYearPriceRange pr = new FetchOneYearPriceRange();
        Double priceRangeOutput = pr.method();
        System.out.println("One Year Price Range: " + priceRangeOutput);

        ScoreRating score = new ScoreRating();
        int scoreOutput = score.stockScore();
        System.out.println("Stock Score: " + scoreOutput);
    }
}


