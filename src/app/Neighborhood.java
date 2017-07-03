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

/**
 * This clas describes a neighborhood object.
 * The rates contained it, updates the city rates.
 */
public class Neighborhood extends Record {

    /**
     * Serial version constante of Serializable class.
     */
    private static final long serialVersionUID = -842012067799192648L;

    /**
     * Neighborhood object constructor. He attributes states of name, demographic
     * rate, per capta income rate and crime rate.
     * 
     * @param name Neighborhood name String.
     * @param demographicRate Integer demographic rate value.
     * @param perCaptaIncome Per capta income rate value.
     * @param crimeRate Neighborhood crime rate value.
     */
    public Neighborhood(String name, int demographicRate, double perCaptaIncome, int crimeRate) {
        setName(name);
        setDemographicRate(demographicRate);
        setPerCaptaIncome(perCaptaIncome);
        setCrimeRate(crimeRate);
    }

    /**
     * This method is an override.
     * He returns all informations about the neighborhood.
     * 
     * @return String Neighborhood object ttribute states.  
     */
    @Override
    public String toString() {
        String s = "[Neighborhood Name]: " + getName() +".\n";
        s += "[Demographic Rate]: " + getDemographicRate() + " peoples.\n";
        s += "[Per Capta Income Rate]: " + getPerCaptaIncome() + "\n";
        s += "[Crime Rate]: " + getCrimeRate() + " crime cases.\n";
        return s;
    }

}