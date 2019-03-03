package layout.milad.com.testbestfull.callback;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import layout.milad.com.testbestfull.R;

public class DialogCall {

    private String response;
    private ClickEventHandler clickEventHandler;
    private Activity activity;

    public DialogCall(String response, ClickEventHandler clickEventHandler, Activity activity) {
        this.response = response;
        this.clickEventHandler = clickEventHandler;
        this.activity = activity;
    }

    public void dialogBuild() {

        Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.my_custom_dialog);
        Button btn = dialog.findViewById(R.id.btn1_dialog);
        Button btn2 = dialog.findViewById(R.id.btn2_dialog);
        TextView textView = dialog.findViewById(R.id.text_view_dialog);
        textView.setText(response);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEventHandler.onSuccess();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEventHandler.onFailure();
            }
        });

        dialog.show();
    }
}
