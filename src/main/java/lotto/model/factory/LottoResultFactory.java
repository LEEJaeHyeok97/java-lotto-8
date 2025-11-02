package lotto.model.factory;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningInfo;
import lotto.model.WinningRank;
import lotto.model.WinningRankCalculator;
import lotto.model.vo.Lotto;
import lotto.model.vo.PurchaseAmount;

public class LottoResultFactory {

    public LottoResultFactory() {
    }

    public static LottoResult create(WinningInfo winningInfo, Lottos lottos, PurchaseAmount purchaseAmount) {
        List<WinningRank> ranks = calculateRanks(winningInfo, lottos);
        WinningRankCalculator calculator = WinningRankCalculator.of(ranks);
        return LottoResult.of(calculator, purchaseAmount);
    }

    private static List<WinningRank> calculateRanks(WinningInfo winningInfo, Lottos lottos) {
        List<WinningRank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            ranks.add(winningInfo.judgeRank(lotto));
        }

        return ranks;
    }
}
