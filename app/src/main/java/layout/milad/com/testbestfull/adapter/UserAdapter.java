package layout.milad.com.testbestfull.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.List;

import layout.milad.com.testbestfull.R;
import layout.milad.com.testbestfull.models.User;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;
    private List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_user, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        User user = userList.get(i);

        TextView txt_name = viewHolder.txt_name;
        txt_name.setText(user.getFirstName());

        TextView txt_family = viewHolder.txt_family;
        txt_family.setText(user.getLastName());

        Glide.with(context).load(user.getAvater()).into(viewHolder.img_user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_name, txt_family;
        private ImageView img_user;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_first_name);
            txt_family = itemView.findViewById(R.id.txt_last_name);
            img_user = itemView.findViewById(R.id.img_user);
        }
    }
}

