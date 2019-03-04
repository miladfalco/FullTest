package layout.milad.com.testbestfull.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import layout.milad.com.testbestfull.R;
import layout.milad.com.testbestfull.models.Cloth;

public class ClothersAdapter extends RecyclerView.Adapter<ClothersAdapter.ClothesViewHolder> {

    private Context context;
    private List<Cloth> cloths;

    public ClothersAdapter(Context context, List<Cloth> cloths) {
        this.context = context;
        this.cloths = cloths;
    }

    @NonNull
    @Override
    public ClothesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_clothing_item, viewGroup, false);
        return new ClothesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothesViewHolder holder, int i) {

        Cloth cloth = cloths.get(i);

        holder.clothImage.setImageDrawable(cloth.getImage());

        holder.clothTitle.setText(cloth.getTitle());

        holder.clothViewCount.setText(String.valueOf(cloth.getViewCount()));
    }

    @Override
    public int getItemCount() {
        return cloths.size();
    }

    public class ClothesViewHolder extends RecyclerView.ViewHolder {
        private ImageView clothImage;
        private TextView clothTitle, clothViewCount;

        public ClothesViewHolder(@NonNull View itemView) {
            super(itemView);
            clothImage = itemView.findViewById(R.id.clothing_image);
            clothTitle = itemView.findViewById(R.id.clothing_title);
            clothViewCount = itemView.findViewById(R.id.clothing_count_text);
        }
    }
}
