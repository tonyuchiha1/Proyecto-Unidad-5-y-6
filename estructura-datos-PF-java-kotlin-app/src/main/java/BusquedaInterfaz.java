import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BusquedaInterfaz {
    private JPanel Panelprincipal;
    private JTable tabla;
    private JTextField valorABuscarCampoTexto;
    private JButton buscarConKotlinButton;
    private JButton busquedaLinealButton;
    private JButton busquedaBinariaButton;
    private JLabel ResultadosPosicion;

    public static Object[] columnas = {"NOMBRE DEL CLIENTE", "NUMERO DE COMPRAS", "CATEGORIA", "SALDO A DEBER"};

    public static Object[][] datos = {
            {"ANDRES JAHIR", 20, 'A', 2000.50},
            {"ARAGON ELIANETH", 20, 'A', 2000.50},
            {"IRIS SAMAHI", 30, 'S', 200.00},
            {"KEVIN JAVIER", 10, 'B', 10000.20},
            {"KEVIN MOLINA", 20, 'A', 2000.50},
            {"PATRICIA EUGENIO", 20, 'A', 2000.50}
    };

    public BusquedaInterfaz() {

        buscarConKotlinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarKotlin();
            }

        });
        busquedaLinealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Buscarlineal();
            }
        });
        busquedaBinariaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            BuscarBinarian();
            }
        });
    }
    public void BuscarKotlin() {

        List<String> nombres = new ArrayList<String>();


        for (int i = 0; i < tabla.getRowCount(); i++) {

            nombres.add(tabla.getValueAt(i, 0).toString());

        }

        String valorAbuscar=valorABuscarCampoTexto.getText();
       MetododeBUsquedaKt.busquedaporkotlin(nombres,valorAbuscar);
       }
    public void Buscarlineal(){
        List<String> nombres = new ArrayList<String>();

        for (int i = 0; i < tabla.getRowCount(); i++) {
            nombres.add(tabla.getValueAt(i, 0).toString());
        }

        String valorABuscar = valorABuscarCampoTexto.getText();
//La variable posicion la obtenemos porque el metodo busqueda lineal retnorna un valor de tipo entero
        int posicion=MetododeBUsquedaKt.busquedaLineal(nombres,valorABuscar);
        ResultadosPosicion.setText(String.valueOf(posicion));
    }

    public void BuscarBinarian(){
        List<String> nombres = new ArrayList<String>();

        for (int i = 0; i < tabla.getRowCount(); i++) {
            nombres.add(tabla.getValueAt(i, 0).toString());
        }

        String valorABuscar = valorABuscarCampoTexto.getText();
        int posicion=MetododeBUsquedaKt.busquedaporbinaria(nombres,valorABuscar);
        ResultadosPosicion.setText(String.valueOf(posicion));
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("VENTANA");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setContentPane(new BusquedaInterfaz().Panelprincipal);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setSize(900, 600);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    private void createUIComponents() {
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tabla = new JTable(modelo);
    }
}
