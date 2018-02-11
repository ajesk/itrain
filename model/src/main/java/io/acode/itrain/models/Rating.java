package io.acode.itrain.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rating {

    @Id
    private double id;
    private float value;
    private int user_id;
    private int task_id;
}
