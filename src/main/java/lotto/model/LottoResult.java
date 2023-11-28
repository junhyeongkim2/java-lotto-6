package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private static LottoResult lottoResult;
    private static Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);

    private LottoResult() {
    }

    public static LottoResult of(List<Lotto> lottos, WinningNumbers winningNumbers) {
        Arrays.stream(LottoRank.values()).forEach(lottoRank -> result.put(lottoRank, 0));

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
