package edu.craptocraft;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumeroRomano {
    private final String numero;

    private int numeroDecimal;

    private ExpresionesRegulares expresiones = new ExpresionesRegulares();

    public NumeroRomano(String numero) {
        this.numero = numero;
    }



    private int getSumatorio(){
        int decimal = 0;
        String regex = expresiones.getConjuntoExpresion("sumatorios");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);
        while (matcher.find()) {
            decimal += calcularNumeroRomano(matcher.group());
        }
        return decimal;
    }

    private int getSustractivo(){
        int decimal = 0;
        String regex = expresiones.getConjuntoExpresion("sustractivos");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);
        while (matcher.find()) {
            decimal += calcularNumeroRomano(matcher.group());
        }
        return decimal;
    }

    private int calcularNumeroRomano(String n) {
        Simbolos simbolo = Enum.valueOf(Simbolos.class, String.valueOf(n));
        return simbolo.getNumero();
    }


    public int numeroDecimal() {
        return getSumatorio() + getSustractivo();
    }

    public Map regex()
        {
            return expresiones.getConjuntoExpresionesCompleto();
        }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(numero).append(" = ").append(numeroDecimal());
        return sb.toString();
    }
}
