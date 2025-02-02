
package vista;

import DAO.CitasDAO;
import DAO.ClinicaDAO;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Dominio.Citas;
import Dominio.Clinicas;


public class VistaCitas extends javax.swing.JFrame {
    String []columnas={"CODIGO","NOMBRES","APELLIDOS","GENERO","EDAD","FECHA","HORA","CLINICA","MEDICO","ESPECIALIDAD"}; 
       String []columnas2={"CODIGO","CLINICA"};
            DefaultTableModel modelo=new DefaultTableModel(columnas, 0){
            @Override
                public boolean isCellEditable(int filas, int columnas)
                {
                    if (columnas==10)
                    {
                        return true;
                    }else
                    {
                        return false;
                    }

                }
            };
            
         DefaultTableModel modelo2=new DefaultTableModel(columnas2, 0){
             @Override
            public boolean isCellEditable(int filas, int columnas)
            {
                if (columnas==3)
                {
                    return true;
                }else
                {
                    return false;
                }

            }
         
         };
    
    CitasDAO dao= new  CitasDAO();
         ClinicaDAO dao2= new ClinicaDAO();
    
      List<Citas> data= new ArrayList<>();
         List<Clinicas> data2= new ArrayList<>();
     
    Citas citas= new Citas();
        Clinicas clinic= new Clinicas();
    
    
    /**
     * Creates new form VistaCitas
     */
   
   //METODO PARA CARGAR EN JTABLE LAS CONSULTAS GUARDADAS
    public void cargarTabla ()
    {  tablaDatos.getTableHeader().setReorderingAllowed(false); //Para evitar que se puedan mover las columnas del JTable
        this.modelo.setRowCount(0);
        data.clear();
        data= (List<Citas>) dao.seleccionarCita();
        Object[]  obj = new Object[10];
        for (Citas fila : data)            
        {
          obj[0]=fila.getCodigo();
            obj[1]=fila.getNombresPaciente();
            obj[2]=fila.getApellidosPaciente();            
            obj[3]=fila.getGenero();  
            obj[4]=fila.getEdad(); 
            obj[5]=fila.getFechCita(); 
            obj[6]=fila.getHoraCita();            
            obj[7]=fila.getIdClinica().getNombClinica();                    
            obj[8]=fila.getMedico();
            obj[9]=fila.getEspecialidad();
                
           
           
           //cargar comboboxClinicas
            this.modelo.addRow(obj);    
        }          
         
        this.tablaDatos.setModel(modelo);
    }//FIN DE METODO PARA CARGAR EN JTABLE LAS CONSULTAS GUARDADAS
    
     //METODO PARA CARGAR LAS CLINICAS DISPONIBLES 
    public void cargarTablaClinicas ()
    {        
        tableClinicas.getTableHeader().setReorderingAllowed(false); //Para evitar que se puedan mover las columnas del JTable
        this.modelo2.setRowCount(0);
        data2.clear();
        data2= (List<Clinicas>) dao2.seleccionarClinica();
        Object[]  obj = new Object[6];
        for (Clinicas fila : data2)            
        {
            obj[0]=fila.getIdClinica();
            obj[1]=fila.getNombClinica();
                    
            this.modelo2.addRow(obj);
            
        }
        
        
        this.tableClinicas.setModel(modelo2);
    }//FIN DE METODO PARA CARGAR LAS CLINIAS DISPONIBLES
    
    //METODO PARA LIMPIAR LOS CAMPOS
    public void limpiar(){
        this.txtCodigo.setText("");
        this.txtNombres.setText("");
        this.txtApellidos1.setText("");
        this.rbF.setSelected(false);                     
        this.rbM.setSelected(false);  
        this.txtEdad.setText("");
        this.cmbHora.setSelectedIndex(0);
         this.cmbMedico.setSelectedIndex(0);
        this.cmbEspecialidad.setSelectedIndex(0);
        this.txtClinica.setText("");
        
    }//FIN DE METODO PARA LIMPIAR LOS CAMPOS
    
    
    
    
    
