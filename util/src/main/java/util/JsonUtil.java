package util;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by Aaron on 2/17/17.
 */
public class JsonUtil {
    private static Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}
