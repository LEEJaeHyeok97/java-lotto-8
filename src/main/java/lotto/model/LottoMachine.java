package lotto.model;

public class LottoMachine {

    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoMachine(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public static LottoMachine of(LottoNumbersGenerator lottoNumbersGenerator) {
        return new LottoMachine(lottoNumbersGenerator);
    }

    public Lottos generateByQuantity(int quantity) {
        return Lottos.generateByQuantity(quantity, lottoNumbersGenerator);
    }
}
