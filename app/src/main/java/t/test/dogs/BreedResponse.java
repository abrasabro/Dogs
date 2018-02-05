package t.test.dogs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Owner on 2/5/2018.
 */

public class BreedResponse {
    @SerializedName("status") String status;
    @SerializedName("message") List<String> breeds;

    public List<String> getBreeds(){
        return breeds;
    }
    public String getStatus(){
        return status;
    }
}
