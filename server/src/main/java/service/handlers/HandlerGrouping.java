package service.handlers;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 2/17/17.
 *
 * Simply an object that holds the handlers constructed by the handler provider.
 */
@Data
public class HandlerGrouping {
    List<Handler> handlers = new ArrayList<>();
}
