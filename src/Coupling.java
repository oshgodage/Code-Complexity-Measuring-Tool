
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.Expression;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oshad
 */
public class Coupling extends javax.swing.JFrame {

    private int LineNo = 1;
    private int sumInheritance = 0;
    File ff;
    private int sumControl = 0;
    private int sumNested = 0;
    private int count = 0;
    private int sum = 1;
    private int SUM = 0;
    private int Ccs = 0;
    private int z = 0;
    private int h = 0;
    private int x = 0;
    private int k = 0;

    private int Total = 0;
    private int sum1 = 0;
    private int sum2 = 0;
    private int sum3 = 0;

    String one;
    String two;
    String three;
    String four;

    public Coupling(String val1, String val2, String val3, String val4) {
        initComponents();
        this.one = val1;
        this.two = val2;
        this.three = val3;
        this.four = val4;
    }

    public Coupling() {

        initComponents();
        jTableDesign();
        this.ff = ff;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
    }

    public Coupling(String val) {
        initComponents();
        this.one = val;
    }

    public Coupling(File ff) throws IOException {
        initComponents();
        this.ff = ff;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        jTableDesign();

        setTableData(ff);
     

        //Ccs(ff);
    }

    public int getSumControl() {
        return sumControl;
    }

    public int getSumNested() {
        return sumNested;
    }

    private void jTableDesign() {
        CTable.setRowHeight(40);
        CTable.setShowGrid(true);
        CTable.setGridColor(new Color(153, 153, 255));
        CTable.setSelectionBackground(Color.DARK_GRAY);

        JTableHeader tableHeader = CTable.getTableHeader();
        tableHeader.setBackground(new Color(153, 153, 255));
        tableHeader.setForeground(Color.BLACK);
        tableHeader.setPreferredSize(new Dimension(70, 70));
        tableHeader.setFont(new Font("Arial", Font.BOLD, 12));
    }

    public int setTableData(File ff) throws IOException {
        DefaultTableModel model = (DefaultTableModel) CTable.getModel();
        int Wtcs = 0;
        //Coupling Variables
        int Nr = 0;
        int Nmcms = 0;
        int Nmcmd = 0;
        int Nmcrms = 0;
        int Nmcrmd = 0;
        int Nrmcrms = 0;
        int Nrmcrmd = 0;
        int Nrmcms = 0;
        int Nrmcmd = 0;
        int Nmrgvs = 0;
        int Nmrgvd = 0;
        int Nrmrgvs = 0;
        int Nrmrgvd = 0;
        int Ccp = 0;
        int Tcp = 0;
        FileReader fr = new FileReader(ff);
        BufferedReader br = new BufferedReader(fr);

        String strCurrentLine = null;
        strCurrentLine = br.readLine();

        while ((strCurrentLine = br.readLine()) != null) {

            //String REGEX = ".*private(.*?).*.*";
           // Pattern regex = Pattern.compile(REGEX);
             //String lines = "";
        // Matcher regexMatcher = regex.matcher(strCurrentLine);
        
            //code for NR[number of recursive call)
            for (int i = 0; i < strCurrentLine.length(); i++) {
                  
               if (strCurrentLine.trim().matches(".*(set|return|get).*")) {
                    Nr=4;
                   
                      //System.out.println("matches = " + s);
               }
               else {
                   Nr=1;
               }
                       
                if(strCurrentLine.trim().matches(".*(set|return|get).*")){
                    Nmcms=2;
                }
                else{
                    Nmcms= 0;
                }
                
                  if(strCurrentLine.trim().matches(".*\\b((void|int|double|String)(\\s+|\\().*\\{).*")){
                    Nmcrms=2;
                }
                else{
                    Nmcrms= 0;
                }
                  
                if(strCurrentLine.trim().matches(".*\\b((void|int|double|String)(\\s+|\\().*\\{).*")){
                    Nrmcrms=2;
                }
                else{
                    Nrmcrms= 0;
                }  
                
                    if(strCurrentLine.trim().matches(".*\\b((void|int|double|String)(\\s+|\\().*\\{).*")){
                    Nrmcms=2;
                }
                else{
                    Nrmcms= 0;
                } 
                     if(strCurrentLine.trim().matches(".*private|public(.*?).*.*")){
                    Nmrgvs=2;
                }
                else{
                    Nmrgvs= 0;
                } 
                     
                  if(strCurrentLine.trim().matches(".*private|public int \\s*(\\S+).*")){
                    Nrmrgvs=2;
                }
                else{
                    Nrmrgvs= 0;
                }
                     
                  
                       
            }

             if (strCurrentLine.trim().length() != 0) {
                    System.out.println(strCurrentLine);
                    strCurrentLine = strCurrentLine.trim();

                }
                if (strCurrentLine.contains("//")) {
                    System.out.println(strCurrentLine.substring(0, strCurrentLine.indexOf("//")));
                    strCurrentLine = strCurrentLine.substring(0, strCurrentLine.indexOf("//"));
                    
                }
           

            Object[] row = {LineNo++, strCurrentLine, Nr, Nmcms, Nmcmd, Nmcrms,Nmcrmd,Nrmcrms,Nrmcrmd,Nrmcms,Nrmcmd,Nmrgvs,Nmrgvd,Nrmrgvs,Nrmrgvd,Ccp };
            model.addRow(row);
        }
        return this.sumControl;
    }

    public void setWeightData(File ff) throws IOException {

        weight ne = new weight();
        DefaultTableModel model = (DefaultTableModel) CTable.getModel();
        int Wtcs = 0;
        int Nc = 0;
        int Ccspps = 0;
        int Ccs = 0;
        FileReader fr = new FileReader(ff);
        BufferedReader br = new BufferedReader(fr);

        String strCurrentLine = null;
        strCurrentLine = br.readLine();

        while ((strCurrentLine = br.readLine()) != null) {

            for (int i = 0; i < strCurrentLine.length(); i++) {

                if (strCurrentLine.trim().startsWith("for") || strCurrentLine.trim().startsWith("while") || strCurrentLine.trim().startsWith("do-while")) {
                    //Wtcs=Integer.parseInt(FWD.getText());                
                } else if (strCurrentLine.trim().startsWith("if") || strCurrentLine.trim().startsWith("else if") || strCurrentLine.trim().startsWith("switch")) {
                    ///Wtcs=Integer.parseInt(EIF.getText()); 
                } else if (strCurrentLine.trim().startsWith("case")) {
                    // Wtcs=Integer.parseInt(CaseV.getText()); 
                } else {

                    Wtcs = 0;

                }

            }
            Object[] row = {LineNo++, strCurrentLine, Wtcs, null, Ccspps, Ccs};
            //model.addRow(row);      
        }
    }
  

 

    /*
     
     }
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backSmall.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 20, 60, 40);

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Coupling");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 90, 330, 42);

        CTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line no ", "Program statements", "Nr", "Nmcms", "Nmcmd", "Nmcrms ", "Nmcrmd", "Nrmcrms", "Nrmcrmd", "Nrmcms", "Nrmcmd", "Nmrgvs", "Nmrgvd", "Nrmrgvs", "Nrmrgvd", "Ccp"
            }
        ));
        jScrollPane1.setViewportView(CTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 180, 1060, 450);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Weight");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(950, 100, 180, 35);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/world.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, -70, 1430, 800);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Complexity");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(840, 100, 180, 35);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Complexity");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(840, 100, 180, 35);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new interface01().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void reset() {

    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Couplingweight().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(interface02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interface02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interface02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interface02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interface02().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
