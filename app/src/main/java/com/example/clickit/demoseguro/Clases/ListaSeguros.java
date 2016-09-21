package com.example.clickit.demoseguro.Clases;

/**
 * Created by clickit on 20/09/16.
 */
public class ListaSeguros {
    private String costo;

    public ListaSeguros(String costo) {
        this.costo = costo;
    }

    public String getCosto() {
        return costo;
    }

    public ListaSeguros() {
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
}
