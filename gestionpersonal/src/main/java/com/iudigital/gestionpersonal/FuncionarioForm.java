/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iudigital.gestionpersonal;

import com.iudigital.gestionpersonal.controller.FuncionarioController;
import com.iudigital.gestionpersonal.domain.Funcionario;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caran
 */
public class FuncionarioForm extends javax.swing.JFrame {
    
    private final FuncionarioController funcionarioController;
    private static final String[] COLUMNS = {"Id", "Tipo Id", "Estado civil", "Sexo", "Nombre", "Apellido", "Numero Id", "Direccion", "Fecha Nacimiento", "Telefono"};
    private static final String SELECCIONE = "--Selecione--";
    /**
     * Creates new form FuncionarioForm
     */
    public FuncionarioForm() {
        initComponents();
        txtId.setEditable(false);
        funcionarioController = new FuncionarioController();
        listarFuncionarios();
        addListenerCbx();
    }
    
    private void listarFuncionarios()  {
        
        cbxFuncionarios.removeAllItems();
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNombre(SELECCIONE);
        funcionario1.setApellido("");
        cbxFuncionarios.addItem(funcionario1);
        
        tblFuncionarios.removeAll();
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }
        
        tblFuncionarios.setModel(defaultTableModel);
        
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios2();
            
            if (funcionarios.isEmpty()) {
                return;
            }
            
