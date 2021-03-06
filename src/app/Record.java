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

/**
 * This public abstract class describes all records information.
 * It contains the common characteristics between the class
 * City and Neighborhood.
 */
public abstract class Record implements Serializable{

    /**
     * Constant serial version id value attribute;
     */
    private static final long serialVersionUID = -842012067799192648L;

    /**
     * String name attribute;
     */
    private String name;

    /**
     * Integer demographic rate attribute;
     */
    private int demographicRate;

    /**
     * Double per capta income attribute;
     */
    private double perCaptaIncome;

    /**
     * Integer crime rate attribute;
     */
    private int crimeRate;

    /**
     * Public name attribute modifier method.
     * 
     * @param name Name record string.
     */
    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    /**
     * Public name attribute accessor method.
     * 
     * @return String Object name string.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Public demographic rate attribute accessor method.
     * 
     * @return int Integer demographic rate attribute state.
     */
    public int getDemographicRate() {
        return this.demographicRate;
    }

    /**
     * Public per capta income rate attribute accessor method.
     * 
     * @return double Per capta income rate attribute state.
     */
    public double getPerCaptaIncome() {
        return this.perCaptaIncome;
    }

    /**
     * Public crime rate attribute accesspr method.
     * 
     * @return int Integer crime rate attribute state.
     */
    public int getCrimeRate() {
        return this.crimeRate;
    }

    /**
     * Demographic rate attribute state modifier.
     * 
     * @param demographicRate Integer demographic rate value.
     */
    public void setDemographicRate(int demographicRate) {
        this.demographicRate = demographicRate;
    }

    /**
     * Per Capta Income attribute state modifier method.
     * 
     * @param perCaptaRate Double per capta rate value.
     */
    public void setPerCaptaIncome(double perCaptaRate) {
        this.perCaptaIncome = perCaptaRate;
    }

    /**
     * Crime rate attribute state modifier method.
     * 
     * @param crimeRate Integer crime rate value.
     */
    public void setCrimeRate(int crimeRate) {
        this.crimeRate = crimeRate;
    }
}