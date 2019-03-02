package layout.milad.com.testbestfull.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import layout.milad.com.testbestfull.R;
import layout.milad.com.testbestfull.models.SongObject;

public class AdapterClass extends ArrayAdapter<SongObject> {

    private Context ctx;
    private int res;
    private ArrayList<SongObject> list;

    public AdapterClass(Context context, int resource, ArrayList<SongObject> objects) {
        super(context, resource, objects);
        ctx = context;
        res = resource;
        list = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        view = LayoutInflater.from(ctx).inflate(res, parent, false);
        TextView fileName = view.findViewById(R.id.textSong);
        SongObject sdOb = list.get(position);
        fileName.setText(sdOb.getFileName());
        return view;
    }
}
