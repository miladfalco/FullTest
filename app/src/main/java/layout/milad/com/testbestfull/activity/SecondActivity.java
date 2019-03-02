package layout.milad.com.testbestfull.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.List;

import layout.milad.com.testbestfull.R;
import layout.milad.com.testbestfull.adapter.UserAdapter;
import layout.milad.com.testbestfull.models.DataUser;
import layout.milad.com.testbestfull.models.User;
import layout.milad.com.testbestfull.network.RetrofitClient;
import layout.milad.com.testbestfull.network.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SecondActivity extends AppCompatActivity {


    private List<User> userList;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        initData();


    }

    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.item_rec);
        UserAdapter userAdapter = new UserAdapter(this, userList);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        ServiceApi serviceApi = RetrofitClient.getINSTANCE().create(ServiceApi.class);
        Call<DataUser> allUsers = serviceApi.getAllUsers(2);
        allUsers.enqueue(new Callback<DataUser>() {
            @Override
            public void onResponse(Call<DataUser> call, Response<DataUser> response) {
                progressDialog.dismiss();
                userList = response.body().getGetUser();
                initViews();
            }

            @Override
            public void onFailure(Call<DataUser> call, Throwable t) {

            }
        });
    }
}
