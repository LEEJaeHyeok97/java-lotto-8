package lotto.view;

import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningRank;
import lotto.model.vo.Lotto;

public class OutputView {

    public static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public void printPurchaseCount(int count) {
        System.out.printf(LINE_SEPARATOR + PURCHASE_COUNT_MESSAGE, count);
        printWhiteSpace();
    }

    public void printIssuedLottos(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        printWhiteSpace();
    }

    public void printWinningStatistics(LottoResult result) {
        System.out.println(LINE_SEPARATOR + "당첨 통계");
        System.out.println("---");

        for (WinningRank rank : WinningRank.displayValues()) {
            printRankResult(rank, result.countByRank(rank));
            printWhiteSpace();
        }

        System.out.printf("총 수익률은 %.1f%%입니다.", result.calculateProfitRate());
    }

    public void printError(String message) {
        System.out.println(message);
    }

    private void printRankResult(WinningRank rank, int count) {
        System.out.printf("%d개 일치%s (%,d원) - %d개", rank.getMatchCount(),
                isBonusMatch(rank),
                rank.getPrize(),
                count);
    }

    private static String isBonusMatch(WinningRank rank) {
        String bonusText = "";
        if (rank.isBonusMatch()) {
            bonusText = ", 보너스 볼 일치";
        }

        return bonusText;
    }

    private void printWhiteSpace() {
        System.out.println();
    }
}
