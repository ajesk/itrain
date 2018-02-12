package io.acode.spark_starter.service.routes;

import com.google.inject.Inject;
import io.acode.itrain.control.ControlResponse;
import io.acode.itrain.control.task.TaskControl;
import io.acode.itrain.control.task.TaskControlImpl;
import io.acode.itrain.models.Task;
import io.acode.spark_starter.util.JsonUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import spark.Request;
import spark.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the basic implementation of a Spark route handler. Each call from the framework gets a Spark request and
 * response object. Additional calls can be added here and/or in the Route abstract class and called from the
 * HandlerProvider class.
 *
 * Try not to use this to handle any business logic as this should be treated more as a pass through to your Controller
 * classes. This here should be utilized just to handle the Spark internals regarding the request and response.
 */
@Slf4j
public class TaskRoute extends Route {

    private TaskControl taskService;

    @Inject
    public TaskRoute(TaskControlImpl taskService) {
        this.taskService = taskService;
    }

    @Override
    public List<Task> get(Request request, Response response) {
        log.info("get all tasks called");

        try {
            ControlResponse<List<Task>> controlResponse = taskService.getAllTasks();
            if (!controlResponse.isSuccess()) {
                response.status(404);
                return new ArrayList<>();
            }

            response.status(200);
            return controlResponse.getResult();
        } catch (Exception e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Task getById(Request request, Response response) {
        log.info("get task by id called");
        int id;

        try {
            id = Integer.parseInt(request.params("id"));
        } catch (Exception e) {
            log.error("invalid id provided");
            response.status(422);
            return new Task();
        }

        ControlResponse controlResponse = taskService.getTask(id);

        if (!controlResponse.isSuccess()) {
            log.warn("task not found");
            response.status(404);
            return null;
        }

        if (controlResponse.getResult() instanceof Task) {
            response.status(200);
            return (Task) controlResponse.getResult();
        }

        response.status(500);
        return new Task();
    }

    @Override
    public String create(Request request, Response response) {
        log.info("create task called");
        Task task = JsonUtil.fromJson(request.body(), Task.class);

        if (task == null) {
            response.status(422);
            return "unable to parse request body";
        }

        ControlResponse controlResponse = taskService.createTask(task);

        if (!controlResponse.isSuccess()) {
            response.status(500);
            return "unable to create task";
        }

        response.status(200);
        return "ok";
    }

    @Override
    public String update(Request request, Response response) {
        log.info("update task called");
        try {
            Task task = JsonUtil.fromJson(request.body(), Task.class);

            if (task == null) {
                response.status(400);
                return "unable to parse request body";
            }

            ControlResponse controlResponse = taskService.updateTask(task);

            if (!controlResponse.isSuccess()) {
                response.status(404);
                return "task does not exist";
            }
        } catch (Exception e) {
            log.error("exception caught in handling update: " + e.getMessage());
            response.status(500);
            return "error";
        }

        response.status(200);
        return "ok";
    }

    @Override
    public String delete(Request request, Response response) {
        log.info("delete task called");
        int id;

        try {
            id = Integer.parseInt(request.params("id"));
        } catch (Exception e) {
            log.error("invalid id provided");
            response.status(500);
            return "error";
        }

        ControlResponse controlResponse = taskService.deleteTask(id);

        if (!controlResponse.isSuccess()) {
            log.warn("task not deleted");
            response.status(404);
            return "error";
        }

        response.status(200);
        return "ok";
    }
}
