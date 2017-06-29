/**
 *
 *  CITY MANAGER 1.0 June 26, 2017.
 *  Pratical Project by Paradigms and Programming Languages
 *  GCC198 - Federal University of Lavras (UFLA)
 *
 *  @author Lucas Fonseca dos Santos
 *  @author Leticia Ferreira
 */
package app;

public class City {

    private String name;
    private String district;
    private String country;
    private int populationAmount;
    private double pib;
    private String mayor;

    public City(String name, String district, String country, int populationAmount, double pib, String mayor) {
        this.name = name;
        this.district = district;
        this.country = country;
        this.populationAmount = populationAmount;
        this.pib = pib;
        this.mayor = mayor;
    }

}