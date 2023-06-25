package com.sistema.examenes.entity;

public class JwtResponse {
    /**
     * Esta clase es cuando respondemos con el Token
     */

    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public JwtResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
