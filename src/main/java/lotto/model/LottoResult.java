package lotto.model;

import lotto.model.vo.PurchaseAmount;

public class LottoResult {

    public static final int DECIMAL_ROUNDING_SCALE = 10;
    public static final double ONE_DECIMAL_DIVISOR = 10.0;

    private final WinningRankCalculator calculator;
    private final PurchaseAmount purchaseAmount;

    public LottoResult(WinningRankCalculator calculator, PurchaseAmount purchaseAmount) {
        this.calculator = calculator;
        this.purchaseAmount = purchaseAmount;
    }

    public double calculateProfitRate() {
        int totalPrize = calculator.calculateSum();
        return roundToFirstDecimal(calculateProfitPercentage((double) totalPrize));
    }

    private double calculateProfitPercentage(double totalPrize) {
        return totalPrize / purchaseAmount.getAmount() * 100;
    }

    private static double roundToFirstDecimal(double rate) {
        return Math.round(rate * DECIMAL_ROUNDING_SCALE) / ONE_DECIMAL_DIVISOR;
    }
}
