package layout.milad.com.testbestfull.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.milad.com.testbestfull.R;

public class TestOneActivity extends AppCompatActivity {

    @BindView(R.id.edit_name)
    EditText editText1;
    @BindView(R.id.edit_family)
    EditText editText2;
    @BindView(R.id.edit_int)
    EditText editText3;
    @BindView(R.id.btn_send)
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_one);
        ButterKnife.bind(this);




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = editText1.getText().toString().trim();
                final String family = editText2.getText().toString().trim();

                Intent intent = new Intent(TestOneActivity.this, TestTwoActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("family", family);
                startActivity(intent);
            }
        });
    }
}
