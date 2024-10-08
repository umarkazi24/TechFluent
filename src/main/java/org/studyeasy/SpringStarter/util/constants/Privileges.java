package org.studyeasy.SpringStarter.util.constants;

public enum Privileges {
    RESET_ANY_USER_PASSWORD(1l, "RESET_ANY_USER_PASSWORD"),
    ACCESS_ADMIN_PANEL(2l, "ACCESS_ADMIN_PANEL");

    private Long id;
    private String privilege;

    // Constructor
    private Privileges(Long id, String privilege) {
        this.id = id;
        this.privilege = privilege;
    }

    // Getter methods
    public Long getId() {
        return id;
    }

    public String getPrivilege() {
        return privilege;
    }
}