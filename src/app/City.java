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

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * This class describes the City object.
 * It extends the Record abstract class and
 * contains a district, country, mayor and neighborhood
 * list attribute.
 */
public class City extends Record {

    /**
     * Serial version constant value attribute;
     */
    private static final long serialVersionUID = -842012067799192648L;
    /**
     * District name string attribute state.
     */
    private String district;

    /**
     * Country name string attribute state.
     */
    private String country;

    /**
     * Mayor name string attribute state.
     */
    private String mayor;

    /**
     * Neighborhoods list attribute.
     */
    private List<Neighborhood> neighborhoodSet;

    /**
     * City object constructor.
     * It set the name, district, country and mayor
     * state attributes by parameters and instances
     * the neighborhood array list data structure.
     * 
     * @param name Name attribute state object String.
     * @param district District attribute state object String.
     * @param country Country of city attribute state object String.
     * @param mayor City mayor name attribute state object String.
     */
    public City(
        String name,
        String district,
        String country,
        String mayor
        ) {
            setName(name);
            setDistrict(district);
            setCountry(country);
            setMayor(mayor);
            neighborhoodSet = new ArrayList<Neighborhood>();
        }

    /**
     * District name string attribute state modifier method.
     * 
     * @param district String district name.
     */
    public void setDistrict(String district) {
        this.district = district.toLowerCase();
    }

    /**
     * Country name string attribute state modifier method.
     * 
     * @param country String country name.
     */
    public void setCountry(String country) {
        this.country = country.toLowerCase();
    }

    /**
     * Country name string attribute state accessor method.
     * 
     * @return String String country name.
     */
    public String getCountry() {
        return this.country;
    }

    public String getMayor() {
        return this.mayor;
    }
    /**
     * Mayor string name attribute state modifier method.
     * 
     * @param mayor String mayor name.
     */
    public void setMayor(String mayor) {
        this.mayor = mayor.toLowerCase();
    }

    public String getDistrict() {
        return this.district;
    }
    /**
     * This method is responsible for add new neighborhoods
     * into neighborhood list. This list is a attribute.
     * 
     * @param n New neighborhood object for inserction.
     */
    public void addNeighborhood(Neighborhood n) {
        this.neighborhoodSet.add(n);
        updateRates();
    }

    public List<Neighborhood> getNeighborhoods() {
        if(neighborhoodSet.size() == 0) {
            return null;
        }else {
            return neighborhoodSet;
        }
    }

    /**
     * This method is responsible for remove a especific
     * neighborhood of neighborhood list attribute.
     * 
     * @param n Neighborhood to remove.
     */
    public void removeNeighborhood(Neighborhood n) {
        this.neighborhoodSet.remove(n);
        updateRates();
    }

    /**
     * This method is responsible for update all rates informations
     * about the city. It counts rates for all neighborhoods.
     * 
     * @return String String menssage operation successful.
     */
    public String updateRates() {
        String operation = "";
        resetAllCityRates();
        for(Neighborhood n : neighborhoodSet) {
            operation += "+--------------------------------------------------+\n";
            operation += "["+n.getName()+"]:\n";
            operation += n.getDemographicRate() + " peoples. \n";
            operation += n.getPerCaptaIncome() + " per capta income rate. \n";
            operation += n.getCrimeRate() + " crime cases. \n";
            operation += "+--------------------------------------------------+\n";
            setDemographicRate(getDemographicRate() + n.getDemographicRate());
            setPerCaptaIncome(getPerCaptaIncome() + n.getPerCaptaIncome());
            setCrimeRate(getCrimeRate() + n.getCrimeRate());
        }
        return operation;
    }

    /**
     * This method resets all rates states attributes of city.
     */
    private void resetAllCityRates() {
        setDemographicRate(0);
        setPerCaptaIncome(0);
        setCrimeRate(0);
    }

}