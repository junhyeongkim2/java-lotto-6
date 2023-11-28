package lotto.model;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("로또 결과 생성 테스트")
    @Test
    void create_EqualResult_Success() {
        //given
        Map<LottoRank, Integer> lottoResult = LottoResult.create(LottosFactory.create(5000), WinningNumbers.create());

        //when

        //then

    }


}
