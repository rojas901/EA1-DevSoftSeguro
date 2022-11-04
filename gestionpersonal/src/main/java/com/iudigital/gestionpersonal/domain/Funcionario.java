/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iudigital.gestionpersonal.domain;

import java.sql.Date;

/**
 *
 * @author caran
 */
public class Funcionario {
    private int idFuncionario;
    private int fkTipoIdentificacion;
    private int fkEstadoCivil;
    private int fkSexo;
    private String nombre;
    private String apellido;
    private String numeroIdentificacion;
    private String direccion;
    private Date fechaNacimiento;
    private String telefono;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getFkTipoIdentificacion() {
        return fkTipoIdentificacion;
    }

    public void setFkTipoIdentificacion(int fkTipoIdentificacion) {
        this.fkTipoIdentificacion = fkTipoIdentificacion;
    }

    public int getFkEstadoCivil() {
        return fkEstadoCivil;
    }

    public void setFkEstadoCivil(int fkEstadoCivil) {
        this.fkEstadoCivil = fkEstadoCivil;
    }

    public int getFkSexo() {
        return fkSexo;
    }

    public void setFkSexo(int fkSexo) {
        this.fkSexo = fkSexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }    
}