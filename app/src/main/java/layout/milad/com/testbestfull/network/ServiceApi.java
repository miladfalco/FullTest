package layout.milad.com.testbestfull.network;

import io.reactivex.Observable;
import layout.milad.com.testbestfull.models.DataModel;
import layout.milad.com.testbestfull.models.DataUser;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceApi {

    @GET("api/users")
    Observable<DataUser> getAllUsers(@Query("page") int page);

    @GET("api/users/2")
    Observable<DataModel> getUser();

}
