package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private int bonusNumber;

    private WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers from(List<Integer> numbers, int bonusNumber) {
        return new WinningNumbers(numbers, bonusNumber);
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

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != winningNumbers.stream().count()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호가 입력되었습니다. 다시 입력해 주세요.");
        }
    }
}
