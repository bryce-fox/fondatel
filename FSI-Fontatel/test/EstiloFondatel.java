import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/** Estilos sencillos que comparten las ventanas de FondaTel. */
public class EstiloFondatel {

    public static final Color VERDE = new Color(39, 83, 67);
    public static final Color CREMA = new Color(247, 245, 237);
    public static final Color SALVIA = new Color(231, 238, 230);
    public static final Color TERRACOTA = new Color(188, 100, 69);
    public static final Color TEXTO = new Color(45, 55, 49);

    public static JPanel crearEncabezado(String titulo, String descripcion) {
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBackground(VERDE);
        encabezado.setBorder(new EmptyBorder(16, 22, 16, 22));

        JPanel textos = new JPanel(new java.awt.GridLayout(0, 1, 0, 4));
        textos.setOpaque(false);

        JLabel nombre = new JLabel(titulo);
        nombre.setForeground(Color.WHITE);
        nombre.setFont(new Font("Segoe UI", Font.BOLD, 23));

        JLabel detalle = new JLabel(descripcion);
        detalle.setForeground(new Color(222, 232, 220));
        detalle.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        textos.add(nombre);
        textos.add(detalle);
        encabezado.add(textos, BorderLayout.CENTER);
        return encabezado;
    }

    public static void organizarTabla(JFrame ventana, String titulo,
            String descripcion, JTable tabla, JScrollPane desplazamiento,
            JComponent controles, JButton boton) {
        ventana.setTitle("FondaTel | " + titulo);
        aplicarTabla(tabla);
        desplazamiento.setBorder(BorderFactory.createLineBorder(new Color(211, 220, 211)));
        desplazamiento.getViewport().setBackground(Color.WHITE);

        JPanel principal = new JPanel(new BorderLayout(0, 16));
        principal.setBackground(CREMA);
        principal.setBorder(new EmptyBorder(18, 20, 18, 20));
        principal.add(crearEncabezado(titulo, descripcion), BorderLayout.NORTH);

        JPanel contenido = new JPanel(new BorderLayout(0, 12));
        contenido.setOpaque(false);
        if (controles != null) {
            if (controles instanceof JToolBar) {
                JToolBar barra = (JToolBar) controles;
                barra.setFloatable(false);
                barra.setBackground(Color.WHITE);
                for (Component componente : barra.getComponents()) {
                    if (componente instanceof JButton) {
                        aplicarBoton((JButton) componente);
                    } else if (componente instanceof JComboBox) {
                        componente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    }
                }
            }
            contenido.add(controles, BorderLayout.NORTH);
        }
        contenido.add(desplazamiento, BorderLayout.CENTER);
        principal.add(contenido, BorderLayout.CENTER);

        if (boton != null) {
            aplicarBoton(boton);
            JPanel pie = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
            pie.setOpaque(false);
            pie.add(boton);
            principal.add(pie, BorderLayout.SOUTH);
        }

        ventana.setContentPane(principal);
        ventana.setMinimumSize(new Dimension(900, 580));
        ventana.setSize(1180, 700);
        ventana.setLocationRelativeTo(null);
    }

    public static void aplicarTabla(JTable tabla) {
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabla.setForeground(TEXTO);
        tabla.setBackground(Color.WHITE);
        tabla.setSelectionBackground(new Color(205, 222, 204));
        tabla.setSelectionForeground(TEXTO);
        tabla.setRowHeight(Math.max(tabla.getRowHeight(), 28));
        tabla.setFillsViewportHeight(true);
        tabla.setShowVerticalLines(false);
        tabla.setGridColor(new Color(232, 235, 230));
        tabla.setIntercellSpacing(new Dimension(0, 1));

        JTableHeader cabecera = tabla.getTableHeader();
        cabecera.setOpaque(true);
        cabecera.setBackground(VERDE);
        cabecera.setForeground(Color.WHITE);
        cabecera.setFont(new Font("Segoe UI", Font.BOLD, 13));
        cabecera.setPreferredSize(new Dimension(cabecera.getPreferredSize().width, 36));
        cabecera.setReorderingAllowed(false);

        DefaultTableCellRenderer celdas = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tabla, Object valor,
                    boolean seleccionado, boolean tieneFoco, int fila, int columna) {
                Component celda = super.getTableCellRendererComponent(
                        tabla, valor, seleccionado, tieneFoco, fila, columna);
                if (!seleccionado) {
                    celda.setBackground(fila % 2 == 0 ? Color.WHITE : SALVIA);
                }
                setBorder(new EmptyBorder(5, 8, 5, 8));
                return celda;
            }
        };
        tabla.setDefaultRenderer(Object.class, celdas);
        tabla.setDefaultRenderer(Number.class, celdas);
    }

    public static void aplicarBoton(JButton boton) {
        boton.setBackground(VERDE);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setBorder(new EmptyBorder(10, 18, 10, 18));
    }

    public static void aplicarBotonSecundario(JButton boton) {
        boton.setBackground(TERRACOTA);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton.setBorder(new EmptyBorder(10, 18, 10, 18));
    }

    public static void aplicarCampo(JComponent campo) {
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setBackground(Color.WHITE);
        campo.setForeground(TEXTO);
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(202, 214, 203)),
                new EmptyBorder(6, 8, 6, 8)));
    }
}
