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
        List<Integer> winningNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
        validateDuplicatedWinningNumbers(winningNumbers);
        validateIsInRangeWinningNumbers(winningNumbers);
        validateIsSixWinningNumbers(winningNumbers);
        return winningNumbers;
    }


    public void validateDuplicatedWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != winningNumbers.stream().count()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호가 입력되었습니다. 다시 입력해 주세요.");
        }
    }

    public void validateIsInRangeWinningNumbers(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호가 입력되었습니다. 다시 입력해 주세요.");
            }
        }
    }

    public static void validateIsSixWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호가 입력되었습니다. 다시 입력해 주세요.");
        }
    }


}
