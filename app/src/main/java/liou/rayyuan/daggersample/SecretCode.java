package liou.rayyuan.daggersample;

/**
 * Created by louis383 on 2016/9/12.
 */

public class SecretCode {

    private String password;

    public SecretCode(String password) {
        this.password = password;
    }

    public String getSecretText() {
        return "It's fun time! Yeah!";
    }

    public String getPassword() {
        return password;
    }
}
