/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xmlrecetas;

import java.util.ArrayList;
import modelo.Alimento;
import modelo.Ingrediente;
import modelo.Receta;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author adrian
 */
public class RecetasHandlerXML extends DefaultHandler {

    private StringBuilder cadena;
    private Receta receta;
    private Ingrediente ingrediente;
    private Alimento alimento;
    private ArrayList<Receta> recetas;

    public ArrayList<Receta> getRecetas() {
        return recetas;
    }

    @Override
    public void startDocument() throws SAXException {
        cadena = new StringBuilder();
        recetas = new ArrayList<Receta>();
        System.out.println("Inicio de una receta");
    }

    @Override
    public void startElement(String uri, String nombreLocal, String nombreCualif, Attributes atrbts) throws SAXException {
        cadena.setLength(0);
        if (nombreCualif.equals("receta")) {
            receta = new Receta();
            receta.setNombre(atrbts.getValue("nombre"));
        } else if (nombreCualif.equals("ingrediente")) {
            ingrediente = new Ingrediente();
            alimento = new Alimento();
            alimento.setNombreAli(atrbts.getValue("nombre"));
        } else if (nombreCualif.equals("proteinas")) {
            alimento.setProteinas(Float.parseFloat(atrbts.getValue("cantidad100g")));
        } else if (nombreCualif.equals("grasas")) {
            alimento.setGrasas(Float.parseFloat(atrbts.getValue("cantidad100g")));
        } else if (nombreCualif.equals("hidratos")) {
            alimento.setHidratos(Float.parseFloat(atrbts.getValue("cantidad100g")));
        }
    }

    @Override
    public void characters(char[] chars, int inicio, int lon) throws SAXException {
        cadena.append(chars, inicio, lon);
    }

    @Override
    public void endElement(String uri, String nombreLocal, String nombreCualif) throws SAXException {
        if (nombreCualif.equals("receta")) {
            recetas.add(receta);
        } else if (nombreCualif.equals("cantidad")) {
            ingrediente.setCantidad(Integer.parseInt(cadena.toString().trim()));
        } else if (nombreCualif.equals("alimento")) {
            ingrediente.setAlimento(alimento);
        } else if (nombreCualif.equals("ingrediente")) {
            receta.getIngredientes().add(ingrediente);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Final de la receta");
    }
}
