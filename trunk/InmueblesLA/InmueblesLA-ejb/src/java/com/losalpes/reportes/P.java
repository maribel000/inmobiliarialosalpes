package com.losalpes.reportes;

import com.losalpes.entities.Inmueble;
import com.losalpes.entities.Usuario;
import com.losalpes.persistence.PersistenceServices;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public class P
{
    // -----------------
    // Constantes
    // -----------------
    public final static String rutaArchivo = "./data/informacion.txt";
    public final static int APARTAMENTO = 1;
    public final static int CASA = 2;
    private PersistenceServices ps;
    private List<Usuario> usuarios;
    private List<Inmueble> inmuebles;

    public P( )
    {
        //usuarios = new ArrayList<Usuario>( );
        //inmuebles = new ArrayList<Inmueble>( );
        //try
        //{
        //    leerReporte( );
        //}
        //catch( IOException e )
        //{
            // TODO Auto-generated catch block
        //    e.printStackTrace( );
        //}
        // llenardatos( 30 );
    }

    public P(PersistenceServices ps)
    {
        this.ps = ps;
    }

    /**
     * Opens and reads a file, and returns the contents as one String.
     */
    public void leerReporte( ) throws IOException
    {
        BufferedReader reader = new BufferedReader( new FileReader( rutaArchivo ) );

        String line = reader.readLine( );
        
        if( line.equals( "USUARIOS" ) )
        {
            line = reader.readLine( );
            ps.setIdusuario(Integer.parseInt( line ));
            usuarios = ps.getUsuarios();
            line = reader.readLine( );
            while( line != null )
            {
                Usuario temp = new Usuario( );
                temp.setApellido( line );
                line = reader.readLine( );
                temp.setCc( line );
                line = reader.readLine( );
                temp.setEmail( line );
                line = reader.readLine( );
                temp.setIdusuario( Integer.parseInt( line ) );
                line = reader.readLine( );
                temp.setLogIn( line );
                line = reader.readLine( );
                temp.setNombre( line );
                line = reader.readLine( );
                temp.setPassword( line );
                line = reader.readLine( );
                temp.setTipoUsuario( line );
                line = reader.readLine( );
                usuarios.add( temp );
                if( line.equals( "-" ) )
                {
                    break;
                }
            }
        }
        ps.setUsuarios(usuarios);

        line = reader.readLine( );
        
        if( line.equals( "INMUEBLES" ) )
        {
            line = reader.readLine( );
            ps.setIdinmueble( Integer.parseInt( line ) );
            inmuebles = ps.getInmuebles();
            line = reader.readLine( );
            while( line != null )
            {
                Inmueble temp = new Inmueble( );
                temp.setDescripcion( line );
                line = reader.readLine( );
                temp.setIdInmueble( Integer.parseInt( line ) );
                line = reader.readLine( );
                temp.setIdcomprador( Integer.parseInt( line ) );
                line = reader.readLine( );
                temp.setIddueno( buscarDueno( line ) );
                line = reader.readLine( );
                temp.setIdvendedor( Integer.parseInt( line ) );
                line = reader.readLine( );
                temp.setNombre( line );
                line = reader.readLine( );
                temp.setTipo( Integer.parseInt( line ) );
                line = reader.readLine( );
                inmuebles.add( temp );
                if( line.equals( "-" ) )
                {
                    break;
                }
            }
        }
        ps.setInmuebles(inmuebles);

        reader.close( );
    }

    private Usuario buscarDueno( String line )
    {
        Usuario buscar = null;
        for( int i = 0; i < usuarios.size( ) && buscar == null; i++ )
        {
            Usuario temp = usuarios.get( i );
            if( temp.getIdusuario( ) == Integer.parseInt( line ) )
            {
                buscar = temp;
            }
        }
        return buscar;
    }

    /**
     * Es el método que va escribir el archivo con el reporte que se necesita.
     *
     * @param rutaArchivo El ruta del archivo en el que se va escribir.
     * @param nombreArchivo El nombre del archivo que va generar.
     * @throws FileNotFoundException En caso que no se pueda escribir el archivo.
     */
    public void generarReporte( ) throws FileNotFoundException
    {
        // COMPLETAR
        try
        {
            PrintWriter escritor = new PrintWriter( new File( rutaArchivo ) );

            escritor.println( "USUARIOS" );
            escritor.println( ps.getId_usuario() );
            for( int i = 0; i < usuarios.size( ); i++ )
            {
                Usuario temp = usuarios.get( i );
                escritor.println( temp.getApellido( ) );
                escritor.println( temp.getCc( ) );
                escritor.println( temp.getEmail( ) );
                escritor.println( temp.getIdusuario( ) );
                escritor.println( temp.getLogIn( ) );
                escritor.println( temp.getNombre( ) );
                escritor.println( temp.getPassword( ) );
                escritor.println( temp.getTipoUsuario( ) );
            }
            escritor.println( "-" );

            escritor.println( "INMUEBLES" );
            escritor.println( ps.getId_inmueble() );
            for( int i = 0; i < inmuebles.size( ); i++ )
            {
                Inmueble temp = inmuebles.get( i );
                escritor.println( temp.getDescripcion( ) );
                escritor.println( temp.getIdInmueble( ) );
                escritor.println( temp.getIdcomprador( ) );
                escritor.println( temp.getIddueno( ).getIdusuario( ) );
                escritor.println( temp.getIdvendedor( ) );
                escritor.println( temp.getNombre( ) );
                escritor.println( temp.getTipo( ) );
            }
            escritor.println( "-" );

            escritor.close( );
        }
        catch( FileNotFoundException f )
        {
            throw new FileNotFoundException( " No se encontro el archio" );
        }
    }

    /*
    public void llenardatos( int a )
    {
        for( int i = 0; i < a; i++ )
        {
            Usuario usuario = new Usuario( );
            usuario.setApellido( "usuario apellido" + i );
            usuario.setCc( i + "" );
            usuario.setCorreoElectronico( "usuario correoElectronico@" + i );
            usuario.setDocumentoIdentificacion( i + "" );
            usuario.setEmail( "usuario email@" + i );
            usuario.setIdusuario( i );
            usuario.setLogIn( "logIn" + i );
            usuario.setNombre( "usuario nombre" + i );
            usuario.setPassword( "asdf" );
            if( i == 0 )
            {
                usuario.setTipoUsuario( "Administrador" );
            }
            else if( i % 2 == 0 )
            {
                usuario.setTipoUsuario( "Vendedor" );
            }
            else
            {
                usuario.setTipoUsuario( "Cliente" );
            }

            usuarios.add( usuario );

            Inmueble inmueble = new Inmueble( );
            inmueble.setDescripcion( "inmuebleDescripcion" + i );
            inmueble.setIdInmueble( i );
            inmueble.setIddueno( usuario );
            inmueble.setIdvendedor( i );
            inmueble.setNombre( "inmuebleNombre" );
            if( i % 2 == 0 )
            {
                inmueble.setTipo( APARTAMENTO );
            }
            else
            {
                inmueble.setTipo( CASA );
            }
            inmueble.setIdInmueble( i );

            inmuebles.add( inmueble );

            id_inmueble = i;
            id_usuario = i;
        }
        id_inmueble++;
        id_usuario++;
    }*/

    // ---------
    // Main
    // ---------

    public static void main( String[] args )
    {
        P p = new P( );
        // try
        // {
        // p.generarReporte( );
        // p.leerReporte( );
        // }
        // catch( FileNotFoundException e )
        // {
        // e.printStackTrace( );
        // }
        // catch( IOException e )
        // {
        // e.printStackTrace( );
        // }
    }
}