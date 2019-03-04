package layout.milad.com.testbestfull.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.milad.com.testbestfull.R;

public class TestTwoActivity extends AppCompatActivity {

    private static final String TAG = "TestTwoActivity";

    @BindView(R.id.txtView_name)
    TextView textView1;
    @BindView(R.id.txtView_family)
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_two);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String family = bundle.getString("family");
        textView1.setText(name);
        textView2.setText(family);

        Toast.makeText(this, "First Name" + name, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreate: first name" + name);
    }
}
