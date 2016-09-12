package liou.rayyuan.daggersample.stage2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import liou.rayyuan.daggersample.MoneyBox;
import liou.rayyuan.daggersample.SecretCode;
import liou.rayyuan.daggersample.ThirdMechanism;

/**
 * Created by louis383 on 2016/9/12.
 */

@Module
public class Stage2Module {

    public Stage2Module() {}

    @Singleton
    @Provides
    ThirdMechanism provideThirdMechanism(SecretCode secretCode, MoneyBox moneyBox) {
        return new ThirdMechanism(secretCode, moneyBox);
    }
}
