package Datos;

import Persistencia.Cliente;
import Persistencia.Emprendedor;
import Persistencia.Emprendimiento;
import Presentacion.Menu;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author POWER
 */
public class Cuenta {

    private String cedula;
    private String username;
    private String password;
    private String correoElectronico;
    private int edad;
    private Cuenta clienteAutenticado;
    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private ArrayList<Emprendimiento> emprendimientos = new ArrayList<>();

    public Cuenta() {
    }

    public Cuenta(String cedula, String username, String password, String correoElectronico, int edad) {
        this.cedula = cedula;
        this.username = username;
        this.password = password;
        this.correoElectronico = correoElectronico;
        this.edad = edad;
    }
    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

        public void registrar() {
        Cliente c = new Cliente();
        JTextArea salida = new JTextArea();
        salida.setText("REGISTRO\n");

        String cedula = JOptionPane.showInputDialog("Ingresa el numero de cedula :");
        String username = JOptionPane.showInputDialog("Ingresa el nombre de usuario :");
        String password = JOptionPane.showInputDialog("Ingresa la contraseña :");
        String correoElectronico = JOptionPane.showInputDialog("Ingresa el correo electronico :");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu edad :"));

        c.setCedula(cedula);
        c.setUsername(username);
        c.setPassword(password);
        c.setCorreoElectronico(correoElectronico);
        c.setEdad(edad);
        
        cuentas.add(c);

        JOptionPane.showMessageDialog(null, "¡Cuenta creada con exito!"
                + "\nA continuacion, Inicie sesion");
    }
    
    public void iniciarSesion() {
        Menu menu = new Menu();
        JTextArea salida = new JTextArea();
        salida.setText("INICIO DE SESION\n");

        String username = JOptionPane.showInputDialog("Nombre de usuario:");
        String password = JOptionPane.showInputDialog("Contraseña:");

        Cuenta cu = buscarCuenta(username);
        if (cu != null && cu.getUsername().equals(username)) {
            if (cu.getPassword().equals(password)) {
                clienteAutenticado = cu;
                if (cu instanceof Cliente) {
                    menu.menuCliente();
                } else if (cu instanceof Emprendedor) {
                    menu.menuEmprendedor();
                }
            } else {
                JOptionPane.showMessageDialog(salida, "CONTRASEÑA INCORRECTA");
            }
        } else {
            JOptionPane.showMessageDialog(salida, "USUARIO INCORRECTO");
        }
    }


    public Cuenta buscarCuenta(String username) {
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta cuenta = cuentas.get(i);
            if (cuenta != null && cuenta.getUsername().equals(username)) {
                return cuenta;
            }
        }
        return null;
    }


    public void convertirEmprendedorACliente() {
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta cuenta = cuentas.get(i);

            if (cuenta instanceof Emprendedor emp) {
                Cliente nuevoCliente = new Cliente(
                        emp.getCedula(),
                        emp.getUsername(),
                        emp.getPassword(),
                        emp.getCorreoElectronico(),
                        emp.getEdad()
                );
                cuentas.remove(emp);
                cuentas.add(nuevoCliente);
                iniciarSesion();
            }
        }
    }
       public void convertirClienteEnEmprendedor() {
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta cuenta = cuentas.get(i);

            if (cuenta instanceof Cliente c) {
                Emprendedor nuevoEmprendedor = new Emprendedor(
                        c.getCedula(),
                        c.getUsername(),
                        c.getPassword(),
                        c.getCorreoElectronico(),
                        c.getEdad()
                );
                
                cuentas.add(nuevoEmprendedor);
                cuentas.remove(c);
                return;
            }
        }
    }

    public void convertirseEnEmprendedor() {

        String nombreEmprendimiento = JOptionPane.showInputDialog("Nombre del emprendimiento:");
        String nit = JOptionPane.showInputDialog("NIT:");

        int TiendaFisica = Integer.parseInt(JOptionPane.showInputDialog("¿Tiene tienda física?"
                + "\n[1] Sí"
                + "\n[2] No"));
        switch (TiendaFisica) {
            case 1:
                String direccion = JOptionPane.showInputDialog("Dirección de la tienda:");
                convertirClienteEnEmprendedor();
                Emprendimiento nuevoEmprendimiento1 = new Emprendimiento(nombreEmprendimiento, nit, direccion);
                emprendimientos.add(nuevoEmprendimiento1);
                JOptionPane.showMessageDialog(null, "¡Te has "
                        + "convertido en emprendedor con éxito! A continuación, inicia sesión.");
                iniciarSesion();
                break;
            case 2:
                direccion = "NO TIENE";
                convertirClienteEnEmprendedor();
                Emprendimiento nuevoEmprendimiento = new Emprendimiento(nombreEmprendimiento, nit, direccion);
                emprendimientos.add(nuevoEmprendimiento);
                JOptionPane.showMessageDialog(null, "¡Te has "
                        + "convertido en emprendedor con éxito! A continuación, inicia sesión.");
                iniciarSesion();
                break;
            default: {
                JOptionPane.showMessageDialog(null, "Opcion no valida");
                break;
            }
        }

    }

    public void buscarEmprendimiento() {
        Emprendimiento emprendimiento1 = new Emprendimiento();
        Menu menu = new Menu();
        String nombre = JOptionPane.showInputDialog("Escriba el nombre del Emprendimiento");
        Emprendimiento emprendimientoEncontrado = null;

        for (Emprendimiento emprendimiento : emprendimientos) {
            if (emprendimiento.getNombreEmprendimiento().equals(nombre)) {
                emprendimientoEncontrado = emprendimiento;
                break;
            }
        }

        if (emprendimientoEncontrado != null) {
            JOptionPane.showMessageDialog(null, "Emprendimiento encontrado con éxito "
                    + "\nNombre del emprendimiento : " + nombre + ": \n");
            mostrarEmprendimiento(emprendimientoEncontrado);
            menu.menuReseñasEmprendimiento(emprendimiento1);

        } else {
            JOptionPane.showMessageDialog(null, "Emprendimiento " + nombre + " no encontrado.");
        }
    }

    public void mostrarEmprendimiento(Emprendimiento emprendimiento) {
        JTextArea salida = new JTextArea();
        salida.setText("INFORMACION DEL EMPRENDIMIENTO\n");
        salida.append("Codigo:   " + emprendimiento.getNombreEmprendimiento()
                + "\nNIT       : " + emprendimiento.getNit()
                + "\nDireccion : " + emprendimiento.getDireccion());
        salida.append("\n\n");
        JOptionPane.showMessageDialog(null, salida);
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

    public void perfilEmprendedor(Emprendedor emprendedor) {
        JTextArea salida = new JTextArea();
        salida.setText("PERFIL DEL EMPRENDEDOR\n");
        salida.append("Cedula           : " + emprendedor.getCedula()
                + "\nNombre de Usuario  : " + emprendedor.getUsername()
                + "\nCorreo Electrónico : " + emprendedor.getCorreoElectronico()
                + "\nEdad               : " + emprendedor.getEdad());
        salida.append("\n\n");
        JOptionPane.showMessageDialog(null, salida);
    }
}
