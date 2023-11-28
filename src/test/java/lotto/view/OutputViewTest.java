package lotto.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.model.Lotto;
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


}
