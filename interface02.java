

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
public class interface02 extends javax.swing.JFrame {
    private int LineNo = 1;
    private int sumInheritance = 0;
    File ff;
    private int sumControl = 0;
    private int sumNested = 0;
    private int count=0;
    private int sum=1;
    private int SUM=0;
    private int Ccs=0;
    private int z=0;
    private int h=0;
    private int x=0;
    private int k=0;
    private int sumCcspps=0;
    private int sumCcs=0;
    
    private int Total=0;
    private int sum1=0;private int sum2=0;private int sum3=0;
    
    String one;
    String two;
    String three;
    String four;
    
    public interface02(String val1, String val2, String val3, String val4){
        initComponents();
        this.one   = val1;
        this.two   = val2;
        this.three = val3;
        this.four  = val4;
    }
    public interface02() {
        
        initComponents();
        jTableDesign();
        this.ff = ff;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);        
    }
    
    public interface02(String val){
        initComponents();
        this.one=val;
    }
    public interface02(File ff) throws IOException {
        initComponents();
        this.ff = ff;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        jTableDesign();
       

        setTableData(ff);
        lineArray();//call that array method in Jframe interface
        condition(ff);
        
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
        int Nc =0;
        int Ccspps=0;
        int Ccs=0;
        FileReader fr = new FileReader(ff);
        BufferedReader br = new BufferedReader(fr);
              
        String strCurrentLine=null;
        strCurrentLine = br.readLine();
       
        while ((strCurrentLine = br.readLine()) != null) {
          
            for(int i=0;i<strCurrentLine.length();i++)
            {
               
            if(strCurrentLine.trim().startsWith("for")||strCurrentLine.trim().startsWith("while")||strCurrentLine.trim().startsWith("do-while")||strCurrentLine.trim().startsWith("}do-while")||strCurrentLine.trim().startsWith("}for")||strCurrentLine.trim().startsWith("}while"))
            {
                Wtcs=3;                
            }
            else if(strCurrentLine.trim().startsWith("if")||strCurrentLine.trim().startsWith("else if")||strCurrentLine.trim().startsWith("switch")||strCurrentLine.trim().startsWith("else-if")||strCurrentLine.trim().startsWith("}if")||strCurrentLine.trim().startsWith("}else if")||strCurrentLine.trim().startsWith("}switch"))
            {
                Wtcs=2;
            }            
            else if(strCurrentLine.trim().startsWith("case")||strCurrentLine.trim().startsWith("}case"))
            {
                Wtcs=1;
            }
            else{
                
                Wtcs=0;
                                
                }
            
            }                                                                 

        int total = 0;
        
        total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("(?<!\\w)if(?!\\w)", "").length()
                ) / 2);
        
        
            if((strCurrentLine.trim().startsWith("//"))) // 'comment' detected
            {
                total=0;
            }
             else if(total > 0||(strCurrentLine.trim().startsWith("if"))||strCurrentLine.trim().startsWith("}")||strCurrentLine.trim().startsWith("while")||strCurrentLine.trim().startsWith("}while")||strCurrentLine.trim().startsWith("}if")) // 'if' detected
            {            
            //Detecting &&
                total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("&&", "").length()) / 2);
            //Detecting &
                total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("(?<!&)&(?![&=])", "").length()));
            //Detecting ||
                total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("\\|\\|", "").length()) / 2);
            //Detecting |
                total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("(?<!\\|)\\|(?!\\|)", "").length()));
            
            //System.out.println(total);
                 
            }
            else if(total > 0||(strCurrentLine.trim().startsWith("for"))||(strCurrentLine.trim().startsWith("while"))) // 'for' & 'while' detected 
            {
                total=1;
            }
        
         for(int i=0;i<CTable.getRowCount();i++){
             int sumNc;
             int sum;
             int current;
             int sumCcspps1;
             int sumCcs1;
            //remove the comment line on the code
             if (strCurrentLine.trim().length() != 0) {
                    System.out.println(strCurrentLine);
                    strCurrentLine = strCurrentLine.trim();

                }
                if (strCurrentLine.contains("//")) {
                    System.out.println(strCurrentLine.substring(0, strCurrentLine.indexOf("//")));
                    strCurrentLine = strCurrentLine.substring(0, strCurrentLine.indexOf("//"));
                    
                }
                current = Integer.parseInt(CTable.getValueAt(i,2).toString());
                int current2=current-1;
                String str=String.valueOf(current2);
                sumNc  = Integer.parseInt(CTable.getValueAt(i,3).toString());
                //sumCcspps=(Integer.parseInt(CTable.getValueAt(i,2).toString())+Integer.parseInt(CTable.getValueAt(i,3).toString()));
                //sumCcs=Integer.parseInt(CTable.getValueAt(i,5).toString());
                //sumCcspps=Integer.parseInt(CTable.getValueAt(i,3).toString());
                
               
               /*
                strCurrentLine = br.readLine();
                String check;
                int check2=0;
                int check3;
                check3=Integer.parseInt(strCurrentLine);
                check2 = check3-1;
                for(int i=0;)
                int k=strCurrentLine.indexOf(i)
                String strCurrentLine2=String.valueOf(check2);
               /*
                int check4=0;
                check4 = check3-2;
                String strCurrentLine3=String.valueOf(check4);
                */
                
                   
                  
                    sumCcspps=Wtcs*total;    
                    sumCcs=((Wtcs*total)+sumCcspps);
                    
                    System.out.println(i+".."+Ccspps+".."+Ccs);
                  //System.out.println(Ccspps);                   
                    //}
                    //else if(strCurrentLine2.contains("{")||strCurrentLine2.contains("if")){
                        //sumCcspps;
                    //}
                              
         }
         
            
            Object[] row = {LineNo++, strCurrentLine, Wtcs, total, sumCcspps,sumCcs };            
            model.addRow(row);            
        }
        return this.sumControl;
     }
     public void  setWeightData(File ff) throws IOException {
         
        weight ne =new  weight();
        DefaultTableModel model = (DefaultTableModel) CTable.getModel();
        int Wtcs = 0;
        int Nc =0;
        int Ccspps=0;
        int Ccs=0;
        FileReader fr = new FileReader(ff);
        BufferedReader br = new BufferedReader(fr);
              
        String strCurrentLine=null;
        strCurrentLine = br.readLine();
       
        while ((strCurrentLine = br.readLine()) != null) {
          
            for(int i=0;i<strCurrentLine.length();i++)
            {
               
            if(strCurrentLine.trim().startsWith("for")||strCurrentLine.trim().startsWith("while")||strCurrentLine.trim().startsWith("do-while"))
            {
                //Wtcs=Integer.parseInt(FWD.getText());                
            }
            else if(strCurrentLine.trim().startsWith("if")||strCurrentLine.trim().startsWith("else if")||strCurrentLine.trim().startsWith("switch"))
            {
                ///Wtcs=Integer.parseInt(EIF.getText()); 
            }            
            else if(strCurrentLine.trim().startsWith("case"))
            {
               // Wtcs=Integer.parseInt(CaseV.getText()); 
            }
            else{
                
                //Wtcs=0;
                                
                }
            
            }                                                                 
            Object[] row = {LineNo++, strCurrentLine, Wtcs, null, Ccspps,Ccs };            
            model.addRow(row);      
        }
     }
     
     
     
