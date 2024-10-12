/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Datos.Cuenta;
import Presentacion.Menu;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 *
 * @author POWER
 */
public class Cliente extends Cuenta {
     
    public Cliente() {
    
        

    }

    public Cliente(String cedula, String username, String password, String correoElectronico, int edad) {
        super(cedula, username, password, correoElectronico, edad);
    }
    
  
    public void perfilCliente(Cliente cliente) {
        JTextArea salida = new JTextArea();
        salida.setText("PERFIL DEL CLIENTE\n");
        salida.append("Cedula            : " + cliente.getCedula()
                + "\nNombre de Usuario   : " + cliente.getUsername()
                + "\nCorreo Electrónico  : " + cliente.getCorreoElectronico()
                + "\nEdad                : " + cliente.getEdad());
        salida.append("\n\n");
        JOptionPane.showMessageDialog(null, salida);
    }

}
