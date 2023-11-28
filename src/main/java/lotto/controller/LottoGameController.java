package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottosFactory;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void start() {
        int money = Integer.parseInt(InputView.readBuyAmount());
        OutputView.printLottoAmount(money / 1000);
        List<Lotto> lottos = LottosFactory.create(money);
        OutputView.printLottos(lottos);
        WinningNumbers winningNumbers = WinningNumbers.from(splitWiningNumbers(InputView.readWinningNumbers()),
                Integer.parseInt(InputView.readBonusNumber()));
        LottoResult.of(lottos, winningNumbers);
        OutputView.printResult(LottoResult.getResult());
        OutputView.printProfit(LottoResult.calculateProfit(money));
    }

    public List<Integer> splitWiningNumbers(String input) {
        return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }


}
