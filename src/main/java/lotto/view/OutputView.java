package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;

public class OutputView {


    public static void printLottoAmount(int lottoAmount) {
        System.out.println(lottoAmount);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.stream().forEach(lotto -> System.out.println(lotto.getLottoNumbers().toString()));
    }


    public static void printResult(Map<LottoRank, Integer> result) {

    }
}
