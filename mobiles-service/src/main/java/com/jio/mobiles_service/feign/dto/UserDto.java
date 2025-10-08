package com.jio.mobiles_service.feign.dto;

public class UserDto {
    private Long id;
    private String username;
    private String email;

    public UserDto() {}
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
}
