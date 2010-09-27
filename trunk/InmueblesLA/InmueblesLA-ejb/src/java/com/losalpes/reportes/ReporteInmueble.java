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
        inmueble = new Inmueble(id, "Inmueble No. "+id, "Esta es la descripcion del inmueble n&uacute;mero "+id);
    }

    //Class Methods

    /**
     * Este metodo genera el reporte
     * @return el codigo HTML del reporte
     */
    public String getReporte() {
        String res = new String();

        res = res + "Este es el reporte:<BR>";
        res = res + "Inmueble: " + inmueble.getReferencia() + "<BR>";
        res = res + "Nombre: " + inmueble.getNombre() + "<BR>";
        res = res + "Descripcion: " + inmueble.getDescripcion() + "<BR>";

        return res;
    }

    public String getIdReporte() {
        return idReporte;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }
}
