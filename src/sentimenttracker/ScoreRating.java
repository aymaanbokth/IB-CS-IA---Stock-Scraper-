package sentimenttracker;
import datacollection.*;
import java.io.IOException;
public class ScoreRating {
     public static int stockScore() throws IOException {
        // outputs a score for the stock. The more points, the better the stock
        int stockScore = 0;
        // if 1 year price range is greater than 20, then 1 point. If less, then 0 points.

        // if price is greater than 10 dollars, than 1 points. If less than 10 dollars, then 0 point.
         //if (Double.parseDouble(FetchCurrentPrice.currentPrice()) >= 10)
        // {
            // stockScore++;
         //}
        // If market cap is greater than 1 billion but less than 50 billion, then 1 points.
         // If greater than 50 billion, then 0 point.

         String marketCapValue = FetchMarketCap.fetchMarketCap();
         String [] splitMarketCapValue = marketCapValue.split("\\s+");
         if (splitMarketCapValue[1].equals("B"))
         {
             float newMarketCapValue = (Float.parseFloat(splitMarketCapValue[0])) * 1000000000 ;
             if (newMarketCapValue > 1000000000 && newMarketCapValue < 50000000000L)
             {
                 stockScore++;
             }
             else if (splitMarketCapValue[1].equals("M"))
             {
                 newMarketCapValue = Float.parseFloat(splitMarketCapValue[0]) * 1000000 ;
                 if (newMarketCapValue > 1000000000 && newMarketCapValue < 50000000000L)
                 {
                     stockScore++;
                 }

             }
         }

        // if P/E ratio is greater than 15, then 1 point.
         if (Double.parseDouble(FetchPERatio.fetchPERatio()) >= 15)
         {
             stockScore++;
         }
        // if book value per share is greater than 2, than 1 points.
         if (Double.parseDouble(FetchBookValue.fetchBookValue()) >= 2);
         {
             stockScore++;
         }
        // if cash flow per share is greater than 3, than 1 points.
         if (Double.parseDouble(FetchCashFlow.fetchCashFlow()) >= 3)
         {
             stockScore++;
         }
    return stockScore;
    }
}
