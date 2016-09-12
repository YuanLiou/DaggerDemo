package liou.rayyuan.daggersample;

/**
 * Created by louis383 on 2016/9/12.
 */

public class ThirdMechanism {

    private SecretCode secretCode;
    private MoneyBox moneyBox;

    public ThirdMechanism(SecretCode secretCode, MoneyBox moneyBox) {
        this.secretCode = secretCode;
        this.moneyBox = moneyBox;
    }

    public String getThirdMechanism() {
        return "Yoooooooooooooooooo!";
    }
}
