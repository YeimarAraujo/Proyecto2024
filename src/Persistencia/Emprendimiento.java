/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;



/**
 *
 * @author POWER
 */
public class Emprendimiento {

    private String nombreEmprendimiento;
    private String nit;
    private String direccion;
    
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


}
