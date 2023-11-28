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
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + result.get(LottoRank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(LottoRank.FOURTH)+ "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(LottoRank.THIRD)+ "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(LottoRank.SECOND)+ "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(LottoRank.FIRST)+ "개");
    }
}
