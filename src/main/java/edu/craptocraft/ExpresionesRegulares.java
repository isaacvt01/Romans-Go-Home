package edu.craptocraft;

import java.util.HashMap;
import java.util.Map;

public class ExpresionesRegulares {
    private final Map<String, String> conjuntoExpresiones = new HashMap<String, String>();
    public ExpresionesRegulares() {
        this.cargarExpresionesRegulares();
    }
    private void cargarExpresionesRegulares(){
        String regexSumatorios = "(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])";
        String regexSustractivos = "(C[DM])|(X[LC])|(I[VX])";
        conjuntoExpresiones.put("sumatorios", regexSumatorios);
        conjuntoExpresiones.put("sustractivos", regexSustractivos);
    }

    public Map<String, String> getConjuntoExpresiones() {
        return conjuntoExpresiones;
    }

    public String getConjuntoExpresion(String tipo) {
        return conjuntoExpresiones.get(tipo);
    }
    public Map getConjuntoExpresionesCompleto(){
        return this.conjuntoExpresiones;
    }
}
