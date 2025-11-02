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
        playLottoMachine(createInputAmount());
    }

    private void playLottoMachine(PurchaseAmount purchaseAmount) {
        outputView.printWinningStatistics(createLottoResult(purchaseAmount));
    }

    private LottoResult createLottoResult(PurchaseAmount purchaseAmount) {
        return LottoResultFactory.create(createWinningInfo(),
                createLottos(purchaseAmount),
                purchaseAmount);
    }

    private Lottos createLottos(PurchaseAmount purchaseAmount) {
        Lottos lottos = generateLottos(purchaseAmount);
        outputView.printIssuedLottos(lottos);
        return lottos;
    }

    private PurchaseAmount createInputAmount() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        outputView.printPurchaseCount(purchaseAmount);

        return purchaseAmount;
    }

    private static Lottos generateLottos(PurchaseAmount purchaseAmount) {
        return Lottos.generateByQuantity(purchaseAmount.calculateQuantity(),
                new LottoNumbersRandomGenerator());
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
        try {
            return WinningNumbersFactory.from(parseWinningNumbers());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputWinningNumbers();
        }
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

    private WinningInfo createWinningInfo() {
        WinningNumbers winningNumbers = inputWinningNumbers();
        return createWinningInfoWithWinningNumbers(winningNumbers);
    }

    private WinningInfo createWinningInfoWithWinningNumbers(WinningNumbers winningNumbers) {
        try {
            return WinningInfo.of(winningNumbers, inputBonusNumber());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createWinningInfoWithWinningNumbers(winningNumbers);
        }
    }
}
