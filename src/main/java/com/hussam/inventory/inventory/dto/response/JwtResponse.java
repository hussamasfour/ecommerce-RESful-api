package com.hussam.inventory.inventory.dto.response;

import java.util.List;

public class JwtResponse {

  private String token;
  private String type = "Bearer";
  private String username;
  private String email;
  private List<String> roles;
  private long uid;


  public JwtResponse(String accessToken, Long id, String username, String email, List<String > roles) {
    this.token = accessToken;
    this.uid = id;
    this.username = username;
    this.email = email;
    this.roles = roles;

  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }
}