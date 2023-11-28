package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final String BUYAMOUBT_PATTERN = "^[0-9]+";


    public static String readBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateBuyAmount(input);
        System.out.println();
        return input;
    }

    public static String readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public static void validateBuyAmount(String input) {
        if (!Pattern.matches(BUYAMOUBT_PATTERN, input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 구입금액이 입력되었습니다! 다시 입력해 주세요.");
        }
    }


}
