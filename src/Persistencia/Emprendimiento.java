/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Presentacion.Menu;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author POWER

*/
public class Emprendimiento implements GestionReseña {

    private String nombreEmprendimiento;
    private String nit;
    private String direccion;
    private ArrayList<Reseña> reseñas = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();

    public Emprendimiento() {
    }

    public Emprendimiento(String nombreEmprendimiento, String nit, String direccion) {
        this.nombreEmprendimiento = nombreEmprendimiento;
        this.nit = nit;
        this.direccion = direccion;
    }

    public Emprendimiento(String nombreEmprendimiento) {
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    public String getNombreEmprendimiento() {
        return nombreEmprendimiento;
    }

    public void setNombreEmprendimiento(String nombreEmprendimiento) {
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    public void buscarProductos() {
        Menu menu = new Menu();
        String codigo = JOptionPane.showInputDialog("Ingrese el código del producto");
        Producto productoEncontrado = null;

        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                productoEncontrado = producto;
                break;
            }
        }

        if (productoEncontrado != null) {
            JOptionPane.showMessageDialog(null, "Producto encontrado con éxito "
                    + "\nCódigo del Producto : " + codigo + ": \n");
            mostrarProducto(productoEncontrado);
            menu.menuReseñasProductos(productoEncontrado);

        } else {
            JOptionPane.showMessageDialog(null, "Producto " + codigo + " no encontrado.");
        }
    }

       public void mostrarProducto(Producto producto) {
        JTextArea salida = new JTextArea();
        salida.setText("INFORMACION DEL PRODUCTO\n");
        salida.append("Codigo      : " + producto.getCodigo()
                + "\nTipo        : " + producto.getTipo()
                + "\nNombre      : " + producto.getNombre()
                + "\nPrecio      : " + producto.getPrecio()
                + "\nDescripcion : " + producto.getDescripcion());
        salida.append("\n\n");
        JOptionPane.showMessageDialog(null, salida);
    }
    
    public void agregarProducto(Producto producto) {
        int opcion;
        do {
            int tipoProducto = Integer.parseInt(JOptionPane.showInputDialog("\nAGREGAR PRODUCTO"
                    + "\n¿Que tipo de producto quiere agregar?"
                    + "\n[1] Servicio"
                    + "\n[2] Producto"));
            switch (tipoProducto) {
                case 1:
                    String tipo = "Servicio";
                    String codigo = JOptionPane.showInputDialog("Codigo :");
                    String nombre = JOptionPane.showInputDialog("Nombre :");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio :"));
                    String descripcion = JOptionPane.showInputDialog("Descripcion del producto :");
                    Producto servicio = new Servicio(codigo, nombre, precio, descripcion, tipo);
                    productos.add(servicio);
                    break;
                case 2:
                    tipo = "Producto";
                    codigo = JOptionPane.showInputDialog("Codigo :");
                    nombre = JOptionPane.showInputDialog("Nombre :");
                    precio = Double.parseDouble(JOptionPane.showInputDialog("Precio :"));
                    descripcion = JOptionPane.showInputDialog("Descripcion del producto :");
                    Producto producto1 = new Producto(codigo, nombre, precio, descripcion, tipo);
                    productos.add(producto1);
                    break;
                default: {
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
                }
            }

            opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otro producto?", "Confirmacion", JOptionPane.YES_NO_OPTION);
        } while (opcion == JOptionPane.YES_NO_OPTION);
    }

    public void eliminarProducto() {
        String codieli = JOptionPane.showInputDialog("Ingrese el codigo del producto a eliminar : ");
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codieli)) {
                productos.remove(i);
            }
        }
        JOptionPane.showMessageDialog(null, "Producto eliminado con éxito.");
    }

    public ArrayList<Producto> getProductos() {
        return productos;
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

