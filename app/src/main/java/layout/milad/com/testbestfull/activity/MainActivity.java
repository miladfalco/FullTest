package layout.milad.com.testbestfull.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.milad.com.testbestfull.R;
import layout.milad.com.testbestfull.callback.ClickEventHandler;
import layout.milad.com.testbestfull.callback.DialogCall;
import layout.milad.com.testbestfull.models.DataUser;
import layout.milad.com.testbestfull.models.User;
import layout.milad.com.testbestfull.network.RetrofitClient;
import layout.milad.com.testbestfull.network.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_get_all_data)
    Button btn1;
    @BindView(R.id.btn_music)
    Button btn2;
    @BindView(R.id.btn_call)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;
    @BindView(R.id.btn_6)
    Button btn6;

    private ClickEventHandler clickEventHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, ListOfSongsActivity.class);
                startActivity(intent2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceApi serviceApi = RetrofitClient.getINSTANCE().create(ServiceApi.class);
                Call<DataUser> allUsers = serviceApi.getAllUsers(2);
                allUsers.enqueue(new Callback<DataUser>() {
                    @Override
                    public void onResponse(Call<DataUser> call, Response<DataUser> response) {

                        List<User> getUser = response.body().getGetUser();
                        User user = getUser.get(0);
                        String firstName = user.getFirstName();
                        DialogCall dialogCall = new DialogCall(firstName, clickEventHandler, MainActivity.this);
                        dialogCall.dialogBuild();
                    }

                    @Override
                    public void onFailure(Call<DataUser> call, Throwable t) {

                    }
                });
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestOneActivity.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BotikActivity.class);
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RoomTest.class);
                startActivity(intent);
            }
        });

    }
}
