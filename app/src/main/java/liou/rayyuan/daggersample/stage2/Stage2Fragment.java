package liou.rayyuan.daggersample.stage2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import liou.rayyuan.daggersample.MainActivity;
import liou.rayyuan.daggersample.R;
import liou.rayyuan.daggersample.ThirdMechanism;

/**
 * Created by louis383 on 2016/9/12.
 */

public class Stage2Fragment extends Fragment {

    private TextView passwordText;

    @Inject
    ThirdMechanism thirdMechanism;

    public Stage2Fragment() {}

    public static Stage2Fragment newInstance() {

        Bundle args = new Bundle();

        Stage2Fragment fragment = new Stage2Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.stage2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        passwordText = (TextView) view.findViewById(R.id.stage2_title);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        ((MainActivity) getActivity()).getMainComponent()
                .plus(new Stage2Module())
                .inject(this);

        passwordText.setText(thirdMechanism.getThirdMechanism());
    }
}
