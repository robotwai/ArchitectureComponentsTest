package test.enjoyor.com.acdemo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lz on 2017/4/12.
 */

public abstract class ApiResponse<T> implements Callback<T>{
    public String errorMessage;

    public T body;
    @Override
    public void onResponse(Call<T> call, Response<T> response) {

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    public abstract boolean isSuccessful();
}
