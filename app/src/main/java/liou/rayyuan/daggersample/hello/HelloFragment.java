package liou.rayyuan.daggersample.hello;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import liou.rayyuan.daggersample.MainActivity;
import liou.rayyuan.daggersample.MoneyBox;
import liou.rayyuan.daggersample.R;
import liou.rayyuan.daggersample.SecretCode;
import liou.rayyuan.daggersample.stage2.Stage2Fragment;

/**
 * Created by louis383 on 2016/9/12.
 */

public class HelloFragment extends Fragment implements View.OnClickListener {

    private TextView helloText;
    private TextView passwordValid;
    private Button button;

    @Inject
    SecretCode secretCode;
    @Inject
    MoneyBox moneyBox;

    public HelloFragment() {}

    public static HelloFragment newInstance() {

        Bundle args = new Bundle();

        HelloFragment fragment = new HelloFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hello_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        helloText = (TextView) view.findViewById(R.id.title_text);
        passwordValid = (TextView) view.findViewById(R.id.password_valid);

        button = (Button) view.findViewById(R.id.goto_next_stage);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        ((MainActivity)getActivity()).getMainComponent()
                .plus(new HelloModule())
                .inject(this);

        helloText.setText(secretCode.getSecretText());
        passwordValid.setText(moneyBox.isPasswordCorrect() ? "Correct" : "InCorrect");

        button.setOnClickListener(this);
    }

    //region View.OnClickListener
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.goto_next_stage:
                Stage2Fragment fragment = Stage2Fragment.newInstance();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.activity_main, fragment, "SomeTags2");
                transaction.addToBackStack("BackStack!");
                transaction.commit();
                break;
        }
    }
    //endregion
}
