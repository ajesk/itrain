package io.acode.itrain.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class TaskList {

    @Id
    private int id;
    private int assignee;
    private int task_id;
    private String status;
}
