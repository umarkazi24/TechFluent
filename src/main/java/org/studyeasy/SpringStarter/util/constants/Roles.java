package org.studyeasy.SpringStarter.util.constants;

public enum Roles {
    USER("ROLE_USER"), 
    ADMIN("ROLE_ADMIN"), 
    EDITOR("ROLE_EDITOR");

    private String role;

    // Constructor
    private Roles(String role) {
        this.role = role;
    }

    // Getter method
    public String getRole() {
        return role;
    }    
}