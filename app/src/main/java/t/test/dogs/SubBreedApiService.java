package t.test.dogs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Owner on 2/5/2018.
 */

public interface SubBreedApiService {
    @PUT("/api/breed/{baseBreed}/list") Call<SubBreedResponse> getSubBreeds(@Path("baseBreed") String baseBreed);
}
