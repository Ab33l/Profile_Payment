package com.example.android.profile_payment;
import java.util.List;
import com.example.android.profile_payment.Donor;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
public interface DonorClient {
   @GET ("/donor/{id}")
  Call<Donor> donor(
    @Path("id") int id
  );
@POST ("donor/update")
  Call<Donor> update (@Body Donor donor);
}
