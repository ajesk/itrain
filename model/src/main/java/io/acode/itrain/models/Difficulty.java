package io.acode.itrain.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "difficulty")
@Data
public class Difficulty {
    @Id
    private int id;
    private int value;
    private int user_id;
    private int task_id;
}
