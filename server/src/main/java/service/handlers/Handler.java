package service.handlers;

import lombok.Data;
import spark.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aaron on 2/3/17.
 */
@Data
public class Handler {
    private String method;
    private String path;
    private Route route;
    private final List<String> VALID_METHODS = new ArrayList<>(Arrays.asList("GET", "POST", "PUT", "DELETE", "TRACE" ));

    public Handler(String method, String path, Route route) {
        if (!VALID_METHODS.contains(method.toUpperCase())) {
            throw new IllegalArgumentException("Invalid method: " + method);
        } else {
            setMethod(method.toUpperCase());
            setPath(path);
            setRoute(route);
        }
    }
}
