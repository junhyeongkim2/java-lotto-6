package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottosFactory;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void start() {
        int money = Integer.parseInt(repeatUntilValid(InputView::readBuyAmount));
        OutputView.printLottoAmount(money / 1000);
        List<Lotto> lottos = LottosFactory.create(money);
        OutputView.printLottos(lottos);
        WinningNumbers winningNumbers = WinningNumbers.from(repeatUntilValid(InputView::readWinningNumbers),
                Integer.parseInt(InputView.readBonusNumber()));
        LottoResult.of(lottos, winningNumbers);
        OutputView.printResult(LottoResult.getResult());
        OutputView.printProfit(LottoResult.calculateProfit(money));
    }

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatUntilValid(function);
        }
    }


}
