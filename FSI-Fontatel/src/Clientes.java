import java.sql.Connection;
import java.sql.PreparedStatement;

public class Clientes {
    static String todos = "SELECT * FROM clientes ORDER BY nombrec";
    static String codigos = "SELECT codigoc FROM clientes ORDER BY codigoc";
    String codigoc, nombrec, rfc;

    public Clientes() {}

    public Clientes(String codigoc, String nombrec, String rfc) {
        this.codigoc = codigoc;
        this.nombrec = nombrec;
        this.rfc = rfc;
    }

    public int insertar(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO clientes (codigoc, nombrec, rfc) VALUES (?, ?, ?)")) {
            ps.setString(1, codigoc);
            ps.setString(2, nombrec);
            ps.setString(3, rfc);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int borrar(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM clientes WHERE codigoc = ?")) {
            ps.setString(1, codigoc);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int actualizar(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("UPDATE clientes SET nombrec = ?, rfc = ? WHERE codigoc = ?")) {
            ps.setString(1, nombrec);
            ps.setString(2, rfc);
            ps.setString(3, codigoc);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
}
