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
public class Producto implements GestionReseña{

    private String codigo;
    private String nombre;
    private double precio;
    private String descripcion;
    private String tipo;
    private Emprendimiento emprendimiento;
    private ArrayList<Reseña> reseñas = new ArrayList<>();


   
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
        public void mostrarReseñasPorProducto(Producto producto) {
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        ArrayList<Reseña> reseñasDelProducto = producto.obtenerReseñas();

        if (reseñasDelProducto.isEmpty()) {
            textArea.setText("No hay reseñas para este producto.");
        } else {
            StringBuilder sb = new StringBuilder();
            double suma = 0;
            int totalReseñas = reseñasDelProducto.size();

            for (Reseña reseña : reseñasDelProducto) {
                sb.append("Fecha: ").append(reseña.getFecha())
                        .append("\nCalificación: ").append(reseña.getCalificacion())
                        .append("\nDescripción: ").append(reseña.getDescripcion())
                        .append("\n\n");
                suma += reseña.getCalificacion();
            }

            double promedio = (totalReseñas > 0) ? (suma / totalReseñas) : 0;
            sb.append("Promedio de calificaciones: ").append(promedio);

            textArea.setText(sb.toString());
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, "Reseñas del Producto", JOptionPane.INFORMATION_MESSAGE);
    }
    
      public void menuReseñasProductos(Producto producto) {
        int op = Integer.parseInt(JOptionPane.showInputDialog(
                "\n[1] Agregar reseña"
                + "\n[2] Ver reseñas"
                + "\n[3] ver informacion del producto"
                + "\n[4] Salir"
                + "\nElija una opción :"));
        switch (op) {
            case 1:
                producto.agregarReseña();
                menuReseñasProductos(producto);
                break;
            case 2:
                mostrarReseñasPorProducto(producto);
                menuReseñasProductos(producto);
                break;
            case 3:
                emprendimiento.mostrarProducto(producto);
                menuReseñasProductos(producto);
                break;
            case 4:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
                break;
        }
    }
    

    @Override
    public void agregarReseña() {
   String descripcion = JOptionPane.showInputDialog("Redacta tu reseña :");
        int calificacion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué calificación le darías? (1-5)"
                + "\n[1] Pésima"
                + "\n[2] Mala"
                + "\n[3] Puede mejorar"
                + "\n[4] Buena"
                + "\n[5] Excelente"));
        Reseña reseña = new Reseña(descripcion, calificacion);
        reseñas.add(reseña);
        JOptionPane.showMessageDialog(null, "Reseña agregada con éxito."); 
    }

    @Override
    public ArrayList<Reseña> obtenerReseñas() {
      return reseñas;
    }
    
    
}