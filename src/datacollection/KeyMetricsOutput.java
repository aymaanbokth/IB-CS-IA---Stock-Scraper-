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

        FetchPreviousClose pc = new FetchPreviousClose();
        String previousClose = pc.toString();
        System.out.println("Previous Close: " + previousClose);


        ScoreRating score = new ScoreRating();
        int scoreOutput = score.stockScore();
        System.out.println("Stock Score: " + scoreOutput);
    }
}


