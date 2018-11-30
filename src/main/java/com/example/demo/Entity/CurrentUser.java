package com.example.demo.Entity;

public class CurrentUser extends User {
    private User user;

    public CurrentUser(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }
}
