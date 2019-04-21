package layout.milad.com.testbestfull.network;

import java.util.Observable;


import layout.milad.com.testbestfull.models.DataModel;

public interface CallNetwork {

    io.reactivex.Observable<DataModel> getCallUser();

    Observable getUsers(int page);

    Observable getUser(int id);

    Observable getAllUser();
}
