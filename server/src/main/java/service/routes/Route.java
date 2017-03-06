package service.routes;

import spark.Request;
import spark.Response;

/**
 * Created by Aaron on 2/18/17.
 */
public abstract class Route {
    public Object get(Request request, Response response) {

        return "";
    }

    public String create(Request request, Response response) {

        return "";
    }
}
