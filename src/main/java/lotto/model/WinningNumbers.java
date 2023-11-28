package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private int bonusNumber;

    private WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = createBonusNumber();
    }

    public static WinningNumbers create() {
        return new WinningNumbers(createRandomNumbers());
    }

    public static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int createBonusNumber() {
        while (true) {
            int uniqueBonusNumber = Randoms.pickNumberInRange(1, 45);
            if (!winningNumbers.contains(uniqueBonusNumber)) {
                return uniqueBonusNumber;
            }
        }
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
}
