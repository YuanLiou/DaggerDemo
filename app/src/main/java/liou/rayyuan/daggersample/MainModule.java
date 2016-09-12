package liou.rayyuan.daggersample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by louis383 on 2016/9/12.
 */

@Module
public class MainModule {

    private Application application;

    public MainModule(MainActivity activity) {
        this.application = activity.getApplication();
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Singleton
    @Provides
    SecretCode provideSecretCode() {
        return new SecretCode("123456");
    }

    @Singleton
    @Provides
    MoneyBox provideMoneyBox(SecretCode secretCode) {
        return new MoneyBox(secretCode);
    }
}
