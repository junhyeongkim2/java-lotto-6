package lotto;

import java.util.Map;
import lotto.controller.LottoGameController;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.LottosFactory;
import lotto.model.WinningNumbers;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.start();
    }
}
