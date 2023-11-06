package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoRankInfo;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class GameTest {
    @DisplayName("로또 여러개 생성 시 카운트 일치 테스트")
    @Test
    void createLottos_CountEqual_Succes() {
        Game game = new Game();
        Lottos lottos = game.createLottos(6000);

        assertThat(lottos.getLottos().size()).isEqualTo(6);

    }

    @DisplayName("생성된 로또 번호 갯수 테스트")
    @Test
    void CreateLottos_EquaLottoNumberCount_ExceptionThrow() {
        Game game = new Game();
        Lottos lottos = game.createLottos(3);
        List<Lotto> lottoList = lottos.getLottos();
        for (Lotto lotto : lottoList) {
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
        }
    }


    @DisplayName("당첨 통계 테스트")
    @Test
    void createResult_EqualResult_Success() {
        Game game = new Game();
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Lottos lottos = new Lottos(lottoList);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;

        LottoRankInfo lottoRankInfo = game.createResult(lottos, winningNumbers, bonusNumber);

        assertThat(lottoRankInfo.getLottoRankInfo().size()).isEqualTo(6);

    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateProfit_EqualResult_Success() {
        Game game = new Game();

        Map<LottoRank, Integer> lottoRankInfo = new EnumMap(LottoRank.class);
        lottoRankInfo.put(LottoRank.NONE,0);
        lottoRankInfo.put(LottoRank.FIRST,1);
        lottoRankInfo.put(LottoRank.SECOND,0);
        lottoRankInfo.put(LottoRank.THIRD,0);
        lottoRankInfo.put(LottoRank.FOURTH,0);
        lottoRankInfo.put(LottoRank.FIFTH,0);
        float buyAmount = 8000;

        int profitRate = Math.round(game.createProfit(buyAmount, lottoRankInfo));

        assertThat(profitRate).isEqualTo(25000000);

    }


}
