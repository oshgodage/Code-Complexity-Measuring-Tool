import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author User
 */
public class Variable extends javax.swing.JFrame {
    private int LineNo = 1;
    private int count = 0;
    private int Cs = 0;
    private int Cv = 0;
    private int sum = 1;
    private int sumControl = 0;
    //private String line;
    private File ff;
    
    String one;
    String two;
    String three;
    String four;
    
    /**
     * Creates new form Size
     */
    
    public Variable(String val1, String val2, String val3, String val4){
        initComponents();
        this.one   = val1;
        this.two   = val2;
        this.three = val3;
        this.four  = val4;
    }
    
    public Variable() {
        initComponents();
        jTableDesign();
        this.ff = ff;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);        
    }
    
    public Variable(String val){
        initComponents();
        this.one=val;
    }
    
    public int getSumControl() {
        return sumControl;
    }
    
    public Variable(File ff) throws IOException {
        initComponents();
        this.ff = ff;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        jTableDesign();
       
        setTableData(ff);
        lineArray();
        condition(ff);
        //Cs(ff);
    }
    
    private void jTableDesign() {
        Vtable.setRowHeight(40);
        Vtable.setShowGrid(true);
        Vtable.setGridColor(new Color(153, 153, 255));
        Vtable.setSelectionBackground(Color.DARK_GRAY);

        JTableHeader tableHeader = Vtable.getTableHeader();
        tableHeader.setBackground(new Color(153, 153, 255));
        tableHeader.setForeground(Color.BLACK);
        tableHeader.setPreferredSize(new Dimension(70, 70));
        tableHeader.setFont(new Font("Arial", Font.BOLD, 12));
    }
   
     public int setTableData(File ff) throws IOException {
        DefaultTableModel model = (DefaultTableModel) Vtable.getModel();
        
        int Wvs = 0;
        int Npdtv = 0;
        int Ncdtv = 0;
        int Wpdtv = 0;
        int Wcdtv = 0;
        int Cv = 0;
        
        int variableCount = 0;
        
       FileReader fr = new FileReader(ff);
       //BufferedReader br = new BufferedReader(new FileReader("code.txt"));
       BufferedReader br = new BufferedReader(fr);
        
        
        String strCurrentLine = null;
        strCurrentLine = br.readLine();
       
        while ((strCurrentLine = br.readLine()) != null) {
            for(int i=0;i<strCurrentLine.length();i++)
            {
               
            if(strCurrentLine.trim().startsWith("for")||strCurrentLine.trim().startsWith("while")||strCurrentLine.trim().startsWith("do-while"))
            {
                //Cs=3;                
            }
            else if(strCurrentLine.trim().startsWith("if")||strCurrentLine.trim().startsWith("else if")||strCurrentLine.trim().startsWith("switch"))
            {
                //Cs=2;
            }            
            else if(strCurrentLine.trim().startsWith("case"))
            {
                //Cs=1;
            }
            else{
                
                //Cs=0;
            }
        
        }
        
        int total = 0;
        
        total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("(?<!\\w)if(?!\\w)", "").length()) / 2);
        if(strCurrentLine.trim().startsWith("if")){
            //(total > 0)  // 'if' detected
            {            
            //Detecting &&
                //total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("&&", "").length()) / 2);
            //Detecting &
                //total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("(?<!&)&(?![&=])", "").length()));
            //Detecting ||
                //total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("\\|\\|", "").length()) / 2);
            //Detecting |
                //total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("(?<!\\|)\\|(?!\\|)", "").length()));
            
            //System.out.println(total);
            }  
        }
        else
        {
                //System.out.println("No");
        }
        
        for(int i=0;i<Vtable.getRowCount();i++){
                int sumvariableCount = 0;
             
                if (strCurrentLine.trim().length() != 0) {
                    System.out.println(strCurrentLine);
                    strCurrentLine = strCurrentLine.trim();

                }
                if (strCurrentLine.contains("//")) {
                    System.out.println(strCurrentLine.substring(0, strCurrentLine.indexOf("//")));
                    strCurrentLine = strCurrentLine.substring(0, strCurrentLine.indexOf("//"));
                    
                }  
        }
         
            variable_1 v = new variable_1();
            //int Cv;
            Cv = (Integer)v.variableCount(strCurrentLine).get(0) * ((1 * (Integer)v.variableCount(strCurrentLine).get(1)) + (2 * (Integer)v.variableCount(strCurrentLine).get(2)));
            Object[] row = {LineNo++, strCurrentLine, v.variableCount(strCurrentLine).get(0), v.variableCount(strCurrentLine).get(1), v.variableCount(strCurrentLine).get(2), Cv};            
            model.addRow(row);            
        }
        return this.sumControl;
        
    }   
        
    public void Cs(File ff) throws FileNotFoundException{
          DefaultTableModel model = (DefaultTableModel) Vtable.getModel();
          ArrayList<String> lineArray = new ArrayList<String>();
          Object row[] = new Object[6];
          FileReader fr = new FileReader(ff);
          BufferedReader br = new BufferedReader(fr);
          String strCurrentLine;
          int z=0;
          
          for(int y=0;y<Vtable.getRowCount();y++)
          {
              //object[] row = lineArray.get(y).v.variableCount(strCurrentLine);
              model.addRow(row);
              //z=Integer.parseInt(STable.getValueAt(y, 3).toString());
              //h=z=Integer.parseInt(STable.getValueAt(y, 3).toString());
          }
          
    }
     
     public void condition(File ff) throws FileNotFoundException, IOException{
          CharSequence nc = "&&";
          DefaultTableModel model = (DefaultTableModel) Vtable.getModel();
          FileReader fr = new FileReader(ff);
          BufferedReader br = new BufferedReader(fr);
          String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                if(strCurrentLine.contentEquals(nc))
                {
                    for(int i=0; i<strCurrentLine.length();i++)
                    {
                        if(strCurrentLine.contentEquals(nc)){
                            //int count = 0;
                        //count++;
                            //int Cs = count+1;
                            count++;
                            sum=count+1;
                        }
                    }
                    
                    Object[] row = {null, null, null, null};
                    
                    model.addRow(row);  
                }
                
                else{
                    count = 0;
                    
                }
            }
     }    
          
     private void lineArray() throws FileNotFoundException, IOException {
        Scanner file = new Scanner(ff);// Path to the scanning file
        ArrayList<String> lineArray = new ArrayList<String>();

        while (file.hasNextLine()) {
            lineArray.add(file.nextLine());
        }
        
        //System.out.print(ff);

        file.close();

        String[] stringArray = lineArray.toArray(new String[lineArray.size()]);

    }   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Vtable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(null);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Weight");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel1.add(jButton4);
        jButton4.setBounds(950, 90, 180, 35);

        Vtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line no", "Program Statements", "Wvs", "Npdtv", "Ncdtv", "Cv"
            }
        ));
        jScrollPane1.setViewportView(Vtable);

        panel1.add(jScrollPane1);
        jScrollPane1.setBounds(80, 190, 1049, 442);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backSmall.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel1.add(jButton1);
        jButton1.setBounds(40, 20, 60, 40);

        jLabel2.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Variable");
        panel1.add(jLabel2);
        jLabel2.setBounds(90, 90, 210, 42);

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/world.jpg"))); // NOI18N
        panel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1290, 800);
        jLabel1.getAccessibleContext().setAccessibleName("Variables");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Weight2().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new interface01().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Size.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Variable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Vtable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
