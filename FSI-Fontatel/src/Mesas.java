import java.sql.Connection;
import java.sql.PreparedStatement;

public class Mesas {
    static String todos = "SELECT * FROM mesas ORDER BY numero";
    static String numeros = "SELECT numero FROM mesas ORDER BY numero";
    String numero, estadom, capacidad;

    public Mesas() {}

    public Mesas(String numero, String estadom, String capacidad) {
        this.numero = numero;
        this.estadom = estadom;
        this.capacidad = capacidad;
    }

    public int insertar(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO mesas (numero, estadom, capacidad) VALUES (?, ?, ?)")) {
            ps.setString(1, numero);
            ps.setString(2, estadom);
            ps.setString(3, capacidad);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int borrar(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM mesas WHERE numero = ?")) {
            ps.setString(1, numero);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int actualizar(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("UPDATE mesas SET estadom = ?, capacidad = ? WHERE numero = ?")) {
            ps.setString(1, estadom);
            ps.setString(2, capacidad);
            ps.setString(3, numero);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
}
