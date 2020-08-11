package sample.model;

import java.util.Set;

public final class UserSession {

    private static UserSession instance;

    private String username;
    private Set<Role> roles;

    private UserSession(String username, Set<Role> roles) {
        this.username = username;
        this.roles = roles;
    }

    public static UserSession getInstance(String username, Set<Role> privileges) {
        if(instance == null) {
            instance = new UserSession(username, privileges);
        }
        return instance;
    }

    public static UserSession getInstance() {
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void cleanUserSession() {
        username = null;
        roles = null;
        instance = null;
    }

    @Override
    public String toString() {
        return String.format("UserSession{username=%s, roles=%s}", username, roles.toString());
    }
}