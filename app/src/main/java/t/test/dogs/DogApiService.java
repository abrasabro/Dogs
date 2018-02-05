package t.test.dogs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Owner on 2/5/2018.
 */

public interface DogApiService {
    @GET("/api/breeds/list") Call<BreedResponse> getBreeds();
}
