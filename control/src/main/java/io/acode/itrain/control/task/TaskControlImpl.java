package io.acode.itrain.control.task;

import com.google.inject.Inject;
import io.acode.itrain.control.ControlResponse;
import io.acode.itrain.db.HibernateConnection;
import io.acode.itrain.db.HibernateConnectionImpl;
import io.acode.itrain.models.Task;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class TaskControlImpl implements TaskControl {

    private HibernateConnection db;

    @Inject
    TaskControlImpl(HibernateConnectionImpl hibernateConnection) {
        db = hibernateConnection;
    }

    @Override
    public ControlResponse<List<Task>> getAllTasks() {
        List task = db.get("from Task");
        if (task.isEmpty()) {
            return new ControlResponse<>(false, "task result set empty");
        }

        if (!(task.get(0) instanceof Task)) {
            return new ControlResponse<>(false, "non-task results returned from query");
        }

        return new ControlResponse<>((List<Task>) task);
    }

    @Override
    public ControlResponse<Task> getTask(int id) {
        return new ControlResponse<>((Task) db.get(id, Task.class));
    }

    @Override
    public ControlResponse createTask(Task task) {
        try {
            db.save(task);
            return new ControlResponse();
        } catch (Exception e) {
            log.error("exception caught during task creation " + e.getMessage());
            return new ControlResponse(false, "task not created");
        }
    }

    @Override
    public ControlResponse updateTask(Task task) {
        if (task.getId() < 0) {
            return new ControlResponse(false, "invalid id");
        }
        db.update(task);
        return new ControlResponse();
    }

    @Override
    public ControlResponse deleteTask(int id) {
        try {
            Task task = new Task();
            task.setId(id);
            db.delete(task);
        } catch (Exception e) {
            return new ControlResponse(false, "exception caught while deleting user");
        }
        return new ControlResponse();
    }
}
