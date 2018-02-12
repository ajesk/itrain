package io.acode.itrain.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rating")
public class Rating {
    @Id
    private double id;
    private int value;
    private int user_id;
    private int task_id;
}
