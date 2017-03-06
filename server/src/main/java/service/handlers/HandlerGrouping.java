package service.handlers;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 2/17/17.
 */
@Data
public class HandlerGrouping {
    List<Handler> handlers = new ArrayList<>();
}
