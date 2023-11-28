package lotto.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottosFactoryTest {

    @DisplayName("사용자가 구입한 금액만큼 로또를 생성한다")
    @Test
    void generateLottos_EqualSize_Success() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        //when
        lottos = LottosFactory.create(5000);
        //then
        assertThat(lottos.size()).isEqualTo(5);

    }


}
