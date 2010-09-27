/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.reportes;

import com.losalpes.mundo.IInmobiliaria;
import com.losalpes.mundo.Inmueble;

/**
 * Esta clase es el modelo de la informacion presente en el informe
 * @author andres
 */
public class ReporteInmueble {

    /**
     * Class Attributes
     */
    private String idReporte;
    private Inmueble inmueble;
    private IInmobiliaria inmobiliaria;

    /**
     * Class Constructor
     * @param id - el identificador del reporte
     */
    public ReporteInmueble(String id) {
        inmobiliaria=CacheReporteInmueble.inmob;
        idReporte = id;
        Inmueble buscado = (Inmueble) inmobiliaria.buscarInmuebleReferencia(id);
        System.out.println(buscado.getReferencia());
        inmueble.setReferencia(id);
        inmueble.setNombre(buscado.getNombre());
        inmueble.setDescripcion(buscado.getDescripcion());
        inmueble.setMaterial("Material"+id);
        inmueble.setColor("Color"+id);
    }

    //Class Methods

    public String getIdReporte() {
        return idReporte;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }
}
