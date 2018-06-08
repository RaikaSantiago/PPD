package ppd;

import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ppd.ProyectoProgramacionDinamica;
/*
   UNIVERSIDAD DEL VALLE
   FACULTAD DE INGENIERIA
   MATERIA FADA, TEMA OPTIMIZACIÓN
   PROYECTO JUSTIFICACIÓN DE TEXTO 
   
   Integrantes:
        Santiago Rivera Escobar ? 1664066
        Cristian Correa Serna - 1556137
        Víctor Hugo Romero García ? 1663967
*/
public class Ventana extends javax.swing.JFrame {

    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    File direccion;

    public Ventana() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/uni.PNG")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TextoArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        Costo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        InAncho = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CSUR = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Autores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Justificador De Texto");
        setName("Justificador De Texto"); // NOI18N

        TextoArea.setEditable(false);
        TextoArea.setColumns(20);
        TextoArea.setRows(5);
        jScrollPane1.setViewportView(TextoArea);

        jButton1.setText("Cargar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Costo.setEditable(false);
        Costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostoActionPerformed(evt);
            }
        });

        jLabel1.setText("  Costo Minimo Con El Ultimo Renglón  ");

        InAncho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InAnchoActionPerformed(evt);
            }
        });

        jLabel3.setText("Ancho Del Renglón:");

        jButton2.setText("Limpiar Cuadros");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("   Costo Minimo Sin El Ultimo Renglón  ");

        CSUR.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setText("JUSTIFICADOR DE TEXTO ");

        Autores.setText("Autores");
        Autores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel5))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(CSUR, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jButton1)))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Autores)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(InAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(CSUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(Autores))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String[] Dato = null;
        ProyectoProgramacionDinamica awl = new ProyectoProgramacionDinamica();

        try {
            int ancho = Integer.parseInt(InAncho.getText());
            if (ancho <= 0 || InAncho.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Llene el campo del ancho con un valor numerico mayor a cero", "Mensaje de Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
                    archivo = seleccionar.getSelectedFile();

                    if (archivo.canRead()) {
                        if (archivo.getName().endsWith("txt")) {

                            Dato = awl.LeerArchivo(archivo);
                            String Palabra = awl.LongitudMaximaString(Dato);
                            int Maximo = Palabra.length();
                            
                            if (ancho < Maximo) {
                                String nl = System.getProperty("line.separator");
                                JOptionPane.showMessageDialog(null, "Se encontro una palabra que excede el ancho del renglón solicitado."
                                        + nl + "                 La palabra es: " + Palabra + " Y Mide:  " + Maximo + nl
                                        + "                     Por favor  aumente el ancho del renglón.", "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                TextoArea.setText(awl.Justificar(Dato, ancho, 1));
                                int gb = Integer.parseInt(awl.Justificar(Dato, ancho, 0));
                                Costo.setText(String.valueOf(gb));

                                int gb1 = Integer.parseInt(awl.Justificar(Dato, ancho, 2));
                                CSUR.setText(String.valueOf(gb1));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Archivo no compatible", "Mensaje de Advertencia", JOptionPane.WARNING_MESSAGE);

                        }
                    }
                }
            }
        } catch (Exception e) {
            String nl = System.getProperty("line.separator");
            JOptionPane.showMessageDialog(null, "ERROR" + nl + "El campo del ancho debe ser un valor numerico." + nl + "El archivo no debe estar vacio.", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void CostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostoActionPerformed

    }//GEN-LAST:event_CostoActionPerformed

    private void InAnchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InAnchoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InAnchoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Costo.setText("");
        InAncho.setText("");
        TextoArea.setText("");
        CSUR.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoresActionPerformed
        String nl = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null,"Santiago Rivera Escobar Código:1664066"+nl
                +"Cristian Correa Serna Código:1556137"+nl
                +"Víctor Hugo Romero García Código:1663967"+nl
                +"        Todos los derechos reservados", "Autores", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_AutoresActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Autores;
    private javax.swing.JTextField CSUR;
    private javax.swing.JTextField Costo;
    private javax.swing.JTextField InAncho;
    private javax.swing.JTextArea TextoArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
