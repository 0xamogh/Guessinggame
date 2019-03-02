package amoghjapps.com.guessinggame;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    final String baseUrl="";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .authenticator(new Authenticator() {
                        @Override
                        public Request authenticate(Route route,
                                                    Response response)
                                throws IOException {
                            String credential =
                                    Credentials.basic("acc_4cc1a25f96cb72f",
                                            "ea3ab2f25a0bba314f9d4952c577157a");

                            return response.request()
                                    .newBuilder()
                                    .header("Authorization", credential)
                                    .build();
                        }
                    }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.imagga.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}