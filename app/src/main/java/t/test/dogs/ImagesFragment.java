package t.test.dogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 2/2/2018.
 */

public class ImagesFragment extends Fragment {

    String mBreed;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_images, container, false);
        mBreed = getArguments().getString("breed");
        RecyclerView recyclerView;
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_images);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        List<String> images = new ArrayList<String>();
        images.add("dfhadfhadfh");
        images.add("dfgadfg");
        recyclerView.setAdapter(new ImagesAdapter(images, R.layout.item_image, getContext()));
        return view;
    }
}
