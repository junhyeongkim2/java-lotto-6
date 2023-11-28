package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoGeneratorTest {


    @DisplayName("사용자가 구입한 금액만큼 로또를 생성한다")
    @Test
    void generateLottos_EqualSize_Success() {

        //given
        LottoGenerator lottoGenerator = new LottoGenerator();
        //when
        Lottos lottos = lottoGenerator.createLottos(5000);
        //then
        assertThat(lottos.getLottos().size()).isEqualTo(5);

    }


}
