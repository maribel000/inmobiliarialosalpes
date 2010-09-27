/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.reportes;

import com.losalpes.mundo.Inmobiliaria;
import java.util.ArrayList;

/**
 *  Esta clase implementa in cache de reportes de inmuebles. Esto lo hace por
 *  medio de un arreglo. Si el reporte ya esta en el arreglo, lo devuelve. De 
 *  lo contrario, lo genera, lo guarda y lo devuelve. El arreglo tiene un 
 *  tamano maximos (max) de 10.
 *
 * @author andres
 */
public class CacheReporteInmueble {
    /**
     * Class Attributes
     */
    final private static int max=10;
    private static ArrayList<ReporteInmueble> items;
    public static Inmobiliaria inmob;




    //Class Methods

    /**
     * Este metodo es el que devuelve el reporte, este o no dentro del cache.
     * @param id - identificador del reporte
     * @return el reporte [ReporteInmueble]
     */
    public static ReporteInmueble getReporte(String id) {
        if(inmob==null)
            inmob=new Inmobiliaria();
        if (items == null)
            items = new ArrayList();

        //Este ciclo busca el reporte dentro del cache
        for(int i=0;i<items.size();i++) {
            if(items.get(i).getIdReporte().equals(id))
                return items.get(i);
        }

        //si el cache esta lleno, vaciarlo
        if(items.size()+1==max)
            items.removeAll(items);

        //como el reporte no estaba en el cache, generarlo y agregarlo al cache
        ReporteInmueble rep = new ReporteInmueble(id);
        items.add(rep);

        //retornar el nuevo reporte
        return rep;
    }
}
