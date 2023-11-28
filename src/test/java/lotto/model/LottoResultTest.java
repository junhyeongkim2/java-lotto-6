package lotto.model;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultTest {

    @DisplayName("로또 결과 생성 테스트")
    @Test
    void create_EqualResult_Success() {
        //given
        Map<LottoRank, Integer> lottoResult = LottoResult.of(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 7, 8))),
                WinningNumbers.from(List.of(1, 2, 3, 4, 5, 6)));
        //when

        //then
        assertThat(lottoResult.size()).isEqualTo(6);
        assertThat(lottoResult.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.get(LottoRank.SECOND)).isEqualTo(0);
        assertThat(lottoResult.get(LottoRank.THIRD)).isEqualTo(0);
        assertThat(lottoResult.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.get(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(lottoResult.get(LottoRank.NONE)).isEqualTo(0);
    }





}
