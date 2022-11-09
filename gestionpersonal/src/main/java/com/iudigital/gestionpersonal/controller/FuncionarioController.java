/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iudigital.gestionpersonal.controller;

import com.iudigital.gestionpersonal.dao.FuncionarioDAO;
import com.iudigital.gestionpersonal.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author caran
 */
public class FuncionarioController {
    
    private FuncionarioDAO funcionarioDao;
    
    public FuncionarioController() {
        funcionarioDao = new FuncionarioDAO();
    }
        
    public void crearFuncionario(Funcionario funcionario) throws SQLException {
            funcionarioDao.crearFuncionario(funcionario);
    }
    
    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        return funcionarioDao.listarFuncionarios();
    }
    
    public List<Funcionario> obtenerFuncionarios2() throws SQLException {
        return funcionarioDao.listarFuncionarios2();
    }
    
    public Funcionario obtenerFuncionario(int idFuncionario) throws SQLException {
        return funcionarioDao.obtenerFuncionario(idFuncionario);
    }
    
    public void actulizarFuncionario(int idFuncionario, Funcionario funcionario) throws SQLException {
        funcionarioDao.actualizarFuncionario(idFuncionario, funcionario);
    }
    
    public void eliminarFuncionario(int idFuncionario) throws SQLException {
        funcionarioDao.eliminarFuncionario(idFuncionario);
    }
}
