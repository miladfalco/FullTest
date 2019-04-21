package layout.milad.com.testbestfull.activity;

import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import layout.milad.com.testbestfull.R;
import layout.milad.com.testbestfull.adapter.UserAdapter;
import layout.milad.com.testbestfull.adapter.UserRoomAdapter;
import layout.milad.com.testbestfull.models.DataUser;
import layout.milad.com.testbestfull.models.User;
import layout.milad.com.testbestfull.network.RetrofitClient;
import layout.milad.com.testbestfull.network.ServiceApi;
import layout.milad.com.testbestfull.storage.AppDatabase;
import layout.milad.com.testbestfull.storage.DataModelUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SecondActivity extends AppCompatActivity {


    private List<User> userList;
    private ProgressDialog progressDialog;
    private AppDatabase database;
    private List<DataModelUser> listUsers;
    private DataModelUser dataModelUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        initData();


        database = Room.databaseBuilder(this, AppDatabase.class, "userDB")
                .allowMainThreadQueries()
                .build();

        listUsers = new ArrayList<>();

    }

    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.item_rec);
        UserAdapter userAdapter = new UserAdapter(this, userList);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initViewsRoom() {
        RecyclerView recyclerView = findViewById(R.id.item_rec);
        UserRoomAdapter userRoomAdapter = new UserRoomAdapter(this, listUsers);
        recyclerView.setAdapter(userRoomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {

        RetrofitClient.getINSTANCE().create(ServiceApi.class).getAllUsers(2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataUser>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataUser value) {
                        progressDialog.dismiss();
                        userList = value.getGetUser();
                        initViews();
                        insertDbAllUser(userList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                        getAllUser();
                        initViews();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


//        ServiceApi serviceApi = RetrofitClient.getINSTANCE().create(ServiceApi.class);
//        Call<DataUser> allUsers = serviceApi.getAllUsers(2);
//        allUsers.enqueue(new Callback<DataUser>() {
//            @Override
//            public void onResponse(Call<DataUser> call, Response<DataUser> response) {
//                if (response != null) {
//                    progressDialog.dismiss();
//                    userList = response.body().getGetUser();
//                    initViews();
//                    insertDbAllUser(userList);
//                } else {

//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<DataUser> call, Throwable t) {
//
//            }
//        });
    }

    private void insertDatabaseUser(User user) {
        database.userDao().insertUser(user);
    }

    private void insertDbAllUser(List<User> list) {
        database.userDao().insertAllUser(list);
    }

    private void getAllUser() {
        userList = database.userDao().getAllUser();
    }

}
