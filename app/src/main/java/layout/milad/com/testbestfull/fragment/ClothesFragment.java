package layout.milad.com.testbestfull.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import layout.milad.com.testbestfull.R;
import layout.milad.com.testbestfull.adapter.ClothersAdapter;
import layout.milad.com.testbestfull.callback.DataFakeGenerate;

public class ClothesFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clothes, container, false);
        recyclerView = view.findViewById(R.id.clothes_recycler);
        ClothersAdapter clothersAdapter = new ClothersAdapter(getActivity(), DataFakeGenerate.getClothes(getActivity()));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(clothersAdapter);
        return view;
    }

    public static ClothesFragment newInstance() {

        Bundle args = new Bundle();

        ClothesFragment fragment = new ClothesFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
