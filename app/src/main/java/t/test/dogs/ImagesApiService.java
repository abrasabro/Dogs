package t.test.dogs;

import retrofit2.Call;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Owner on 2/5/2018.
 */

public interface ImagesApiService {
    @PUT("/api/breed/{imagePath}/images") Call<ImagesResponse> getSubBreeds(@Path("imagePath") String imagePath);
    @PUT("/api/breed/{imagePath}/{imagePath2}/images") Call<ImagesResponse> getSubBreeds(@Path("imagePath") String imagePath, @Path("imagePath2") String imagePath2);
}
