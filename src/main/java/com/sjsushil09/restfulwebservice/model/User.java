package com.sjsushil09.restfulwebservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<JobPost> jobPosts;

    public User(){ }

    public User(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.role = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return role;
    }

    public void setPosition(String position) {
        this.role = position;
    }

    public List<JobPost> getJobPosts() {
        return jobPosts;
    }

    public void setJobPosts(List<JobPost> jobPosts) {
        this.jobPosts = jobPosts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + role + '\'' +
                '}';
    }
}
