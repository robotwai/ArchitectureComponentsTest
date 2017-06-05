package test.enjoyor.com.acdemo;

import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.annotations.Nullable;

/**
 * Created by lz on 2017/6/5.
 */

public class UserProfileFragment extends LifecycleFragment {
    private static final String UID_KEY = "uid";
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_lastname)
    TextView tvLastname;
    Unbinder unbinder;
    private UserProfileViewModel viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel.getUser().observe(this, user -> {
            // update UI
            tvName.setText(user.getName());
            tvLastname.setText(user.getLastName());
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_profile, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
