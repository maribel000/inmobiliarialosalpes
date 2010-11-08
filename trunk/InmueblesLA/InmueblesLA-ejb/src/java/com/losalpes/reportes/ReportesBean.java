/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.reportes;

import com.losalpes.entities.Inmueble;
import java.util.ArrayList;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *  Esta bean es aquel que genera los reportes, por medio de un cache
 * @author andres
 */
@Stateless
@DeclareRoles ({"administrador"})
public class ReportesBean implements Reportes {
    
    /**
     * Class Methods
     */

    /**
     * Este metodo consulta el cache para devolver el reporte pedido
     * @param id - identificador del reporte
     * @return codigo HTML del reporte
     */
    @RolesAllowed ({"administrador"})
    public Inmueble generarReporteInmueble(String id) {

        ReporteInmueble rep = CacheReporteInmueble.getReporte(id);

        return rep.getInmueble();
    }
    @RolesAllowed ({"administrador"})
    public ArrayList generarReporteParametro(String parametro){
        ArrayList inmuebles = new ArrayList();
        return inmuebles;
    }
}