/*
     public void Ccs(File ff) throws FileNotFoundException{
      DefaultTableModel model = (DefaultTableModel) CTable.getModel();
          FileReader fr = new FileReader(ff);
          BufferedReader br = new BufferedReader(fr);
          String strCurrentLine;
          int z=0;
          for(int y=0;y<CTable.getRowCount();y++)
          {
              z=Integer.parseInt(CTable.getValueAt(y, 3).toString());
              h=z=Integer.parseInt(CTable.getValueAt(y, 3).toString());
          }
          Object[] row = {null, null, null, sum, null, z};

     }
     */
     public void condition(File ff) throws FileNotFoundException, IOException{
          CharSequence nc="&&";
          DefaultTableModel model = (DefaultTableModel) CTable.getModel();
          FileReader fr = new FileReader(ff);
          BufferedReader br = new BufferedReader(fr);
          String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                if(strCurrentLine.contentEquals(nc))
                {
                    for(int i=0; i<strCurrentLine.length();i++)
                    {
                        if(strCurrentLine.contentEquals(nc)){
                        count++;
                        sum=count+1;
                        }
                    }
                    
                    Object[] row = {null, null, null, sum, null, null};

                    model.addRow(row);  
                }
                
                else{
                    count=0;
                }
              }
            }
          
     private void lineArray() throws FileNotFoundException, IOException {
        Scanner file = new Scanner(ff);// Path to the scanning file
        ArrayList<String> lineArray = new ArrayList<String>();

        while (file.hasNextLine()) {
            lineArray.add(file.nextLine());
        }

        file.close();

        String[] stringArray = lineArray.toArray(new String[lineArray.size()]);

     //   sizeComplexity(stringArray);
      // controlComplexity(stringArray);
       // nestedLevelComplexity(lineArray);

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
        jLabel1.setText(" Control structure");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 90, 330, 42);

        CTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line no ", "Program statements", "Wtcs ", "NC ", "Ccspps", "Ccs "
            }
        ));
        jScrollPane1.setViewportView(CTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 200, 1060, 450);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Weight");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(950, 110, 180, 35);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/world.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1540, 750);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new interface01().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void reset(){
        
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new weight().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed
    
    
    
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
