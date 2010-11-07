/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.reportes;

import com.losalpes.entities.Inmueble;
import com.losalpes.services.IInmobiliaria;

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
        inmueble = new Inmueble();
        idReporte = id;
        Inmueble buscado = inmobiliaria.buscarInmuebleReferencia(id);
        if(buscado != null) {
            System.out.println(buscado.getidInmueble());
            System.out.println(buscado.getNombre());
            System.out.println(buscado.getDescripcion());
            inmueble.setidInmueble(buscado.getidInmueble());
            inmueble.setNombre(buscado.getNombre());
            inmueble.setDescripcion(buscado.getDescripcion());
        }
    }

    //Class Methods

    public String getIdReporte() {
        return idReporte;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }
}
