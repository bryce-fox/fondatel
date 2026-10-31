import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ordenes {
    static String todos = "SELECT * FROM ordenes ORDER BY folio";
    static String folios = "SELECT folio FROM ordenes ORDER BY folio";
    String folio, fecha_hora, observaciones, estadoo, silla;
    String clientes_codigoc, mesas_numero, alimentos_idalimentos;
    String empleados_codigo_mesero, empleados_codigo_cocinero;

    public Ordenes() {}

    public Ordenes(String folio, String fecha_hora, String observaciones, String estadoo, String silla,
                   String clientes_codigoc, String mesas_numero, String alimentos_idalimentos,
                   String empleados_codigo_mesero, String empleados_codigo_cocinero) {
        this.folio = folio;
        this.fecha_hora = fecha_hora;
        this.observaciones = observaciones;
        this.estadoo = estadoo;
        this.silla = silla;
        this.clientes_codigoc = clientes_codigoc;
        this.mesas_numero = mesas_numero;
        this.alimentos_idalimentos = alimentos_idalimentos;
        this.empleados_codigo_mesero = empleados_codigo_mesero;
        this.empleados_codigo_cocinero = empleados_codigo_cocinero;
    }

    public int insertar(Connection con) {
        String sql = "INSERT INTO ordenes (folio, fecha_hora, observaciones, estadoo, silla, clientes_codigoc, mesas_numero, alimentos_idalimentos, empleados_codigo_mesero, empleados_codigo_cocinero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, folio);
            ps.setString(2, fecha_hora);
            ps.setString(3, observaciones);
            ps.setString(4, estadoo);
            ps.setString(5, silla);
            ps.setString(6, clientes_codigoc);
            ps.setString(7, mesas_numero);
            ps.setString(8, alimentos_idalimentos);
            ps.setString(9, empleados_codigo_mesero);
            ps.setString(10, empleados_codigo_cocinero);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int borrar(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM ordenes WHERE folio = ?")) {
            ps.setString(1, folio);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int actualizar(Connection con) {
        String sql = "UPDATE ordenes SET fecha_hora = ?, observaciones = ?, estadoo = ?, silla = ?, clientes_codigoc = ?, mesas_numero = ?, alimentos_idalimentos = ?, empleados_codigo_mesero = ?, empleados_codigo_cocinero = ? WHERE folio = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, fecha_hora);
            ps.setString(2, observaciones);
            ps.setString(3, estadoo);
            ps.setString(4, silla);
            ps.setString(5, clientes_codigoc);
            ps.setString(6, mesas_numero);
            ps.setString(7, alimentos_idalimentos);
            ps.setString(8, empleados_codigo_mesero);
            ps.setString(9, empleados_codigo_cocinero);
            ps.setString(10, folio);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
}
