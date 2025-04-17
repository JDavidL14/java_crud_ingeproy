package com.crud.card.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Alumno {
    @JsonProperty("carrera")
    private String carrera;
    @JsonProperty("anio")
    private String anio;
    @JsonProperty("correlativo")
    private String correlativo;
    @JsonProperty("pnombre")
    private String pnombre;
    @JsonProperty("snombre")
    private String snombre;
    @JsonProperty("papellido")
    private String papellido;
    @JsonProperty("sapellido")
    private String sapellido;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("email")
    private String email;
    @JsonProperty("institucion")
    private String institucion;
    @JsonProperty("tipoParticipante")
    private short tipoParticipante;
    @JsonProperty("qrcode")
    private byte[] qrcode;
    @JsonProperty("boleta")
    private byte[] boleta;

    // Constructor vacío
    public Alumno() {
    }
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getPapellido() {
        return papellido;
    }

    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }

    public String getSapellido() {
        return sapellido;
    }

    public void setSapellido(String sapellido) {
        this.sapellido = sapellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public short getTipoParticipante() {
        return tipoParticipante;
    }

    public void setTipoParticipante(short tipoParticipante) {
        this.tipoParticipante = tipoParticipante;
    }

    public byte[] getQrcode() {
        return qrcode;
    }

    public void setQrcode(byte[] qrcode) {
        this.qrcode = qrcode;
    }

    public byte[] getBoleta() {
        return boleta;
    }

    public void setBoleta(byte[] boleta) {
        this.boleta = boleta;
    }
}
