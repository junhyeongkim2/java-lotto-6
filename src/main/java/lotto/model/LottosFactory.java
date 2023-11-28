package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class LottosFactory {

    private static List<Lotto> lottos = new ArrayList<>();

    private LottosFactory() {
    }

    public static List<Lotto> create(int money) {
        int lottoAmount = calculateLottoAmount(money);
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public static Lotto createLotto() {
        return new Lotto(createLottoNumbers());
    }

    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static int calculateLottoAmount(int money) {
        return money / 1000;
    }


}
