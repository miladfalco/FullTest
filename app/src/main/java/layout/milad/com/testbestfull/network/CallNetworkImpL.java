package layout.milad.com.testbestfull.network;

import android.content.Context;


import java.util.Observable;

import layout.milad.com.testbestfull.models.DataModel;
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
    public io.reactivex.Observable<DataModel> getCallUser() {
        return serviceApi.getUser();
    }

    @Override
    public Observable getUsers(int page) {
        return null;
    }

    @Override
    public Observable getUser(int id) {
        return null;
    }

    @Override
    public Observable getAllUser() {
        return null;
    }


//


//
//
//    @Override
//    public Call<DataModel> getCallUser() {
////        return serviceApi.getUser();
//        return serviceApi.getUser();
//
//    }
//
//    @Override
//    public Call<DataModel> getUsers(int page) {
//        return null;
//    }
//
//    @Override
//    public Call<DataModel> getUser(int id) {
//        return null;
//    }
//
//    @Override
//    public Call<List<DataModel>> getAllUser() {
//        return null;
//    }
//}
}