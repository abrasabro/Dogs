package t.test.dogs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private CoverFragment mCoverFragment;
    private TypesFragment mTypesFragment;
    private BreedFragment mBreedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCoverFragment = new CoverFragment();
        mTypesFragment = new TypesFragment();
        mBreedFragment = new BreedFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, mCoverFragment).commit();
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
            //mImagesFragment.setArguments(bundle);
            //transaction.replace(R.id.framelayout, mImagesFragment);
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
