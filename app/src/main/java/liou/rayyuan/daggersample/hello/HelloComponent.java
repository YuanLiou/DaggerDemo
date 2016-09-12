package liou.rayyuan.daggersample.hello;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by louis383 on 2016/9/12.
 */

@Singleton
@Subcomponent(modules = HelloModule.class)
public interface HelloComponent {
    void inject(HelloFragment helloFragment);
}
