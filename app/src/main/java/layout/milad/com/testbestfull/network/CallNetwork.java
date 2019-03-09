package layout.milad.com.testbestfull.network;

import java.util.List;


import layout.milad.com.testbestfull.models.DataModel;
import retrofit2.Call;

public interface CallNetwork {

    Call<DataModel> getCallUser();

    Call<DataModel> getUsers(int page);

    Call<DataModel> getUser(int id);

    Call<List<DataModel>> getAllUser();
}
