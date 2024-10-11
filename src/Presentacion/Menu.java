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
    private Cuenta cu;

    public Menu() {
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

    public void registrar() {
        JTextArea salida = new JTextArea();
        salida.setText("REGISTRO\n");
        String cedula, correoElectronico, username, password;
        int edad, opcion;

        cedula = JOptionPane.showInputDialog("Ingresa el numero de cedula :");
        username = JOptionPane.showInputDialog("Ingresa el nombre de usuario :");
        password = JOptionPane.showInputDialog("Ingresa la contraseña :");
        correoElectronico = JOptionPane.showInputDialog("Ingresa el correo electronico :");
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu edad :"));

        Cliente c = new Cliente();
        c.setCedula(cedula);
        c.setUsername(username);
        c.setPassword(password);
        c.setCorreoElectronico(correoElectronico);
        c.setEdad(edad);
        cuentas.add(c);

        JOptionPane.showMessageDialog(null, "¡Cuenta creada con exito!"
                + "\nA continuacion, Inicie sesion");
    }

    public void iniciar() {
        int opcion, seleccion;
        do {
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "\n MENU"
                    + "\n\n[1] REGISTRAR"
                    + "\n[2] INICIAR SESION"
                    + "\n[3] SALIR"
                    + "\n\n ELIJA UNA OPCION :"));
            switch (op) {
                case 1: {
                    registrar();
                    iniciarSesion();
                }
                break;
                case 2: {
                    iniciarSesion();

                }
                break;
                case 3: {
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    return;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
                }
            }
            opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar al menu principal?",
                    "confirmacion", JOptionPane.YES_NO_OPTION);
        } while (opcion == JOptionPane.YES_NO_OPTION);
    }

    public void iniciarSesion() {
        JTextArea salida = new JTextArea();
        salida.setText("INICIO DE SESION\n");

        String username = JOptionPane.showInputDialog("Nombre de usuario:");
        String password = JOptionPane.showInputDialog("Contraseña:");

        Cuenta cu = buscarCuenta(username);
        if (cu != null && cu.getUsername().equals(username)) {
            if (cu.getPassword().equals(password)) {

                if (cu instanceof Cliente) {

                    menuCliente();
                } else if (cu instanceof Emprendedor) {

                    menuEmprendedor();
                }
            } else {
                JOptionPane.showMessageDialog(salida, "CONTRASEÑA INCORRECTA");
            }
        } else {
            JOptionPane.showMessageDialog(salida, "USUARIO INCORRECTO");
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
                cuentas.remove(c);
                cuentas.add(nuevoEmprendedor);
                return;
            }
        }
    }

    private void convertirseEnEmprendedor() {

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

    public void menuCliente() {
        int opcion;
        do {
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "BIENVENIDO \nMENU CLIENTE \n"
                    + "\n[1] Buscar productos"
                    + "\n[2] Buscar emprendimientos"
                    + "\n[3] Convertirse en emprendedor"
                    + "\n[4] Salir"
                    + "\n\nELIJA UNA OPCIÓN:"));
            switch (op) {
                case 1:
                    buscarProductos();
                    break;
                case 2:
                    buscarEmprendimiento();
                    break;
                case 3:
                    convertirseEnEmprendedor();
                    break;
                case 4:
                    break;
                default: {
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
                }
            }
            opcion = JOptionPane.showConfirmDialog(null, "¿Desea volver al menú principal?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);
        } while (opcion == JOptionPane.YES_OPTION);
    }

    private void agregarProducto() {
        int opcion;
        do {
            int tipoProducto = Integer.parseInt(JOptionPane.showInputDialog("\nAGREGAR PRODUCTO"
                    + "\n¿Que tipo de producto quiere agregar?"
                    + "\n[1] Servicio"
                    + "\n[2] Producto"));
            switch (tipoProducto) {
                case 1:
                    String codigo = JOptionPane.showInputDialog("Codigo :");
                    String nombre = JOptionPane.showInputDialog("Nombre :");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio :"));
                    String descripcion = JOptionPane.showInputDialog("Descripcion del producto :");
                    Producto servicio = new Servicio(codigo, nombre, precio, descripcion);
                    productos.add(servicio);
                    break;
                case 2:
                    codigo = JOptionPane.showInputDialog("Codigo :");
                    nombre = JOptionPane.showInputDialog("Nombre :");
                    precio = Double.parseDouble(JOptionPane.showInputDialog("Precio :"));
                    descripcion = JOptionPane.showInputDialog("Descripcion del producto :");
                    Producto producto = new Producto(codigo, nombre, precio, descripcion);
                    productos.add(producto);
                    break;
                default: {
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
                }
            }

            opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otro producto?", "Confirmacion", JOptionPane.YES_NO_OPTION);
        } while (opcion == JOptionPane.YES_NO_OPTION);
    }

    private void eliminarProducto() {
        String codieli = JOptionPane.showInputDialog("Ingrese el codigo del producto a eliminar : ");
        Producto producto = new Producto(codieli);
        productos.remove(producto);
    }

    public void menuEmprendedor() {

        int opcion;
        do {
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "\nMENU EMPRENDEDOR"
                    + "\n[1] Agregar producto"
                    + "\n[2] Eliminar producto"
                    + "\n[3] Buscar productos"
                    + "\n[4] Buscar emprendimientos"
                    + "\n[5] Salir"
                    + "\n\nELIJA UNA OPCION :"));
            switch (op) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    eliminarProducto();
                    break;
                case 3:
                    buscarProductos();
                    break;
                case 4:
                    buscarEmprendimiento();
                    break;

                case 5:
                    break;

                default: {
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
                }

            }
            opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar al menu principal?",
                    "confirmacion", JOptionPane.YES_NO_OPTION);
        } while (opcion == JOptionPane.YES_OPTION);
    }

    public void mostrarProducto() {
        JTextArea salida = new JTextArea();
        salida.setText("INFORMACION DEL PRODUCTO\n");
        for (int i = 0; i < productos.size(); i++) {
            salida.append("Codigo: " + productos.get(i).getCodigo()
                    + "\nNombre: " + productos.get(i).getNombre()
                    + "\nPrecio: " + productos.get(i).getPrecio()
                    + "\nDescripcion: " + productos.get(i).getDescripcion());
            salida.append("\n\n");
        }
        JOptionPane.showMessageDialog(null, salida);
    }

    public void mostrarEmprendimiento() {
        JTextArea salida = new JTextArea();
        salida.setText("INFORMACION DEL EMPRENDIMIENTO\n");
        for (int i = 0; i < emprendimientos.size(); i++) {
            salida.append("NIT : " + emprendimientos.get(i).getNit()
                    + "\nNombre : " + emprendimientos.get(i).getNombreEmprendimiento()
                    + "\nDireccion : " + emprendimientos.get(i).getDireccion());
            salida.append("\n\n");
        }
        JOptionPane.showMessageDialog(null, salida);
    }

    public void buscarProductos() {
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
            mostrarProducto();

            int op = Integer.parseInt(JOptionPane.showInputDialog("\n[1] Agregar reseña"
                    + "\n[2] Ver reseñas"
                    + "\n[3] Salir"
                    + "\nElija una opción :"));
            switch (op) {
                case 1:
                    agregarReseña();
                    break;
                case 2:
                    JTextArea textArea = new JTextArea(10, 30);
                    textArea.setEditable(false);

                    if (!productoEncontrado.getCodigo().equals(codigo)) {
                        textArea.setText("No hay reseñas para este producto.");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        double suma = 0;
                        int totalReseñas = reseñas.size();

                        for (Reseña reseña : reseñas) {
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
                    break;
                case 3:
                    break;
                default: {
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Producto " + codigo + " no encontrado.");
        }
    }

    public void agregarReseña() {
        String descripcion = JOptionPane.showInputDialog("Redacta tu reseña :");
        int calificacion = Integer.parseInt(JOptionPane.showInputDialog("¿Que calificación le darías? (1-5)"
                + "\n[1] Pésima"
                + "\n[2] Mala"
                + "\n[3] Puede mejorar"
                + "\n[4] Buena"
                + "\n[5] Excelente"));
        Reseña reseña = new Reseña(descripcion, calificacion);
        reseñas.add(reseña);
        JOptionPane.showMessageDialog(null, "Reseña agregada con éxito.");
    }

    public void buscarEmprendimiento() {
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
            mostrarEmprendimiento();

            int op = Integer.parseInt(JOptionPane.showInputDialog("\n[1] Agregar reseña"
                    + "\n[2] Ver reseñas"
                    + "\n[3] Salir"
                    + "\nElija una opción :"));
            switch (op) {
                case 1:
                    agregarReseña();
                    break;
                case 2:
                    JTextArea textArea = new JTextArea(10, 30);
                    textArea.setEditable(false);

                    if (!emprendimientoEncontrado.getNombreEmprendimiento().equals(nombre)) {
                        textArea.setText("No hay reseñas para este Emprendimiento.");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        double suma = 0;
                        int totalReseñas = reseñas.size();

                        for (Reseña reseña : reseñas) {
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
                    JOptionPane.showMessageDialog(null, scrollPane, "Reseñas del Emprendimiento", JOptionPane.INFORMATION_MESSAGE);

                    break;
                case 3:
                    break;
                default: {
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Emprendimiento " + nombre + " no encontrado.");
        }
    }

}
