package com.simulator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "statistic")
public class Statistic {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "exercise_time")
    private java.sql.Time exercise_time;
    @Column(name = "num_of_mistakes")
    private int num_of_mistakes;
    @Column(name = "speed")
    private int speed;
    @Column(name = "date")
    private java.sql.Timestamp date;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exersise_id", nullable = false)
    private Exercise exercise;


    @JsonProperty("exersise_id")
    private void unpackNestedExersise(Long id) {
        this.exercise = new Exercise();
        exercise.setId(id);
    }

    public Long getExersise_id() {
        return exercise.getId();
    }

    public void setExersise_id(Exercise exercise) {
        this.exercise = exercise;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserKS userKS;


    @JsonProperty("user_id")
    private void unpackNestedUser(Long id) {
        this.userKS = new UserKS();
        userKS.setId(id);
    }

    public Long getUser_id() {
        return userKS.getId();
    }

    public void setUser_id(UserKS userKS) {
        this.userKS = userKS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public java.sql.Time getExercise_time() {
        return exercise_time;
    }

    public void setExercise_time(java.sql.Time exercise_time) {
        this.exercise_time = exercise_time;
    }

    public int getNum_of_mistakes() {
        return num_of_mistakes;
    }

    public void setNum_of_mistakes(int num_of_mistakes) {
        this.num_of_mistakes = num_of_mistakes;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public java.sql.Timestamp getDate() {
        return date;
    }

    public void setDate(java.sql.Timestamp date) {
        this.date = date;
    }
}
