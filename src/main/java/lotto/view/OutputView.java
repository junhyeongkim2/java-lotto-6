package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    public static void printLottos(List<Lotto> lottos) {
        lottos.stream().forEach(lotto -> System.out.println(lotto.getLottoNumbers().toString()));
    }


}
