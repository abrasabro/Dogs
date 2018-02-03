package t.test.dogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Owner on 2/2/2018.
 */

public class BreedFragment extends Fragment{

    String mBreed;
    Toolbar mToolbar;
    ImageView mImageView;
    Button mButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_breed, container, false);
        mBreed = getArguments().getString("breed");
        mToolbar = view.findViewById(R.id.toolbarBreed);
        mToolbar.setTitle(mBreed);
        mImageView = view.findViewById(R.id.imageView_breed);
        //get image from dogs api
        mButton = view.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).changeFragment(R.layout.fragment_images, mBreed);
            }
        });
        return view;
    }

}
