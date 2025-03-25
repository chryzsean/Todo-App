package com.chrzsean.projects.Spring.Boot.Web.App.Todo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @Size(min=5, message = "Enter at least 5 characters")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate targetDate;
    private boolean done;

    // ✅ No-args constructor required by JPA
    public Todo() {

    }

    // ✅ Constructor matching your controller
    public Todo(String username, String description, LocalDate targetDate, boolean done) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    // ✅ Constructor with ID (Used internally by JPA)
    public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}