package lotto.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @DisplayName("당첨번호 및 보너스번호 생성 테스트")
    @Test
    void createWinningNumbers_EqualNumbers_Success() {
        //given
        WinningNumbers winningNumbers = WinningNumbers.from("1,2,3,4,5,6",7);
        //when
        List<Integer> numbers = winningNumbers.getWinningNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();
        //then
        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers).allSatisfy(value -> assertThat(value).isBetween(1, 45));
        assertThat(numbers.contains(bonusNumber)).isFalse();
        assertThat(bonusNumber).isBetween(1,45);

    }


}
