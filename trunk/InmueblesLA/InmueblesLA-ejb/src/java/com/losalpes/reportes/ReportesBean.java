/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.reportes;

import javax.ejb.Stateless;

/**
 *  Esta bean es aquel que genera los reportes, por medio de un cache
 * @author andres
 */
@Stateless
public class ReportesBean implements Reportes {
    
    /**
     * Class Methods
     */

    /**
     * Este metodo consulta el cache para devolver el reporte pedido
     * @param id - identificador del reporte
     * @return codigo HTML del reporte
     */
    public String generarReporteInmueble(String id) {

        ReporteInmueble rep = CacheReporteInmueble.getReporte(id);

        return rep.getReporte();
    }
}
