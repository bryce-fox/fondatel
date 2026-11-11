
import java.io.Serializable;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class Pelicula implements Serializable{
    private String clave,titulo;
    private ImageIcon cartel;
    public Pelicula(String clave, String titulo, ImageIcon cartel){
        this.clave = clave;
        this.titulo = titulo;
        this.cartel = cartel;
        
        
    }
    public int insertar(Conexion cnx){
 try{       
 String sql = "INSERT INTO peliculas VALUES(?,?,?)";
     PreparedStatement ps = cnx.con.prepareStatement(sql);
     ps.setString(1,clave);
     ps.setString(2,titulo);
     ps.setBinaryStream(3, cnx.ImagenBytes(cartel));
     return ps.executeUpdate();
 }catch (Exception e){
     System.out.print("error al insertar:"+e.getMessage());
     return 0;
 }
            
    }
}