package io.acode.itrain.control.task;

import io.acode.itrain.control.ControlResponse;
import io.acode.itrain.models.Task;

import java.util.List;

/**
 * Created by Aaron on 2/17/17.
 *
 */
public interface TaskControl {
    ControlResponse<List<Task>> getAllTasks();
    ControlResponse<Task> getTask(int id);
    ControlResponse createTask(Task task);
    ControlResponse updateTask(Task task);
    ControlResponse deleteTask(int id);
}
