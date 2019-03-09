package layout.milad.com.testbestfull.network;

import android.content.Context;


import java.util.List;

import layout.milad.com.testbestfull.models.DataModel;
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
    public Call<DataModel> getCallUser() {
        return serviceApi.getUser();

    }

    @Override
    public Call<DataModel> getUsers(int page) {
        return null;
    }

    @Override
    public Call<DataModel> getUser(int id) {
        return null;
    }

    @Override
    public Call<List<DataModel>> getAllUser() {
        return null;
    }
}
