/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.modelo;

/**
 *
 * @author kriz_
 */
public class Region {
    
    private int cod;
    private String region;

    public Region() {}

    public Region(int cod, String region) {
        this.cod = cod;
        this.region = region;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    } 
    
    @Override
    public String toString() {
        return "region{" + "id_region" + String.valueOf(getCod()) + ",Nombre=" + getRegion() + '}';
    }
       
}
