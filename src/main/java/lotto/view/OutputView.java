package lotto.view;

import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningRank;
import lotto.model.vo.Lotto;
import lotto.model.vo.PurchaseAmount;

public class OutputView {

    public static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    public static final String SECTION_DIVIDER = "---";
    public static final String PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";
    public static final String RANK_RESULT_MESSAGE_FORMAT = "%d개 일치%s (%,d원) - %d개";
    public static final String NON_BONUS_MATCH_MESSAGE = "";
    public static final String BONUS_MATCH_MESSAGE = ", 보너스 볼 일치";

    public void printPurchaseCount(PurchaseAmount purchaseAmount) {
        System.out.printf(LINE_SEPARATOR + PURCHASE_COUNT_MESSAGE, purchaseAmount.calculateQuantity());
        printWhiteSpace();
    }

    public void printIssuedLottos(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        printWhiteSpace();
    }

    public void printWinningStatistics(LottoResult result) {
        System.out.println(LINE_SEPARATOR + WINNING_STATISTICS_HEADER);
        System.out.println(SECTION_DIVIDER);

        for (WinningRank rank : WinningRank.displayValues()) {
            printRankResult(rank, result.countByRank(rank));
            printWhiteSpace();
        }

        System.out.printf(PROFIT_RATE_MESSAGE_FORMAT, result.calculateProfitRate());
    }

    public void printError(String message) {
        System.out.println(message);
    }

    private void printRankResult(WinningRank rank, int count) {
        System.out.printf(RANK_RESULT_MESSAGE_FORMAT, rank.getMatchCount(),
                isBonusMatch(rank),
                rank.getPrize(),
                count);
    }

    private static String isBonusMatch(WinningRank rank) {
        String bonusText = NON_BONUS_MATCH_MESSAGE;
        if (rank.isBonusMatch()) {
            bonusText = BONUS_MATCH_MESSAGE;
        }

        return bonusText;
    }

    private void printWhiteSpace() {
        System.out.println();
    }
}
