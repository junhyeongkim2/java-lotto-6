package lotto.model;

public enum LottoRank {

    NONE("없음", 0, 0, false),
    FIFTH("3개 일치", 5000, 3, false),
    FOURTH("4개 일치", 50000, 4, false),
    THIRD("5개 일치", 1500000, 5, false),
    SECOND("5개 일치, 보너스 볼 일치", 30000000, 5, true),
    FIRST("6개 일치", 2000000000, 6, false);

    private String matchName;
    private int prize;
    private int matchCount;
    private boolean isMatchBonusNumber;

    LottoRank(String matchName, int prize, int matchCount, boolean isMatchBonusNumber) {
        this.matchName = matchName;
        this.prize = prize;
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }


    public static LottoRank valueOf(int matchCount, boolean isMatchBonusNumber) {
        if (matchCount == LottoRank.FIRST.matchCount) {
            return LottoRank.FIRST;
        }
        if (matchCount == LottoRank.SECOND.matchCount && isMatchBonusNumber == LottoRank.SECOND.isMatchBonusNumber) {
            return LottoRank.SECOND;
        }
        if (matchCount == LottoRank.THIRD.matchCount) {
            return LottoRank.THIRD;
        }
        if (matchCount == LottoRank.FOURTH.matchCount) {
            return LottoRank.FOURTH;
        }
        if (matchCount == LottoRank.FIFTH.matchCount) {
            return LottoRank.FIFTH;
        }
        return LottoRank.NONE;
    }

    public int getPrize() {
        return this.prize;
    }


}
