package com.dossis.curso4semana3.pojo;

public class UsuarioResponse {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTokenFCM() {
        return tokenFCM;
    }

    public void setTokenFCM(String tokenFCM) {
        this.tokenFCM = tokenFCM;
    }

    private String id;
    private String tokenFCM;

    public String getIdIG() {
        return idIG;
    }

    public void setIdIG(String idIG) {
        this.idIG = idIG;
    }

    private String idIG;
    public UsuarioResponse() {

    }

    public UsuarioResponse(String id, String tokenFCM, String idIG) {
        this.id = id;
        this.tokenFCM = tokenFCM;
        this.idIG = idIG;
    }
}
