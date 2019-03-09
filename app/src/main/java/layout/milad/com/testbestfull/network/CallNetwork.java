package layout.milad.com.testbestfull.network;

import java.util.List;

import layout.milad.com.testbestfull.models.DataUser;
import layout.milad.com.testbestfull.models.User;
import retrofit2.Call;

public interface CallNetwork {

    Call<User> user();

    Call<DataUser> getUsers(int page);

    Call<User> getUser(int id);

    Call<List<User>> getAllUser();
}
