package io.acode.itrain.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "assignment")
public class Assignment {
    @Id
    private int id;
    private int user_id;
    private int task_id;
    private String status;
}
