package io.acode.itrain.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Aaron on 2/17/17.
 */
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    private long id;
    private String name;
    private String email;
    private String position;
    private String password;
}
