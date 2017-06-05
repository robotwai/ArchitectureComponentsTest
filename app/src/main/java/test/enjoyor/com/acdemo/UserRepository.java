package test.enjoyor.com.acdemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lz on 2017/6/5.
 */
@Singleton
public class UserRepository {
    private final Webservice webservice;
    private final UserDao userDao;
    private final Executor executor;

    @Inject
    public UserRepository(Webservice webservice, UserDao userDao, Executor executor) {
        this.webservice = webservice;
        this.userDao = userDao;
        this.executor = executor;
    }

    public LiveData<User> getUser(String userId) {
        // This is not an optimal implementation, we'll fix it below
        final MutableLiveData<User> data = new MutableLiveData<>();
        webservice.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // error case is left out for brevity
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        return data;
    }

    private void refreshUser(final String userId) {
        executor.execute(() -> {
            // running in a background thread
            // check if user was fetched recently
//            boolean userExists = userDao.hasUser(FRESH_TIMEOUT);
//            if (!userExists) {
//                // refresh the data
//                Response response = webservice.getUser(userId).execute();
//                // TODO check for error etc.
//                // Update the database.The LiveData will automatically refresh so
//                // we don't need to do anything else here besides updating the database
//                userDao.save(response.body());
//            }
        });
    }
}
