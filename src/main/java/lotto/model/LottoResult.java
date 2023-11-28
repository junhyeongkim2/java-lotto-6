package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);

    private LottoResult() {
    }

    public static Map<LottoRank, Integer> create(List<Lotto> lottos, WinningNumbers winningNumbers) {

        return result;
    }


}
