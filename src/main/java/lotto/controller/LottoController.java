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
        outputView.printPurchaseCount(purchaseAmount);

        Lottos lottos = Lottos.generateByQuantity(purchaseAmount.calculateQuantity(),
                new LottoNumbersRandomGenerator());
        outputView.printIssuedLottos(lottos);

        WinningInfo winningInfo = WinningInfo.of(inputWinningNumbers(), inputBonusNumber());

        LottoResult lottoResult = LottoResultFactory.create(winningInfo, lottos, purchaseAmount);

        outputView.printWinningStatistics(lottoResult);
    }

    private PurchaseAmount inputPurchaseAmount() {
        try {
            return PurchaseAmountFactory.from(inputView.inputPurchaseAmount());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    private WinningNumbers inputWinningNumbers() {
        return WinningNumbersFactory.from(parseWinningNumbers());
    }

    private String[] parseWinningNumbers() {
        try {
            return WinningNumberParser.winningNumberParse(inputView.inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return parseWinningNumbers();
        }
    }

    private BonusNumber inputBonusNumber() {
        try {
            return BonusNumberFactory.from(inputView.inputBonusNumber());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputBonusNumber();
        }
    }
}
