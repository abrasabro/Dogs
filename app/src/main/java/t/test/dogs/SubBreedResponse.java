package t.test.dogs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Owner on 2/5/2018.
 */

public class SubBreedResponse {
    @SerializedName("status") String status;
    @SerializedName("message") List<String> subBreeds;

    public List<String> getSubBreeds(){
        return subBreeds;
    }
    public String getStatus(){
        return status;
    }
}
