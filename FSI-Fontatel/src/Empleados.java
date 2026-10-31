import java.sql.Connection;
import java.sql.PreparedStatement;

public class Empleados {
    static String todos = "SELECT * FROM empleados ORDER BY nombree";
    static String codigos = "SELECT codigo FROM empleados ORDER BY codigo";
    String codigo, nombree, puesto, turno, estadoe;

    public Empleados() {}

    public Empleados(String codigo, String nombree, String puesto, String turno, String estadoe) {
        this.codigo = codigo;
        this.nombree = nombree;
        this.puesto = puesto;
        this.turno = turno;
        this.estadoe = estadoe;
    }

    public int insertar(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO empleados (codigo, nombree, puesto, turno, estadoe) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, codigo);
            ps.setString(2, nombree);
            ps.setString(3, puesto);
            ps.setString(4, turno);
            ps.setString(5, estadoe);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int borrar(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM empleados WHERE codigo = ?")) {
            ps.setString(1, codigo);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int actualizar(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("UPDATE empleados SET nombree = ?, puesto = ?, turno = ?, estadoe = ? WHERE codigo = ?")) {
            ps.setString(1, nombree);
            ps.setString(2, puesto);
            ps.setString(3, turno);
            ps.setString(4, estadoe);
            ps.setString(5, codigo);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
}
