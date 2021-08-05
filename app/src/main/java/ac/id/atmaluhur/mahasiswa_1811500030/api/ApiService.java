package ac.id.atmaluhur.mahasiswa_1811500030.api;

import ac.id.atmaluhur.mahasiswa_1811500030.model.ListLocationModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("JsonDisplayMarker.php")
    Call<ListLocationModel> getLocationHospital();

    @GET("JsonDisplayMarker1.php")
    Call<ListLocationModel> getLocationRestaurant();

    @GET("JsonDisplayMarker2.php")
    Call<ListLocationModel> getLocationSchool();
}
