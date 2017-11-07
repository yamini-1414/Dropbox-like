/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*<?php 
require_once("http://localhost:8080/TermProject/upload.php");
$System = java("java.lang.System");
echo $System->getProperties();
?>*/
package texteditor;

import javax.swing.JFrame;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import texteditor.TextEditorFrame;

/**
 *
 * @author VARSHA RANI
 */
class TextEditorFrame extends javax.swing.JFrame {

    /**
     * Creates new form TextEditorFrame
     */
    public TextEditorFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        quitButton = new javax.swing.JButton();
        statusField = new javax.swing.JTextField();
        saveAsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        saveButton.setText(" Save As");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textArea);

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        statusField.setEditable(false);

        saveAsButton.setText("Save");
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton)
                        .addGap(10, 10, 10)
                        .addComponent(saveAsButton)
                        .addGap(18, 18, 18)
                        .addComponent(quitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusField, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(saveButton)
                    .addComponent(saveAsButton)
                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
    System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        int chooserValue = chooser.showSaveDialog(this);
        if(chooserValue == JFileChooser.APPROVE_OPTION)
        {
            try {
                PrintWriter fout = new PrintWriter(chooser.getSelectedFile());
                fout.print(textArea.getText());
                fout.close();
                statusField.setText("Saved " + chooser.getSelectedFile().getAbsolutePath());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
    }//GEN-LAST:event_saveButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        int chooserValue = chooser.showOpenDialog(this);
        if(chooserValue == JFileChooser.APPROVE_OPTION)
        {
            try{
                Scanner fin = new Scanner(chooser.getSelectedFile());
                String buffer = "";
                while(fin.hasNext())
                {
                    buffer += fin.nextLine() + "\n";
                }
                textArea.setText(buffer);
                fin.close();
                statusField.setText("Loaded " + chooser.getSelectedFile().getAbsolutePath());
            } 
            catch (FileNotFoundException ex) {
               JOptionPane.showMessageDialog(this, "File not Found!");
            }
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void saveAsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        Component modalToComponent = null;
        if (chooser.showSaveDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
        File file = chooser.getSelectedFile();
  
}
    }//GEN-LAST:event_saveAsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextEditorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton saveAsButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField statusField;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}

public class TextEditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextEditorFrame frame = new TextEditorFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
