package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private int bonusNumber;

    private WinningNumbers(String winningNumbers, int bonusNumber) {
        this.winningNumbers = splitWinningNumbers(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers from(String winningNumbers, int bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int calculateContainCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream().filter(number -> winningNumbers.contains(number)).count();
    }

    public Boolean isBonus(Lotto lotto) {
        return lotto.getLottoNumbers().contains(bonusNumber);
    }

    public List<Integer> splitWinningNumbers(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
        validateDuplicatedWinningNumbers(winningNumbers);
        validateIsInRangeWinningNumbers(winningNumbers);
        validateIsSixWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public void validateDuplicatedWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != winningNumbers.stream().count()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호가 입력되었습니다. 다시 입력해 주세요.");
        }
    }

    public void validateIsInRangeWinningNumbers(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호가 입력되었습니다. 다시 입력해 주세요.");
            }
        }
    }

    public static void validateIsSixWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호가 입력되었습니다. 다시 입력해 주세요.");
        }
    }

}
