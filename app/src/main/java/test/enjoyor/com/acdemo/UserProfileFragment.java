package test.enjoyor.com.acdemo;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.reactivex.annotations.Nullable;

/**
 * Created by lz on 2017/6/5.
 */

public class UserProfileFragment extends LifecycleFragment {
    private static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel.getUser().observe(this, user -> {
            // update UI
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_profile, container, false);
    }
}
