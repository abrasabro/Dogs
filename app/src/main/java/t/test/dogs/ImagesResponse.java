package t.test.dogs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Owner on 2/5/2018.
 */

public class ImagesResponse {
    @SerializedName("status") private String status;
    @SerializedName("message") private List<String> imagePaths;

    public List<String> getImagePaths(){
        return imagePaths;
    }
    public String getStatus(){
        return status;
    }
}
