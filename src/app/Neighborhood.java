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

import java.io.Serializable;

public class Neighborhood extends Record implements Serializable {
    
    public Neighborhood(String name, int demographicRate, double perCaptaIncome, int crimeRate) {
        setName(name);
        setDemographicRate(demographicRate);
        setPerCaptaIncome(perCaptaIncome);
        setCrimeRate(crimeRate);
    }


}