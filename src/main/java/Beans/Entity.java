package Beans;

import java.io.Serializable;

public abstract class Entity implements Serializable, Cloneable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    public Entity() {
    }
    public Entity(Integer id) {
        this.id = id;
    }

}