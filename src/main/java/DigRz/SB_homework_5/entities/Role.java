package DigRz.SB_homework_5.entities;

public enum Role {
    ROLE_USER("User"),
    ROLE_ADMIN("Admin");

    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
