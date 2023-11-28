package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottosFactory {
    public static List<Lotto> create(int money) {
        int lottoAmount = calculateLottoAmount(money);
        List<Lotto> lottos = new ArrayList<>();
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
