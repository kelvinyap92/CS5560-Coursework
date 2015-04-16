package edu.wmich.convert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KelvinYap
 */
public class Javabean {
    
private String function;
    private String from;
    private String to;
    private double newTemperature;
    private double temp;

    /**
     * @return the function
     */
    public String getFunction() {
        return function;
    }

    /**
     * @param function the function to set
     */
    public void setFunction(String function) {
        this.function = function;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the newTemperature
     */
    public double getNewTemperature() {
        
        if(from.equals("FrCelsius")) {
            if(to.equals("ToCelsius")) {
                newTemperature = temp;
                setFunction("°C");
            }else if(to.equals("ToFahrenheit")) {
                newTemperature = (temp * (1.8) + 32);
                setFunction("°F");
            }else if(to.equals("ToKelvin")) {
                newTemperature = temp + 273.15;
                setFunction("°K");
            }else if(to.equals("ToRankine")) {
                newTemperature = (temp + 273.15) * (1.8);
                setFunction("°R");
            }
            
        } else if (from.equals("FrFahrenheit")){
            if (to.equals("ToCelsius")) {
                newTemperature = (0.56) * (temp - 32);
                 setFunction("°C");
            } else if(to.equals("ToFahrenheit")) {
                newTemperature = temp;
                 setFunction("°F");
            }else if (to.equals("ToKelvin")) {
                newTemperature = (temp + 459.67) * (0.56);
                 setFunction("°K");
            }else if(to.equals("ToRankine")){
                newTemperature = temp + 459.67;
                 setFunction("°R");
                
            }
          
        } else if(from.equals("FrKelvin")) {
            if(to.equals("ToCelsius")) {
                newTemperature = temp - 273.15;
                setFunction("°C");
            } else if (to.equals("ToFahrenheit")) {
                newTemperature = temp * (1.8) - 459.67;
                setFunction("°F");
            } else if (to.equals("ToKelvin")){
                newTemperature = temp;
                setFunction("°K");
            } else if (to.equals("ToRankine")) {
                newTemperature = temp  * (1.8);
                setFunction("°R");
            }
        } else if (from.equals("FrRankine")) {
            if(to.equals("ToCelsius")) {
                newTemperature = (temp - 491.67) * (0.56);
                setFunction("°C");
            }else if (to.equals("ToFahrenheit")) {
                newTemperature = temp - 459.67;
                setFunction("°F");
            } else if( to.equals("ToKelvin")) {
                newTemperature = temp * (0.56);
                setFunction("°K");
            } else if (to.equals("ToRankine")) {
                newTemperature = temp;
                setFunction("°R");
            }
        }
        
        return newTemperature;
    }


    /**
     * @return the temp
     */
    public double getTemp() {
        return temp;
    }

    /**
     * @param temperature the temp to set
     */
    public void setTemperature(double temperature) {
        this.temp = temperature;
    }

}
    

