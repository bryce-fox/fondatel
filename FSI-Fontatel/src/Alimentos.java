import java.sql.Connection;
import java.sql.PreparedStatement;

public class Alimentos {
    static String todos = "SELECT * FROM alimentos ORDER BY nombre";
    static String ids = "SELECT idalimentos FROM alimentos ORDER BY idalimentos";
    String idalimentos, nombre, descripcion, precio, categoria, estado;
    byte[] foto;

    public Alimentos() {}

    public Alimentos(String idalimentos, String nombre, String descripcion, String precio,
                     byte[] foto, String categoria, String estado) {
        this.idalimentos = idalimentos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.categoria = categoria;
        this.estado = estado;
    }

    public int insertar(Connection con) {
        String sql = "INSERT INTO alimentos (idalimentos, nombre, descripcion, precio, foto, categoria, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, idalimentos);
            ps.setString(2, nombre);
            ps.setString(3, descripcion);
            ps.setString(4, precio);
            ps.setBytes(5, foto);
            ps.setString(6, categoria);
            ps.setString(7, estado);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int borrar(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM alimentos WHERE idalimentos = ?")) {
            ps.setString(1, idalimentos);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int actualizar(Connection con) {
        String sql = "UPDATE alimentos SET nombre = ?, descripcion = ?, precio = ?, foto = ?, categoria = ?, estado = ? WHERE idalimentos = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setString(3, precio);
            ps.setBytes(4, foto);
            ps.setString(5, categoria);
            ps.setString(6, estado);
            ps.setString(7, idalimentos);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
}
