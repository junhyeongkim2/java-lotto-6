package lotto.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class OutputViewTest {


    ByteArrayOutputStream captureOutputValues() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        return outputStream;
    }


    @DisplayName("로또 구입 개수 출력 테스트")
    @Test
    void printLottoAmount_EqualResult_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        OutputView.printLottoAmount(5);
        //then
        assertThat(output.toString()).isEqualTo("5\n");
    }


    @DisplayName("로또 생성 출력 테스트")
    @Test
    void printLottos_EqualResult_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        //when
        OutputView.printLottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(5, 6, 7, 8, 9, 10))));
        //then
        assertThat(output.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n[5, 6, 7, 8, 9, 10]\n");
    }

    @DisplayName("당첨 통계 출력 테스트")
    @Test
    void printResult_EqualResult_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();

        LottoResult.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 10, 11, 12))),
                WinningNumbers.from(List.of(1, 2, 3, 4, 5, 6),7));
        //when
        OutputView.printResult(LottoResult.getResult());
        //then
        assertThat(output.toString()).isEqualTo(
                "당첨 통계\n"
                        + "---\n"
                        + "3개 일치 (5,000원) - 1개\n"
                        + "4개 일치 (50,000원) - 0개\n"
                        + "5개 일치 (1,500,000원) - 0개\n"
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                        + "6개 일치 (2,000,000,000원) - 1개\n");
    }

    @DisplayName("수익률 출력 테스트")
    @Test
    void printProfit_EqualOutput_Success() {
        //given
        ByteArrayOutputStream output = captureOutputValues();
        float profit = 12.334f;
        //when
        OutputView.printProfit(profit);
        //then
        assertThat(output.toString()).isEqualTo("총 수익률은 12.3%입니다.");
    }
}
