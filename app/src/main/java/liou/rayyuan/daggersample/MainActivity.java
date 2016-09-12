package liou.rayyuan.daggersample;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import liou.rayyuan.daggersample.hello.HelloFragment;

public class MainActivity extends AppCompatActivity {

    MainComponent mainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build();

        HelloFragment helloFragment = HelloFragment.newInstance();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_main, helloFragment, "Some Tag");
        transaction.commit();

    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
