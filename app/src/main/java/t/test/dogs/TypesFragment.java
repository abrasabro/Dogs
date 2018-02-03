package t.test.dogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TypesFragment extends Fragment {

    private static final String TAG = "TypesFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_types, container, false);
        RecyclerView recyclerView;
        List<String> breeds = new ArrayList<String>();
        breeds.add("adfhadfh");
        breeds.add("rtuwtrd");
        breeds.add("erttruit");
        breeds.add("dfjare");
        breeds.add("fgjdfa");
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_types);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new TypesAdapter(breeds, R.layout.item_type, getContext()));
        return view;
    }
}