    public VistaCitas() {
        initComponents();
        setLocationRelativeTo(null);
        cargarTabla();
        cargarTablaClinicas();
        
      
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtClinica = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox<>();
        rbM = new javax.swing.JRadioButton();
        rbF = new javax.swing.JRadioButton();
        dateFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtApellidos1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableClinicas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbMedico = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cmbEspecialidad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CITAS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("AGENDAR CITAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Clinica");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel3.setText("Nombres");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 70, -1));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel4.setText("Apellidos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 40, 70, -1));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel5.setText("Genero");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

        txtCodigo.setEnabled(false);
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 63, 62, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 63, 120, -1));

        txtClinica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClinicaKeyTyped(evt);
            }
        });
        jPanel1.add(txtClinica, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 79, -1));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel9.setText("Codigo de cita");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, 100, -1));

        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 126, 62, -1));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel10.setText("Edad");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 103, 40, -1));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel11.setText("Fecha Cita");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 103, 80, -1));

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel12.setText("Hora Cita");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 103, 70, -1));

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "13:00", "13:30", "14:00", "14:30", "15:00" }));
        jPanel1.add(cmbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 126, -1, -1));

        buttonGroup1.add(rbM);
        rbM.setText("M");
        jPanel1.add(rbM, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 50, -1, -1));

        buttonGroup1.add(rbF);
        rbF.setText("F");
        jPanel1.add(rbF, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, -1, -1));
        jPanel1.add(dateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 126, 145, -1));

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 278, 930, 296));

        btnGuardar.setBackground(new java.awt.Color(51, 255, 51));
        btnGuardar.setFont(new java.awt.Font("Bahnschrift", 3, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 194, 98, 43));

        btnModificar.setBackground(new java.awt.Color(51, 255, 51));
        btnModificar.setFont(new java.awt.Font("Bahnschrift", 3, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 194, 97, 43));

        btnEliminar.setBackground(new java.awt.Color(51, 255, 51));
        btnEliminar.setFont(new java.awt.Font("Bahnschrift", 3, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 194, 89, 43));

        btnLimpiar.setBackground(new java.awt.Color(51, 255, 51));
        btnLimpiar.setFont(new java.awt.Font("Bahnschrift", 3, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 194, 102, 43));
        jPanel1.add(txtApellidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 63, 117, -1));

        jScrollPane2.setBorder(new javax.swing.border.MatteBorder(null));

        tableClinicas.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tableClinicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableClinicas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 6, 210, 180));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("<html><body>*Debe ingresar el codigo <br> de la clinica  que desea agendar  </body></html>");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel13.setText("Especialidad");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 90, -1));

        cmbMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- select -", "Bernardo Lopez", "Carlos Cetino", "Eggar Culajay", "Mario Villatoro", "Luis Diaz", "Engolo Cante", "Harry Kane", "Octaviano Camei", " ", " " }));
        cmbMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMedicoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 140, -1));

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel15.setText("Medico");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 60, -1));

        cmbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- select -", "Medico General", "Ginecologia", "Encologia", "Optometria", "Urologia", "Odontologia", "Neumologia", "Oncologia", "Radiologia" }));
        cmbEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEspecialidadActionPerformed(evt);
            }
        });
        jPanel1.add(cmbEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 150, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        
        if(txtNombres.getText().equals("")||txtApellidos1.getText().equals("")||txtEdad.getText().equals("")||txtClinica.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "No debe dejar campos vacios");
        }else{        
        this.citas.setNombresPaciente(this.txtNombres.getText()); 
        this.citas.setApellidosPaciente(this.txtApellidos1.getText()); 
        
        char genero=0;
        if (this.rbF.isSelected())
        {
            genero='F';
        }else if (this.rbM.isSelected())
        {
            genero='M';
        }
        this.citas.setGenero(genero);
        this.citas.setEdad(Integer.parseInt(this.txtEdad.getText()));
        Date fecNac= new java.sql.Date(dateFecha.getDate().getTime());
        
        this.citas.setFechCita(fecNac);
        
        this.citas.setHoraCita(this.cmbHora.getSelectedItem().toString()); 
        this.citas.setMedico(this.cmbMedico.getSelectedItem().toString()); 
        this.citas.setEspecialidad(this.cmbEspecialidad.getSelectedItem().toString()); 
        this.citas.setIdClinica(new Clinicas(Integer.parseInt(this.txtClinica.getText())));
        //this.citas.setIdClinica(Integer.parseInt(this.txtClinia.getText()));        

        
       if (dao.insertar_cita(this.citas)){
            JOptionPane.showMessageDialog(this,"Registro guardado correctamente!!");
            //refrescar la tabla
           cargarTabla(); 
           limpiar();
            
        }else
        {
            JOptionPane.showMessageDialog(this,"NO se ha guardado el registro");
        }
     }
        
        
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        // TODO add your handling code here:
        int fila = this.tablaDatos.getSelectedRow();
        this.txtCodigo.setText(tablaDatos.getValueAt(tablaDatos.getSelectedRow(),0).toString());
        this.txtNombres.setText(tablaDatos.getValueAt(tablaDatos.getSelectedRow(),1).toString());
        this.txtApellidos1.setText(tablaDatos.getValueAt(tablaDatos.getSelectedRow(),2).toString());
          if( String.valueOf(this.tablaDatos.getValueAt(fila, 3)).equals("F"))
        {     
             rbF.setSelected(true);  
        } else if( String.valueOf(this.tablaDatos.getValueAt(fila, 3)).equals("M")) {            
            rbM.setSelected(true);
             
          }
        this.txtEdad.setText(tablaDatos.getValueAt(tablaDatos.getSelectedRow(),4).toString());
        
        this.cmbHora.setSelectedItem(String.valueOf(this.tablaDatos.getValueAt(fila, 6)));
          this.cmbMedico.setSelectedItem(String.valueOf(this.tablaDatos.getValueAt(fila, 8)));
        this.cmbEspecialidad.setSelectedItem(String.valueOf(this.tablaDatos.getValueAt(fila, 9)));
        
        
        
        Date fecNac= new java.sql.Date(dateFecha.getDate().getTime());
        
        
        
    }//GEN-LAST:event_tablaDatosMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // TODO add your handling code here:
        
        if(txtNombres.getText().equals("")||txtApellidos1.getText().equals("")||txtEdad.getText().equals("")||txtClinica.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Hay campos incompletos");
        }else{   
        this.citas.setNombresPaciente(this.txtNombres.getText()); 
        this.citas.setApellidosPaciente(this.txtApellidos1.getText()); 
        
        char genero=0;
        if (this.rbF.isSelected())
        {
            genero='F';
        }else if (this.rbM.isSelected())
        {
            genero='M';
        }
        this.citas.setGenero(genero);
        this.citas.setEdad(Integer.parseInt(this.txtEdad.getText()));
        Date fecNac= new java.sql.Date(dateFecha.getDate().getTime());
        
        this.citas.setFechCita(fecNac);
        
        this.citas.setHoraCita(this.cmbHora.getSelectedItem().toString());
        this.citas.setMedico(this.cmbMedico.getSelectedItem().toString());
        this.citas.setEspecialidad(this.cmbEspecialidad.getSelectedItem().toString());
        this.citas.setIdClinica(new Clinicas(Integer.parseInt(this.txtClinica.getText())));
        this.citas.setCodigo(Integer.parseInt(this.txtCodigo.getText()));
        
        
       if (dao.modificar_cita(this.citas)){
            JOptionPane.showMessageDialog(this,"Modificado correctamente!!");
            //refrescar la tabla
            cargarTabla(); 
            limpiar();
            
        }else
        {
            JOptionPane.showMessageDialog(this,"Ocurrio un error al modificar");
        }
        
        
        }
        
        
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // TODO add your handling code here:
        if(txtNombres.getText().equals("")||txtApellidos1.getText().equals("")||txtEdad.getText().equals("")||txtClinica.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Hay campos incompletos");
        }else{   
        this.citas.setNombresPaciente(this.txtNombres.getText()); 
        this.citas.setApellidosPaciente(this.txtApellidos1.getText()); 
        
        char genero=0;
        if (this.rbF.isSelected())
        {
            genero='F';
        }else if (this.rbM.isSelected())
        {
            genero='M';
        }
        this.citas.setGenero(genero);
        this.citas.setEdad(Integer.parseInt(this.txtEdad.getText()));
        Date fecNac= new java.sql.Date(dateFecha.getDate().getTime());
        
        this.citas.setFechCita(fecNac);
        
        this.citas.setHoraCita(this.cmbHora.getSelectedItem().toString()); 
        this.citas.setMedico(this.cmbMedico.getSelectedItem().toString()); 
        this.citas.setEspecialidad(this.cmbEspecialidad.getSelectedItem().toString()); 
        this.citas.setIdClinica(new Clinicas(Integer.parseInt(this.txtClinica.getText())));
        this.citas.setCodigo(Integer.parseInt(this.txtCodigo.getText()));
        
        
       

        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el registro?", "Advertencia!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (resp==JOptionPane.YES_OPTION)
            {
                 if (dao.eliminar_cita(this.citas)){
                    JOptionPane.showMessageDialog(this,"El registro se ha eliminado!!");
                    //refrescar la tabla
                   cargarTabla();             
        }else
        {
            JOptionPane.showMessageDialog(this,"Ha ocurrido un erro al eliminar");
        }
                
                
            }
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        // TODO add your handling code here:
        
        char validar =evt.getKeyChar();
        
        if (Character.isLetter(validar))
        {
                getToolkit().beep();
                evt.consume();
          JOptionPane.showMessageDialog(this,"Solo numeros");
                
        }
        if (txtEdad.getText().length()== 3) 

         evt.consume(); 
    }//GEN-LAST:event_txtEdadKeyTyped

    private void txtClinicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClinicaKeyTyped
        // TODO add your handling code here:
         char validar =evt.getKeyChar();
        
        if (Character.isLetter(validar))
        {
                getToolkit().beep();
                evt.consume();
          JOptionPane.showMessageDialog(this,"Solo numeros");
                
        }
    }//GEN-LAST:event_txtClinicaKeyTyped

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Inicio.frmCitas=null;
    }//GEN-LAST:event_formWindowClosing

    private void cmbMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMedicoActionPerformed

    private void cmbEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEspecialidadActionPerformed
        
    }//GEN-LAST:event_cmbEspecialidadActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbEspecialidad;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbMedico;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbF;
    private javax.swing.JRadioButton rbM;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTable tableClinicas;
    private javax.swing.JTextField txtApellidos1;
    private javax.swing.JTextField txtClinica;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
