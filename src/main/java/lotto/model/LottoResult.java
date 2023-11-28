package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private static Map<LottoRank, Integer> result;

    private LottoResult() {
        result = new EnumMap<LottoRank, Integer>(LottoRank.class);
        initializeResult();
    }

    private void initializeResult() {
        Arrays.stream(LottoRank.values()).forEach(lottoRank -> result.put(lottoRank, 0));
    }

    public static LottoResult of(List<Lotto> lottos, WinningNumbers winningNumbers) {
        LottoResult lottoResult = new LottoResult();
        lottos.stream().map(lotto -> LottoRank.valueOf(winningNumbers.calculateContainCount(lotto),
                        winningNumbers.isBonus(lotto)))
                .forEach(lottoRank -> result.put(lottoRank, result.get(lottoRank) + 1));
        return lottoResult;
    }


    public static Map<LottoRank, Integer> getResult() {
        return result;
    }

    public static float calculateProfit(int buyAmount) {
        int sum = Arrays.stream(LottoRank.values()).mapToInt(lottoRank -> result.get(lottoRank) * lottoRank.getPrize())
                .sum();
        return (float) ((sum - buyAmount) / 100.0);
    }
}
