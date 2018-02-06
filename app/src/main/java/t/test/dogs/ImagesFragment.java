package t.test.dogs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Owner on 2/2/2018.
 */

public class ImagesFragment extends Fragment {

    private static final String TAG = "ImagesFragment";
    private String mBreed;
    private Context mContext;
    private List<String> mImagePaths;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_images, container, false);
        mBreed = getArguments().getString("breed");

        final RecyclerView recyclerView;
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_images);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
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
                    mImagePaths = response.body().getImagePaths();
                    recyclerView.setAdapter(new ImagesAdapter(mImagePaths, R.layout.item_image, getContext()));
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
                    mImagePaths = response.body().getImagePaths();
                    recyclerView.setAdapter(new ImagesAdapter(mImagePaths, R.layout.item_image, getContext()));
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