            defaultTableModel.setRowCount(funcionarios.size());
            int row = 0;
            for (Funcionario funcionario: funcionarios) {
                defaultTableModel.setValueAt(funcionario.getIdFuncionario(), row, 0);
                defaultTableModel.setValueAt(funcionario.getNombreTipoIdentificacion(), row, 1);
                defaultTableModel.setValueAt(funcionario.getNombreEstadoCivil(), row, 2);
                defaultTableModel.setValueAt(funcionario.getNombreSexo(), row, 3);
                defaultTableModel.setValueAt(funcionario.getNombre(), row, 4);
                defaultTableModel.setValueAt(funcionario.getApellido(), row, 5);
                defaultTableModel.setValueAt(funcionario.getNumeroIdentificacion(), row, 6);
                defaultTableModel.setValueAt(funcionario.getDireccion(), row, 7);
                defaultTableModel.setValueAt(funcionario.getFechaNacimiento(), row, 8);
                defaultTableModel.setValueAt(funcionario.getTelefono(), row, 9);
                row++;
                
                cbxFuncionarios.addItem(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
        
    }
    
    private void addListenerCbx() {
        cbxFuncionarios.addItemListener(event -> {
            Funcionario selectedFuncionario = (Funcionario) event.getItem();
            if (selectedFuncionario.getNombre().equals(SELECCIONE)) {
                txtId.setText("");
                txtTipoIdEdit.setText("");
                txtEstadoEdit.setText("");
                txtSexoEdit.setText("");
                txtNombreEdit.setText("");
                txtApellidoEdit.setText("");
                txtNumeroIdEdit.setText("");
                txtDireccionEdit.setText("");
                txtFechaEdit.setText("");
                txtTelefonoEdit.setText("");
            } else {
                txtId.setText(String.valueOf(selectedFuncionario.getIdFuncionario()));
                txtTipoIdEdit.setText(String.valueOf(selectedFuncionario.getFkTipoIdentificacion()));
                txtEstadoEdit.setText(String.valueOf(selectedFuncionario.getFkEstadoCivil()));
                txtSexoEdit.setText(String.valueOf(selectedFuncionario.getFkSexo()));
                txtNombreEdit.setText(selectedFuncionario.getNombre());
                txtApellidoEdit.setText(selectedFuncionario.getApellido());
                txtNumeroIdEdit.setText(selectedFuncionario.getNumeroIdentificacion());
                txtDireccionEdit.setText(selectedFuncionario.getDireccion());
                txtFechaEdit.setText(String.valueOf(selectedFuncionario.getFechaNacimiento()));
                txtTelefonoEdit.setText(selectedFuncionario.getTelefono());
            }
            
            System.out.println("selected funcionario: " + selectedFuncionario);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jTPanels = new javax.swing.JTabbedPane();
        jPCrear = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTipoId = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblNumeroId = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtTipoId = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNumeroId = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jPEditar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblFuncionarios = new javax.swing.JLabel();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        lblId = new javax.swing.JLabel();
        lblTipoIdEdit = new javax.swing.JLabel();
        lblEstadoEdit = new javax.swing.JLabel();
        lblSexoEdit = new javax.swing.JLabel();
        lblNombreEdit = new javax.swing.JLabel();
        lblApellidoEdit = new javax.swing.JLabel();
        lblNumeroIdEdit = new javax.swing.JLabel();
        lblDireccionEdit = new javax.swing.JLabel();
        lblFechaEdit = new javax.swing.JLabel();
        lblTelefonoEdit = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtTipoIdEdit = new javax.swing.JTextField();
        txtEstadoEdit = new javax.swing.JTextField();
        txtSexoEdit = new javax.swing.JTextField();
        txtNombreEdit = new javax.swing.JTextField();
        txtApellidoEdit = new javax.swing.JTextField();
        txtNumeroIdEdit = new javax.swing.JTextField();
        txtDireccionEdit = new javax.swing.JTextField();
        txtFechaEdit = new javax.swing.JTextField();
        txtTelefonoEdit = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Gestion de funcionarios");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes campos"));

        lblTipoId.setText("Tipo identificación");

        lblEstado.setText("Estado civil");

        lblSexo.setText("Sexo");

        lblNombre.setText("Nombre");

        lblApellido.setText("Apellido");

        lblNumeroId.setText("Número identificación");

        lblDireccion.setText("Dirección");

        lblFecha.setText("Fecha nacimiento");

        lblTelefono.setText("Telefono");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblEstado)
                                .addGap(50, 50, 50)
                                .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNumeroId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFecha)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(lblApellido)
                                .addGap(51, 51, 51))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(lblNumeroId)
                                    .addGap(36, 36, 36)
                                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellido)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTipoId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblApellido))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNumeroId)
                        .addComponent(lblDireccion)
                        .addComponent(lblTelefono)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPCrearLayout = new javax.swing.GroupLayout(jPCrear);
        jPCrear.setLayout(jPCrearLayout);
        jPCrearLayout.setHorizontalGroup(
            jPCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCrearLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPCrearLayout.setVerticalGroup(
            jPCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCrearLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPanels.addTab("Crear", jPCrear);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifique los siguientes campos"));

        lblFuncionarios.setText("Funcionarios");

        lblId.setText("Id");

        lblTipoIdEdit.setText("Tipo identificación");

        lblEstadoEdit.setText("Estado civil");

        lblSexoEdit.setText("Sexo");

        lblNombreEdit.setText("Nombre");

        lblApellidoEdit.setText("Apellido");

        lblNumeroIdEdit.setText("Número identificación");

        lblDireccionEdit.setText("Dirección");

        lblFechaEdit.setText("Fecha nacimiento");

        lblTelefonoEdit.setText("Telefono");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblTipoIdEdit))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTipoIdEdit)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblEstadoEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEstadoEdit))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblDireccionEdit)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(lblFechaEdit)
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(lblSexoEdit)
                                .addGap(52, 52, 52)
                                .addComponent(lblNombreEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(lblApellidoEdit)
                                .addContainerGap(36, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTelefonoEdit)
                                .addGap(25, 25, 25))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtNombreEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellidoEdit))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEliminar)
                                    .addComponent(txtFechaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefonoEdit)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblFuncionarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNumeroIdEdit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumeroIdEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnActualizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarios)
                    .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblTipoIdEdit)
                    .addComponent(lblEstadoEdit)
                    .addComponent(lblSexoEdit)
                    .addComponent(lblNombreEdit)
                    .addComponent(lblApellidoEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoIdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionEdit)
                    .addComponent(lblFechaEdit)
                    .addComponent(lblTelefonoEdit)
                    .addComponent(lblNumeroIdEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroIdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPEditarLayout = new javax.swing.GroupLayout(jPEditar);
        jPEditar.setLayout(jPEditarLayout);
        jPEditarLayout.setHorizontalGroup(
            jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPEditarLayout.setVerticalGroup(
            jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPanels.addTab("Editar", jPEditar);

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTPanels, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTPanels, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtTipoId.getText().trim().length() == 0) { //trim es para que no deje espacios
            JOptionPane.showMessageDialog(null, "Digite identificador de tipo de documento"); // mostramos el mensaje si el campo está vacío
            txtTipoId.requestFocus(); //nos deja el cursor sobre el campo que esta vacío
            return;
        }

        if (txtEstado.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite identificador de estado civil");
            txtEstado.requestFocus();
            return;
        }

        if (txtSexo.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite identificador del sexo");
            txtSexo.requestFocus();
            return;
        }

        if (txtNombre.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite nombre");
            txtNombre.requestFocus();
            return;
        }

        if (txtApellido.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite apellido");
            txtApellido.requestFocus();
            return;
        }
        
        if (txtNumeroId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite número de identificación");
            txtNumeroId.requestFocus();
            return;
        }
        
        if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite dirección");
            txtDireccion.requestFocus();
            return;
        }
        
        if (txtFecha.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite fecha de nacimiento");
            txtFecha.requestFocus();
            return;
        }
        
        if (txtTelefono.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite telefono");
            txtTelefono.requestFocus();
            return;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setFkTipoIdentificacion(Integer.parseInt(txtTipoId.getText().trim()));
        funcionario.setFkEstadoCivil(Integer.parseInt(txtEstado.getText().trim()));
        funcionario.setFkSexo(Integer.parseInt(txtSexo.getText().trim()));
        funcionario.setNombre(txtNombre.getText().trim());
        funcionario.setApellido(txtApellido.getText().trim());
        funcionario.setNumeroIdentificacion(txtNumeroId.getText().trim());
        funcionario.setDireccion(txtDireccion.getText().trim());
        funcionario.setFechaNacimiento(Date.valueOf(txtFecha.getText().trim()));
        funcionario.setTelefono(txtTelefono.getText().trim());

        try {
            funcionarioController.crearFuncionario(funcionario);
            txtId.setText("");
            txtTipoId.setText("");
            txtEstado.setText("");
            txtSexo.setText("");
            txtNombre.setText("");
            txtApellido.setText("");
            txtNumeroId.setText("");
            txtDireccion.setText("");
            txtFecha.setText("");
            txtTelefono.setText("");
            listarFuncionarios();
            JOptionPane.showMessageDialog(null, "Funcionario creado con éxito");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Funcionario no pudo ser creado");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        if (txtId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario de la lista");
            txtId.requestFocus();
            return;
        }
        
        if (txtTipoIdEdit.getText().trim().length() == 0) { //trim es para que no deje espacios
            JOptionPane.showMessageDialog(null, "Digite identificador de tipo de documento"); // mostramos el mensaje si el campo está vacío
            txtTipoIdEdit.requestFocus(); //nos deja el cursor sobre el campo que esta vacío
            return;
        }

        if (txtEstadoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite identificador de estado civil");
            txtEstadoEdit.requestFocus();
            return;
        }

        if (txtSexoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite identificador del sexo");
            txtSexoEdit.requestFocus();
            return;
        }

        if (txtNombreEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite nombre");
            txtNombreEdit.requestFocus();
            return;
        }

        if (txtApellidoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite apellido");
            txtApellidoEdit.requestFocus();
            return;
        }
        
        if (txtNumeroIdEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite número de identificación");
            txtNumeroIdEdit.requestFocus();
            return;
        }
        
        if (txtDireccionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite dirección");
            txtDireccionEdit.requestFocus();
            return;
        }
        
        if (txtFechaEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite fecha de nacimiento");
            txtFechaEdit.requestFocus();
            return;
        }
        
        if (txtTelefonoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite telefono");
            txtTelefonoEdit.requestFocus();
            return;
        }
        
        Funcionario funcionario = new Funcionario();
        funcionario.setFkTipoIdentificacion(Integer.parseInt(txtTipoIdEdit.getText().trim()));
        funcionario.setFkEstadoCivil(Integer.parseInt(txtEstadoEdit.getText().trim()));
        funcionario.setFkSexo(Integer.parseInt(txtSexoEdit.getText().trim()));
        funcionario.setNombre(txtNombreEdit.getText().trim());
        funcionario.setApellido(txtApellidoEdit.getText().trim());
        funcionario.setNumeroIdentificacion(txtNumeroIdEdit.getText().trim());
        funcionario.setDireccion(txtDireccionEdit.getText().trim());
        funcionario.setFechaNacimiento(Date.valueOf(txtFechaEdit.getText().trim()));
        funcionario.setTelefono(txtTelefonoEdit.getText().trim());
        
        int opt = JOptionPane.showConfirmDialog(null, "Desea actualizar el funcionario", "Confirmar salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (opt == 0) {

            try { // en este metodo actualizar hacemos el casteo de string a integer, recibe dos parametros el id y el carro
                funcionarioController.actulizarFuncionario(Integer.parseInt(txtId.getText()), funcionario);
                txtId.setText("");
                txtTipoIdEdit.setText("");
                txtEstadoEdit.setText("");
                txtSexoEdit.setText("");
                txtNombreEdit.setText("");
                txtApellidoEdit.setText("");
                txtNumeroIdEdit.setText("");
                txtDireccionEdit.setText("");
                txtFechaEdit.setText("");
                txtTelefonoEdit.setText("");
                listarFuncionarios();
                JOptionPane.showMessageDialog(null, "Funcionario actualizado con éxito");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No fué posible actualizar el funcionario");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario de la lista");
            txtId.requestFocus();
            return;
        }
        
        int opt = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el funcionario", "Confirmar salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (opt == 0) {

            try {
                funcionarioController.eliminarFuncionario(Integer.parseInt(txtId.getText()));
                txtId.setText("");
                txtTipoId.setText("");
                txtEstado.setText("");
                txtSexo.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                txtNumeroId.setText("");
                txtDireccion.setText("");
                txtFecha.setText("");
                txtTelefono.setText("");
                listarFuncionarios();
                JOptionPane.showMessageDialog(null, "Se elimino el funcionario correctamente");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No fué posible eliminar el funcionario");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Funcionario> cbxFuncionarios;
    private javax.swing.JPanel jPCrear;
    private javax.swing.JPanel jPEditar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTPanels;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellidoEdit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionEdit;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoEdit;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaEdit;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreEdit;
    private javax.swing.JLabel lblNumeroId;
    private javax.swing.JLabel lblNumeroIdEdit;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexoEdit;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoEdit;
    private javax.swing.JLabel lblTipoId;
    private javax.swing.JLabel lblTipoIdEdit;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoEdit;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionEdit;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtEstadoEdit;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaEdit;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEdit;
    private javax.swing.JTextField txtNumeroId;
    private javax.swing.JTextField txtNumeroIdEdit;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtSexoEdit;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoEdit;
    private javax.swing.JTextField txtTipoId;
    private javax.swing.JTextField txtTipoIdEdit;
    // End of variables declaration//GEN-END:variables
}
