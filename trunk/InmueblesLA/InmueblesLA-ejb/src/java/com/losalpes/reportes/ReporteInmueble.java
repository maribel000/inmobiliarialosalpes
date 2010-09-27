/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.reportes;

import com.losalpes.mundo.Inmueble;

/**
 *
 * @author andres
 */
public class ReporteInmueble {

    /**
     * Class Attributes
     */
    private String idReporte;
    private Inmueble inmueble;

    /**
     * Class Constructor
     * @param id - el identificador del reporte
     */
    public ReporteInmueble(String id) {
        idReporte = id;
        inmueble = new Inmueble();
        inmueble.setReferencia(id);
        inmueble.setNombre("Inmueble No. "+id);
        inmueble.setDescripcion("Esta es la descripcion del inmueble n&uacute;mero "+id);
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
