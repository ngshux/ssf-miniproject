package com.example.ssfminiproject.Model;

public class User {
    private String name;
    private boolean loggedIn = false;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }
}
