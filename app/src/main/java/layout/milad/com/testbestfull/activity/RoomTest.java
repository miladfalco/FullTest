package layout.milad.com.testbestfull.activity;

import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import layout.milad.com.testbestfull.R;
import layout.milad.com.testbestfull.models.Data;
import layout.milad.com.testbestfull.models.DataModel;
import layout.milad.com.testbestfull.network.CallNetworkImpL;
import layout.milad.com.testbestfull.network.RetrofitClient;
import layout.milad.com.testbestfull.network.ServiceApi;
import layout.milad.com.testbestfull.storage.AppDatabase;
import layout.milad.com.testbestfull.storage.DataModelUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomTest extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private TextView txt1, txt2;
    private ImageView imageView;
    private AppDatabase database;
    private DataModelUser dataModelUser;
    private CallNetworkImpL callNetworkImpL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_test);
        txt1 = findViewById(R.id.nameViewTest);
        txt2 = findViewById(R.id.familyViewTest);
        imageView = findViewById(R.id.imageViewServer);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();


        database = Room.databaseBuilder(this, AppDatabase.class, "user-DB")
                .allowMainThreadQueries()
                .build();

        if (hasInternetConnection(this)) {
            Toast.makeText(getApplicationContext(), "اینترنت وصل است !", Toast.LENGTH_LONG).show();
            getDataOfServer();
        } else {
            Toast.makeText(getApplicationContext(), "اینترنت قطغ میباشذ", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
            List<DataModelUser> allOneUser = database.userDao().getAllOneUser();
            DataModelUser dataModelUser = allOneUser.get(0);

            String firstName = dataModelUser.getFirstName();
            String lastName = dataModelUser.getLastName();
            String avatar = dataModelUser.getAvatar();

            txt1.setText(firstName);
            txt2.setText(lastName);
            Glide.with(this).load(avatar).into(imageView);
        }

    }


    private void getDataOfServer() {
//        ServiceApi serviceApi = RetrofitClient.getINSTANCE().create(ServiceApi.class);
//        Call<DataModel> user = serviceApi.getUser();
//        user.enqueue(new Callback<DataModel>() {
//            @Override
//            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
//                progressDialog.dismiss();
//                DataModel body = response.body();
//                Data data = body.getData();
//                final String firstName = data.getFirstName();
//                final String lastName = data.getLastName();
//                final String avatar = data.getAvatar();
////                Log.i("==>", "onResponse: " + firstName);
//                txt1.setText(firstName);
//                txt2.setText(lastName);
//                Glide.with(RoomTest.this).load(avatar).into(imageView);
////                dataModelUser = new DataModelUser(firstName);
//                database.userDao().insertOneUser(new DataModelUser(firstName, lastName, avatar));
//
//
//            }
//
//            @Override
//            public void onFailure(Call<DataModel> call, Throwable t) {
//
//            }
//        });

    }

    public boolean hasInternetConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetwork = null;
        if (cm != null) {
            wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        }
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            return true;
        }
        NetworkInfo mobileNetwork = null;
        if (cm != null) {
            mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        }
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            return true;
        }
        NetworkInfo activeNetwork = null;
        if (cm != null) {
            activeNetwork = cm.getActiveNetworkInfo();
        }
        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        }
        return false;
    }
}
