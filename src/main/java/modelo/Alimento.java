/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author adrian
 */
public class Alimento {
    
    private float proteinas;
    private float grasas;
    private float hidratos;
    private String nombreAli;

    public Alimento() {
    }

    public float getProteinas() {
        return proteinas;
    }

    public void setProteinas(float proteinas) {
        this.proteinas = proteinas;
    }

    public float getGrasas() {
        return grasas;
    }

    public void setGrasas(float grasas) {
        this.grasas = grasas;
    }

    public float getHidratos() {
        return hidratos;
    }

    public void setHidratos(float hidratos) {
        this.hidratos = hidratos;
    }

    public String getNombreAli() {
        return nombreAli;
    }

    public void setNombreAli(String nombreAli) {
        this.nombreAli = nombreAli;
    }

    @Override
    public String toString() {
        return nombreAli + ", proteinas: " + proteinas + ", grasas: " + grasas + ", hidratos: " + hidratos;
    }
    
    
    
    
}
