package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public Lottos createLottos(int money) {
        int lottoAmount = calculateLottoAmount(money);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(createLotto());
        }
        return new Lottos(lottos);
    }

    public Lotto createLotto() {
        return new Lotto(createLottoNumbers());
    }

    public List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int calculateLottoAmount(int money) {
        return money / 1000;
    }


}
