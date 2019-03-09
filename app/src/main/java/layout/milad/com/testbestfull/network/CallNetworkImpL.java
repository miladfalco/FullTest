package layout.milad.com.testbestfull.network;

import android.content.Context;

import java.util.List;

import layout.milad.com.testbestfull.models.DataUser;
import layout.milad.com.testbestfull.models.User;
import retrofit2.Call;
import retrofit2.Retrofit;

public class CallNetworkImpL implements CallNetwork {

    private static Context context;
    private Retrofit retrofit = RetrofitClient.getINSTANCE();
    private ServiceApi serviceApi = retrofit.create(ServiceApi.class);
    private static CallNetworkImpL INSTANCE;

    public CallNetworkImpL(Context context) {
        this.context = context;
    }

    public static synchronized CallNetworkImpL getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CallNetworkImpL(context);
        }
        return INSTANCE;
    }

    @Override
    public Call<User> user() {
        return null;
    }

    @Override
    public Call<DataUser> getUsers(int page) {
        return null;
    }

    @Override
    public Call<User> getUser(int id) {
        return null;
    }


    @Override
    public Call<List<User>> getAllUser() {
        return null;
    }
}
