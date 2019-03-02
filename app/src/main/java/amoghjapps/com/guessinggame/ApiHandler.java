package amoghjapps.com.guessinggame;

public class ApiHandler {

    public static final String BASE_URL = "https://api.imagga.com";

    public static ImaggaClient create() {
        return RetrofitClient.getClient(BASE_URL).create(ImaggaClient.class);
    }
}
