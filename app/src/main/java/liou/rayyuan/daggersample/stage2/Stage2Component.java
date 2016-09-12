package liou.rayyuan.daggersample.stage2;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by louis383 on 2016/9/12.
 */
@Singleton
@Subcomponent(modules = Stage2Module.class)
public interface Stage2Component {
    void inject(Stage2Fragment stage2Fragment);
}
