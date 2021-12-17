import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OrdenamientoInterfaz {
    private JPanel panelprincipal;
    private JTable tabla;
    private JButton burbujaButton;
    private JButton mergeSortButton;
    private JButton quickSortButton;
    private JLabel resultado;

    public static Object[] columnas = {"NOMBRE DEL CLIENTE", "NUMERO DE COMPRAS", "CATEGORIA", "SALDO A DEBER"};

    public static Object[][] datos = {
            {"PATRICIA EUGENIO ", 20, 'A', 2000.50},
            {"KEVIN MOLINA", 20, 'A', 2000.50},
            {"ARAGON ELIANETH", 20, 'A', 2000.50},
            {"KEVIN JAVIER", 10, 'B', 10000.20},
            {"IRIS SAMAHI", 30, 'S', 200.00},
            {"ANDRES JAHIR ", 20, 'A', 2000.50},
    };

    public OrdenamientoInterfaz() {

        quickSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ordenarQuickSort();

                //MainKotlinKt.imprimirlistas(nombres);
             //   System.out.println(tabla.getValueAt(2,0));
            }
        });
        burbujaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              ordenarBurbuja();
            }
        });
        mergeSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ordenarMergeSort();
            }
        });
    }
    public void ordenarQuickSort() {

        List<String> nombres = new ArrayList<String>();


        for (int i = 0; i < tabla.getRowCount(); i++) {

            nombres.add(tabla.getValueAt(i, 0).toString());

        }
        MetodosOrdenamientoKt.tiempoQuickSort(nombres);

    }
    public void ordenarMergeSort() {

        List<String> nombres = new ArrayList<String>();


        for (int i = 0; i < tabla.getRowCount(); i++) {

            nombres.add(tabla.getValueAt(i, 0).toString());

        }

        MetodosOrdenamientoKt.tiempoMergeSort(nombres);
    }
    public void ordenarBurbuja() {

        ArrayList<String> nombres = new ArrayList<String>();


        for (int i = 0; i < tabla.getRowCount(); i++) {

            nombres.add(tabla.getValueAt(i, 0).toString());

        }

        MetodosOrdenamientoKt.tiempoBurbujaSort(nombres);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VENTANA");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setContentPane(new OrdenamientoInterfaz().panelprincipal);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setSize(512, 512);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    private void createUIComponents() {
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tabla = new JTable(modelo);
    }
}
