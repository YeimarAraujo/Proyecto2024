/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author POWER
 */
public class Emprendimiento implements GestionRese�a {

    private String nombreEmprendimiento;
    private String nit;
    private String direccion;
    private ArrayList<Rese�a> rese�as = new ArrayList<>();
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
        
    public void agregarProducto(Producto producto) {
        int opcion;
        do {
            int tipoProducto = Integer.parseInt(JOptionPane.showInputDialog("\nAGREGAR PRODUCTO"
                    + "\n�Que tipo de producto quiere agregar?"
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

            opcion = JOptionPane.showConfirmDialog(null, "�Desea ingresar otro producto?", "Confirmacion", JOptionPane.YES_NO_OPTION);
        } while (opcion == JOptionPane.YES_NO_OPTION);
    }

    public void eliminarProducto() {
        String codieli = JOptionPane.showInputDialog("Ingrese el codigo del producto a eliminar : ");
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codieli)) {
                productos.remove(i);
            }
        }
        JOptionPane.showMessageDialog(null, "Producto eliminado con �xito.");
    }

    public ArrayList<Producto> getProductos() {
        return productos;
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
