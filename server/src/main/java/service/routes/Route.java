package service.routes;

import spark.Request;
import spark.Response;

/**
 * Created by Aaron on 2/18/17.
 *
 * This is specifically a model for a controller (labeled as a route)
 * All routes will have their functionality defined and have their paths
 * referenced by the handler provider for use when an API call occurs.
 */
public abstract class Route {
    public Object get(Request request, Response response) {
        return "";
    }
    public String create(Request request, Response response) {
        return "";
    }
    public String update(Request request, Response response) {return "";}
    public String delete(Request request, Response response) {return "";}
}
