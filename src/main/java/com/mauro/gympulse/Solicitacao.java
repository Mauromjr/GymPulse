package com.mauro.gympulse;

public class Solicitacao {

    private Long id;
    private String nomePersonal;
    private String idPersonal;

    public Solicitacao(Long id, String nomePersonal, String idPersonal) {
        this.id = id;
        this.nomePersonal = nomePersonal;
        this.idPersonal = idPersonal;
    }

    public Long getId() { return id; }
    public String getNomePersonal() { return nomePersonal; }
    public String getIdPersonal() { return idPersonal; }
}