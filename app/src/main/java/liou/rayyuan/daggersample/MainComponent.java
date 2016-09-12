package liou.rayyuan.daggersample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import liou.rayyuan.daggersample.hello.HelloComponent;
import liou.rayyuan.daggersample.hello.HelloModule;
import liou.rayyuan.daggersample.stage2.Stage2Component;
import liou.rayyuan.daggersample.stage2.Stage2Module;

/**
 * Created by louis383 on 2016/9/12.
 */

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
    // SubModule
    HelloComponent plus(HelloModule helloModule);
    Stage2Component plus(Stage2Module stage2Module);
    // Dependency need to be spread out
    Application getApplication();
    SecretCode getSecretCode();
    MoneyBox getMoneyBox();
    // Class that can be inject
    void inject(MainActivity mainActivity);
}
