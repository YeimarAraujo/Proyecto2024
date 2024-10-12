/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Datos.Cuenta;
import Presentacion.Menu;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author POWER
 */
public class Emprendedor extends Cuenta {

    private Emprendimiento emprendimiento;

    public Emprendedor() {
    }

    public Emprendedor(String cedula, String username, String password, String correoElectronico, int edad) {
        super(cedula, username, password, correoElectronico, edad);
    }


    public Emprendimiento getEmprendimiento() {
        return emprendimiento;
    }

    public void setEmprendimiento(Emprendimiento emprendimiento) {
        this.emprendimiento = emprendimiento;
    }
    public void agregarProducto (Producto producto){
        emprendimiento.agregarProducto(producto);
    }
    
    
    public void mostrarProductosEmprendimiento(Emprendimiento emprendimiento) {
    JTextArea salida = new JTextArea(15, 30); 
    salida.setEditable(false); 
    salida.setText("INFORMACION DE LOS PRODUCTOS DEL EMPRENDIMIENTO\n");
    
    for (Producto producto : emprendimiento.getProductos()) {
        salida.append("Codigo      : " + producto.getCodigo()
                + "\nNombre      : " + producto.getNombre()
                + "\nPrecio      : " + producto.getPrecio()
                + "\nDescripcion : " + producto.getDescripcion());
        salida.append("\n\n");
    }
    
    JScrollPane scrollPane = new JScrollPane(salida);
    JOptionPane.showMessageDialog(null, scrollPane, "Productos del Emprendimiento", JOptionPane.INFORMATION_MESSAGE);
}
   

}
