package sentimenttracker;
import datacollection.*;
import java.io.IOException;

public class ScoreRating {
    public static int stockScore() throws IOException {
        try {
            int stockScore = 0;

            // If market cap is greater than 1 billion but less than 50 billion, then 1 points.
            // If greater than 50 billion, then 0 point.
            String marketCapValue = FetchMarketCap.fetchMarketCap();
            String[] splitMarketCapValue = marketCapValue.split("\\s+");
            if (splitMarketCapValue[1].equals("B")) {
                Float newMarketCapValue = (Float.parseFloat(splitMarketCapValue[0].replaceAll(",", ""))) * 1000000000;
                if (newMarketCapValue > 1000000000 && newMarketCapValue < 50000000000L) {
                    stockScore++;
                } else if (splitMarketCapValue[1].equals("M")) {
                    newMarketCapValue = (Float.parseFloat(splitMarketCapValue[0].replaceAll(",", ""))) * 1000000;
                    if (newMarketCapValue > 1000000000 && newMarketCapValue < 50000000000L) {
                        stockScore++;
                    }

                }
            }

            // if P/E ratio is greater than 15, then 1 point.
            if (Double.parseDouble(FetchPERatio.fetchPERatio()) >= 15) {
                stockScore++;
            }
            // if book value per share is greater than 2, than 1 points.
            if (Double.parseDouble(FetchBookValue.fetchBookValue()) >= 2) ;
            {
                stockScore++;
            }
            // if cash flow per share is greater than 3, than 1 points.
            if (FetchCashFlow.fetchCashFlow() == " ") {
                if (FetchCashFlow.fetchCashFlow() == " ") {
                    stockScore = stockScore + 0;
                }
                else if (Double.parseDouble(FetchCashFlow.fetchCashFlow()) >= 3) {
                    stockScore++;
                }
            }
            //If free float is greater than 50.0, then one point
            if (Double.parseDouble(FetchFreeFloat.freeFloatOutput()) >= 50.00) {
                stockScore++;
            }
            return stockScore;
        }
        catch (ArrayIndexOutOfBoundsException e){
            return 0;
        }
    }
}
