/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author POWER
 */
public class Producto implements GestionRese�a{

    private String codigo;
    private String nombre;
    private double precio;
    private String descripcion;
    private String tipo;
    private Emprendimiento emprendimiento;
    private ArrayList<Rese�a> rese�as = new ArrayList<>();


   
    public Producto() {
    }

    public Producto(String codigo, String nombre, double precio, String descripcion, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Producto(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
        public void mostrarRese�asPorProducto(Producto producto) {
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        ArrayList<Rese�a> rese�asDelProducto = producto.obtenerRese�as();

        if (rese�asDelProducto.isEmpty()) {
            textArea.setText("No hay rese�as para este producto.");
        } else {
            StringBuilder sb = new StringBuilder();
            double suma = 0;
            int totalRese�as = rese�asDelProducto.size();

            for (Rese�a rese�a : rese�asDelProducto) {
                sb.append("Fecha: ").append(rese�a.getFecha())
                        .append("\nCalificaci�n: ").append(rese�a.getCalificacion())
                        .append("\nDescripci�n: ").append(rese�a.getDescripcion())
                        .append("\n\n");
                suma += rese�a.getCalificacion();
            }

            double promedio = (totalRese�as > 0) ? (suma / totalRese�as) : 0;
            sb.append("Promedio de calificaciones: ").append(promedio);

            textArea.setText(sb.toString());
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, "Rese�as del Producto", JOptionPane.INFORMATION_MESSAGE);
    }
    
      public void menuRese�asProductos(Producto producto) {
        int op = Integer.parseInt(JOptionPane.showInputDialog(
                "\n[1] Agregar rese�a"
                + "\n[2] Ver rese�as"
                + "\n[3] ver informacion del producto"
                + "\n[4] Salir"
                + "\nElija una opci�n :"));
        switch (op) {
            case 1:
                producto.agregarRese�a();
                menuRese�asProductos(producto);
                break;
            case 2:
                mostrarRese�asPorProducto(producto);
                menuRese�asProductos(producto);
                break;
            case 3:
                emprendimiento.mostrarProducto(producto);
                menuRese�asProductos(producto);
                break;
            case 4:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opci�n no v�lida");
                break;
        }
    }
    

    @Override
    public void agregarRese�a() {
   String descripcion = JOptionPane.showInputDialog("Redacta tu rese�a :");
        int calificacion = Integer.parseInt(JOptionPane.showInputDialog("�Qu� calificaci�n le dar�as? (1-5)"
                + "\n[1] P�sima"
                + "\n[2] Mala"
                + "\n[3] Puede mejorar"
                + "\n[4] Buena"
                + "\n[5] Excelente"));
        Rese�a rese�a = new Rese�a(descripcion, calificacion);
        rese�as.add(rese�a);
        JOptionPane.showMessageDialog(null, "Rese�a agregada con �xito."); 
    }

    @Override
    public ArrayList<Rese�a> obtenerRese�as() {
      return rese�as;
    }
    
    
}