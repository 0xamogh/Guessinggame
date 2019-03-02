package amoghjapps.com.guessinggame;

import android.net.Uri;

import java.util.List;

import amoghjapps.com.guessinggame.JSONResponses.Response;
import amoghjapps.com.guessinggame.JSONResponses.Tag;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ImaggaClient {

    final Integer integer=10;

    @GET("tags")
    Call<Response> getTag(@Query("image_url") String url);

    @POST("uploads/")
    Call<Response> uploadImage(@Query("image_base64") String base64encoded);

   }