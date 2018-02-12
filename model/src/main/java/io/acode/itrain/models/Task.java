package io.acode.itrain.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Aaron on 2/17/17.
 *
 * Just a model
 */
@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    private int id;
    private String name;
    private String topic;
    private String content;
    private int user_id;
}
