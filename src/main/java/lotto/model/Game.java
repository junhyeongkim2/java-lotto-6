package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {

    private Lottos lottos;

    public Lottos createLottos(int buyAmount) {
        lottos = Lottos.from(buyAmount);
        return this.lottos;
    }

    public LottoRankInfo createResult(List<Integer> winningNumbers, int bonusNumber) {
        LottoChecker lottoChecker = new LottoChecker();
        return lottoChecker.createResult(lottos, winningNumbers, bonusNumber);
    }


    public float createProfit(float buyAmount, Map<LottoRank, Integer> lottoRankInfo) {
        Profit profit = new Profit();
        return profit.calculateProfitRate(buyAmount, lottoRankInfo);
    }


}
