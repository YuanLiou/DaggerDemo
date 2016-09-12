package liou.rayyuan.daggersample;

import android.text.TextUtils;

/**
 * Created by louis383 on 2016/9/12.
 */

public class MoneyBox {

    private SecretCode secretCode;

    public MoneyBox(SecretCode secretCode) {
        this.secretCode = secretCode;
    }

    public boolean isPasswordCorrect() {
        return (TextUtils.equals(secretCode.getPassword(), "123456"));
    }
}
