package test.enjoyor.com.acdemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by lz on 2017/6/5.
 */

public class UserProfileViewModel extends ViewModel {
    private String userId;
    public void init(String userId) {
        this.userId = userId;
    }
    private LiveData<User> user;
    public LiveData<User> getUser() {
        return user;
    }
}
