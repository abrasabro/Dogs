package t.test.dogs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by Owner on 2/2/2018.
 */

public class BreedFragment extends Fragment{

    private static final String TAG = "BreedFragment";
    String mBreed;
    Toolbar mToolbar;
    ImageView mImageView;
    Button mButton;
    Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_breed, container, false);
        mBreed = getArguments().getString("breed");
        mToolbar = view.findViewById(R.id.toolbarBreed);
        mToolbar.setTitle(mBreed);
        mImageView = view.findViewById(R.id.imageView_breed);
        mButton = view.findViewById(R.id.button);
        mContext = getContext();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).changeFragment(R.layout.fragment_images, mBreed);
            }
        });
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://dog.ceo//").addConverterFactory(GsonConverterFactory.create()).build();
        ImagesApiService imagesApiService = retrofit.create(ImagesApiService.class);
        String baseBreed;
        String subBreed;
        String path;
        baseBreed = ((MainActivity)getActivity()).getBaseBreed(mBreed);
        subBreed = ((MainActivity)getActivity()).getSubBreed(mBreed);
        Call<ImagesResponse> call;
        if(subBreed.equals("")){
            call = imagesApiService.getSubBreeds(baseBreed);
            call.enqueue(new Callback<ImagesResponse>() {
                @Override
                public void onResponse(Call<ImagesResponse> call, Response<ImagesResponse> response) {
                    List<String> imagePaths = response.body().getImagePaths();
                    Picasso.with(mContext)
                            .load(imagePaths.get(0))
                            .placeholder(android.R.drawable.sym_def_app_icon)
                            .error(android.R.drawable.sym_def_app_icon)
                            .into(mImageView);
                }

                @Override
                public void onFailure(Call<ImagesResponse> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t);
                }
            });
        }else {
            call = imagesApiService.getSubBreeds(baseBreed, subBreed);
            call.enqueue(new Callback<ImagesResponse>() {
                @Override
                public void onResponse(Call<ImagesResponse> call, Response<ImagesResponse> response) {
                    List<String> imagePaths = response.body().getImagePaths();
                    Picasso.with(mContext)
                            .load(imagePaths.get(0))
                            .placeholder(android.R.drawable.sym_def_app_icon)
                            .error(android.R.drawable.sym_def_app_icon)
                            .into(mImageView);
                }

                @Override
                public void onFailure(Call<ImagesResponse> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t);
                }
            });
        }
        return view;
    }

}
