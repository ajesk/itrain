package service.debug;

import lombok.extern.slf4j.Slf4j;
import spark.Request;
import spark.Response;

/**
 * Created by Aaron on 2/3/17.
 *
 * Don't think too hard about this one
 */
@Slf4j
public class Hello {

    public static String hello(Request request, Response response) {
        log.info("hello world");
        return "hello";
    }
}
