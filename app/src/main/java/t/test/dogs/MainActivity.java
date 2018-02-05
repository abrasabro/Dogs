package t.test.dogs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private CoverFragment mCoverFragment;
    private TypesFragment mTypesFragment;
    private BreedFragment mBreedFragment;
    private ImagesFragment mImagesFragment;
    private static Retrofit retrofit = null;
    List<String> mAllBreeds;
    Map<String, String> mBaseBreed;
    Map<String, String> mSubBreed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCoverFragment = new CoverFragment();
        mTypesFragment = new TypesFragment();
        mBreedFragment = new BreedFragment();
        mImagesFragment = new ImagesFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, mCoverFragment).commit();
        retrofit = new Retrofit.Builder().baseUrl("http://dog.ceo").addConverterFactory(GsonConverterFactory.create()).build();
        DogApiService dogApiService = retrofit.create(DogApiService.class);
        Call<BreedResponse> call = dogApiService.getBreeds();
        final String json;
        call.enqueue(new Callback<BreedResponse>() {
            @Override
            public void onResponse(Call<BreedResponse> call, Response<BreedResponse> response) {
                Log.d(TAG, "GAYYYYYYYYYYYYY");
                List<String> breeds = response.body().getBreeds();
                Log.d(TAG, "Number of breeds received: " + breeds.size());
                Log.d(TAG, "first breed: " + breeds.get(0));
            }

            @Override
            public void onFailure(Call<BreedResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    public void changeFragment(int resource, String... info){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(resource == R.layout.fragment_cover) {
            transaction.replace(R.id.framelayout, mCoverFragment);
        }
        if(resource == R.layout.fragment_types) {
            transaction.replace(R.id.framelayout, mTypesFragment);
        }
        if(resource == R.layout.fragment_breed) {
            Bundle bundle = new Bundle();
            bundle.putString("breed", info[0]);
            mBreedFragment.setArguments(bundle);
            transaction.replace(R.id.framelayout, mBreedFragment);
        }
        if(resource == R.layout.fragment_images) {
            Bundle bundle = new Bundle();
            bundle.putString("breed", info[0]);
            mImagesFragment.setArguments(bundle);
            transaction.replace(R.id.framelayout, mImagesFragment);
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public List<String> getAllBreeds(){
        return mAllBreeds;
    }
    public Map<String, String> getBaseBreed(){
        return mBaseBreed;
    }
    public Map<String, String> getSubBreed(){
        return mSubBreed;
    }
}
