package edu.craptocraft;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomansGoHomeTest {

    public NumeroRomano numeroRomano;
    @ParameterizedTest
    @CsvSource({"MMM, 3000", "MM, 2000", "M, 1000"})
    public void testM(String romano, int esperado) {
        numeroRomano = new NumeroRomano(romano);
        assertEquals(esperado, numeroRomano.numeroDecimal());
    }

    @ParameterizedTest
    @CsvSource({"X,10", "L, 50", "C, 100", "D, 500"})
    public void testLetrasSolas(String romano, int esperado) {
        numeroRomano = new NumeroRomano(romano);
        assertEquals(esperado, numeroRomano.numeroDecimal());
    }

    @ParameterizedTest
    @CsvSource({"XX,20", "LX, 60", "CL, 150", "DC, 600", "LX, 60", "LXX, 70", "LXXX, 80", "XV, 15"})
    public void testSumatorios(String romano, int esperado) {
        numeroRomano = new NumeroRomano(romano);
        assertEquals(esperado, numeroRomano.numeroDecimal());
    }

    @ParameterizedTest
    @CsvSource({"III,3", "XI, 11", "XXI, 21", "I, 1"})
    public void testI(String romano, int esperado) {
        numeroRomano = new NumeroRomano(romano);
        assertEquals(esperado, numeroRomano.numeroDecimal());
    }
    @ParameterizedTest
    @CsvSource({"UX,10", "QI, 1", "ÑL, 50", "TV, 5"})
    public void testNoNumeros(String romano, int esperado) {
        numeroRomano = new NumeroRomano(romano);
        assertEquals(esperado, numeroRomano.numeroDecimal());
    }

    @ParameterizedTest
    @CsvSource({"XIX, 19", "IV, 4", "XL, 40", "XC, 90", "CD, 400"})
    public void testSustractivos(String romano, int esperado) {
        numeroRomano = new NumeroRomano(romano);
        assertEquals(esperado, numeroRomano.numeroDecimal());
    }

    @ParameterizedTest
    @CsvSource({"DCLXVI, 666", "CMXCIX, 999", "MCDXLIV, 1444", "MMMDCCCLXXXVIII, 3888", "CDL, 450"})
    public void testComplejos(String romano, int esperado) {
        numeroRomano = new NumeroRomano(romano);
        assertEquals(esperado, numeroRomano.numeroDecimal());
    }

    @Test
    public void testExpresionesRegulares() {
        numeroRomano = new NumeroRomano("M");
        assertEquals(2, numeroRomano.regex().size());
        assertThat(numeroRomano.regex().get("sumatorios")).isEqualTo("(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])");
        assertThat(numeroRomano.regex().get("sustractivos")).isEqualTo("(C[DM])|(X[LC])|(I[VX])");
    }
    }
