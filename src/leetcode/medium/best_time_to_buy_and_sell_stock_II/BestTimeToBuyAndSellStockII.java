package leetcode.medium.best_time_to_buy_and_sell_stock_II;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int sellingDate = 0;
        int buyingDate = 0;
        int totalProfit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] >= prices[i - 1])
                sellingDate++;
            else {
                totalProfit += (prices[sellingDate] - prices[buyingDate]);
                sellingDate = buyingDate = i;
            }
        }
        totalProfit += (prices[sellingDate] - prices[buyingDate]);
        return totalProfit;
    }
}
