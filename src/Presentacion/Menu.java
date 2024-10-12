/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Datos.Cuenta;
import Persistencia.Servicio;
import Persistencia.Reseña;
import Persistencia.Producto;
import Persistencia.Cliente;
import Persistencia.Emprendedor;
import Persistencia.Emprendimiento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author POWER
 */
public class Menu {

    private Emprendimiento emprendimiento = new Emprendimiento();
    private Cliente c = new Cliente();
    private Producto p = new Producto();
    private Emprendedor emp = new Emprendedor();
    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private ArrayList<Emprendimiento> emprendimientos = new ArrayList<>();
    private ArrayList<Reseña> reseñas = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private Cuenta cu = new Cuenta();

    public Menu() {
    }

    public void iniciar() {
        int opcion, seleccion;
        try {
            do {
                int op = Integer.parseInt(JOptionPane.showInputDialog(
                        "\n MENU"
                        + "\n\n[1] REGISTRAR"
                        + "\n[2] INICIAR SESION"
                        + "\n[3] SALIR"
                        + "\n\n ELIJA UNA OPCION :"));
                switch (op) {
                    case 1: {
                        cu.registrar();
                        cu.iniciarSesion();
                    }
                    break;
                    case 2: {
                        cu.iniciarSesion();

                    }
                    break;
                    case 3: {
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        System.exit(0);
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Opcion no valida");
                        break;
                    }
                }
                opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar al menu principal?",
                        "confirmacion", JOptionPane.YES_NO_OPTION);
            } while (opcion == JOptionPane.YES_NO_OPTION);
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error, solo digitar numeros de las opciones", "Error", JOptionPane.ERROR_MESSAGE);
            iniciar();
        }
    }
    

    public void menuCliente() {
        int opcion, cont = 0;
        try {
            do {
                int op = Integer.parseInt(JOptionPane.showInputDialog(
                        "BIENVENIDO \nMENU CLIENTE \n"
                        + "\n[1] Buscar productos"
                        + "\n[2] Buscar emprendimientos"
                        + "\n[3] Convertirse en emprendedor"
                        + "\n[4] Perfil"
                        + "\n[5] Salir"
                        + "\n\nELIJA UNA OPCIÓN:"));
                switch (op) {
                    case 1:
                        emprendimiento.buscarProductos();
                        break;
                    case 2:
                        cu.buscarEmprendimiento();
                        break;
                    case 3:
                        cu.convertirseEnEmprendedor();
                        break;
                    case 4:
                       cu.perfilCliente(c);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        iniciar();
                        break;
                    default: {
                        JOptionPane.showMessageDialog(null, "Opcion no valida");
                        break;
                    }
                }
                opcion = JOptionPane.showConfirmDialog(null, "¿Desea volver al menú principal?",
                        "Confirmación", JOptionPane.YES_NO_OPTION);
            } while (opcion == JOptionPane.YES_OPTION);
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error, solo digitar numeros de las opciones", "Error", JOptionPane.ERROR_MESSAGE);
            menuCliente();
        }
    }

    public void menuEmprendedor() {

        int opcion;
        try {
            do {
                int op = Integer.parseInt(JOptionPane.showInputDialog(
                        "\nMENU EMPRENDEDOR"
                        + "\n[1] Agregar producto"
                        + "\n[2] Eliminar producto"
                        + "\n[3] Buscar productos"
                        + "\n[4] Buscar emprendimientos"
                        + "\n[5] Dejar de ser emprendedor"
                        + "\n[6] Perfil"
                        + "\n[7] Salir"
                        + "\n\nELIJA UNA OPCION :"));
                switch (op) {
                    case 1:
                        emprendimiento.agregarProducto(p);
                        break;
                    case 2:
                        emprendimiento.eliminarProducto();
                        break;
                    case 3:
                        emprendimiento.buscarProductos();
                        break;
                    case 4:
                        cu.buscarEmprendimiento();
                        break;
                    case 5:
                        cu.convertirEmprendedorACliente();
                        cu.iniciarSesion();
                        break;
                    case 6:
                        cu.perfilEmprendedor(emp);
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        iniciar();
                        break;
                    default: {
                        JOptionPane.showMessageDialog(null, "Opcion no valida");
                        break;
                    }

                }
                opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar al menu principal?",
                        "confirmacion", JOptionPane.YES_NO_OPTION);
            } while (opcion == JOptionPane.YES_OPTION);
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error, solo digitar numeros de las opciones", "Error", JOptionPane.ERROR_MESSAGE);
            menuEmprendedor();
        }
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

    public void menuReseñasEmprendimiento(Emprendimiento emprendimiento) {
        int op = Integer.parseInt(JOptionPane.showInputDialog(
                "\n[1] Agregar reseña"
                + "\n[2] Ver reseñas"
                + "\n[3] Ver productos"
                + "\n[4] Salir"
                + "\nElija una opción :"));
        switch (op) {
            case 1:
                emprendimiento.agregarReseña();
                menuReseñasEmprendimiento(emprendimiento);
                break;
            case 2:
                mostrarReseñasPorEmprendimiento(emprendimiento);
                menuReseñasEmprendimiento(emprendimiento);
                break;
            case 3:
                emp.mostrarProductosEmprendimiento(emprendimiento);
                menuReseñasEmprendimiento(emprendimiento);
                break;
            case 4:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
                break;
        }
    }

    

    /*
    public Cliente buscarCliente(String username) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente != null && cliente.getUsername().equals(username)) {
                return cliente;
            }
        }
        return null;
    }

    public Emprendedor buscarEmprendedor(String username) {
        for (int i = 0; i < emprendedores.size(); i++) {
            Emprendedor emprendedor = emprendedores.get(i);
            if (emprendedor != null && emprendedor.getUsername().equals(username)) {
                return emprendedor;
            }
        }
        return null;
    }
     */


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

    public void mostrarReseñasPorEmprendimiento(Emprendimiento emprendimiento) {
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        ArrayList<Reseña> reseñasDelEmprendimiento = emprendimiento.obtenerReseñas();

        if (reseñasDelEmprendimiento.isEmpty()) {
            textArea.setText("No hay reseñas para este producto.");
        } else {
            StringBuilder sb = new StringBuilder();
            double suma = 0;
            int totalReseñas = reseñasDelEmprendimiento.size();

            for (Reseña reseña : reseñasDelEmprendimiento) {
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

    }