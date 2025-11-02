package lotto.controller;

import lotto.model.LottoNumbersRandomGenerator;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningInfo;
import lotto.model.WinningNumbers;
import lotto.model.factory.BonusNumberFactory;
import lotto.model.factory.LottoResultFactory;
import lotto.model.factory.PurchaseAmountFactory;
import lotto.model.factory.WinningNumbersFactory;
import lotto.model.vo.BonusNumber;
import lotto.model.vo.PurchaseAmount;
import lotto.util.WinningNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        outputView.printPurchaseCount(purchaseAmount.calculateQuantity());

        Lottos lottos = Lottos.generateByQuantity(purchaseAmount.calculateQuantity(),
                new LottoNumbersRandomGenerator());
        outputView.printIssuedLottos(lottos);

        String[] parsedNumbers = WinningNumberParser.winningNumberParse(inputView.inputWinningNumbers());
        WinningNumbers winningNumbers = WinningNumbersFactory.from(parsedNumbers);
        BonusNumber bonusNumber = BonusNumberFactory.from(inputView.inputBonusNumber());

        WinningInfo winningInfo = WinningInfo.of(winningNumbers, bonusNumber);

        LottoResult lottoResult = LottoResultFactory.create(winningInfo, lottos, purchaseAmount);

        outputView.printWinningStatistics(lottoResult);
    }

    private PurchaseAmount inputPurchaseAmount() {
        return PurchaseAmountFactory.from(inputView.inputPurchaseAmount());
    }
}
