public class SellAndBuyStock {
    public static void main(String[] args) {
        int[] stocks = {5, 1, 2, 3, 4};
        System.out.println(maximumProfit(stocks));

    }

    public static int maximumProfit(int[] stocks){
        int profit = 0, n = stocks.length;
        for(int i=1;i<n;i++){
            if(stocks[i]>stocks[i-1]) {
                profit = profit + (stocks[i]-stocks[i-1]);
            }
        }
        return profit;
    }


}
