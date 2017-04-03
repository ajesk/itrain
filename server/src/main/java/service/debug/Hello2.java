package service.debug;

import lombok.extern.slf4j.Slf4j;
import spark.Request;
import spark.Response;

/**
 * Created by Aaron on 2/17/17.
 *
 * or this one...
 */
@Slf4j
public class Hello2 {
    public static String hello(Request request, Response response) {
        log.info("hello world2");
        return "hello2";
    }
}
