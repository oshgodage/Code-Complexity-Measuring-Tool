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
public class Size extends javax.swing.JFrame {
    private int LineNo = 1;
    private int count = 0;
    private int Cs = 0;
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
    
    public Size(String val1, String val2, String val3, String val4){
        initComponents();
        this.one   = val1;
        this.two   = val2;
        this.three = val3;
        this.four  = val4;
    }
    
    public Size() {
        initComponents();
        jTableDesign();
        this.ff = ff;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);        
    }
    
    public Size(String val){
        initComponents();
        this.one=val;
    }
    
    public int getSumControl() {
        return sumControl;
    }
    
    public Size(File ff) throws IOException {
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
        Stable.setRowHeight(40);
        Stable.setShowGrid(true);
        Stable.setGridColor(new Color(153, 153, 255));
        Stable.setSelectionBackground(Color.DARK_GRAY);

        JTableHeader tableHeader = Stable.getTableHeader();
        tableHeader.setBackground(new Color(153, 153, 255));
        tableHeader.setForeground(Color.BLACK);
        tableHeader.setPreferredSize(new Dimension(70, 70));
        tableHeader.setFont(new Font("Arial", Font.BOLD, 12));
    }
   
     public int setTableData(File ff) throws IOException {
        DefaultTableModel model = (DefaultTableModel) Stable.getModel();
        
        int Nkw = 0;
        int Nid = 0;
        int Nop = 0;
        int Nnv = 0;
        int Nsl = 0;
        int Wkw = 0;
        int Wid = 0;
        int Wop = 0;
        int Wnv = 0;
        int Wsl = 0;
        
       FileReader fr = new FileReader(ff);
       //BufferedReader br = new BufferedReader(new FileReader("code.txt"));
       BufferedReader br = new BufferedReader(fr);
        
        
        String strCurrentLine = null;
        strCurrentLine = br.readLine();
        //Interface n = new Interface();
        //String type = n.type();
        //while ((strCurrentLine = br.readLine()) != null && !strCurrentLine.trim().startsWith("import") ) {
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
        
        //int total = 0;
        
        //total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("(?<!\\w)if(?!\\w)", "").length()) / 2);
        if(strCurrentLine.trim().startsWith("if")){
            //if(total > 0)  // 'if' detected
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
        //else
        {
                //System.out.println("No");
        }
        
        for(int i=0;i<Stable.getRowCount();i++){
             int sumNkw = 0;
             int sumNid = 0;
             int sumNop = 0;
             int sumNnv = 0;
             int sumNsl = 0;
            
            
                /*sumkeywordCount = Integer.parseInt(Stable.getValueAt(i,2).toString());
                sumidentifierCount = Integer.parseInt(Stable.getValueAt(i,3).toString());
                sumoperatorCount = Integer.parseInt(Stable.getValueAt(i,4).toString());
                sumnumericalValueCount = Integer.parseInt(Stable.getValueAt(i,5).toString());
                sumstringLiteralsCount = Integer.parseInt(Stable.getValueAt(i,6).toString());*/
                /*if(!strCurrentLine.trim().isEmpty())
                {
                    
                    //Ccspps=sumWtc+sumNc;
                    //Ccs=(sumWtc+sumNc)*Ccspps;
                    System.out.println(Cs);
                   
                }
                else{
                    System.out.println("no");
                }*/
                
                if (strCurrentLine.trim().length() != 0) {
                    System.out.println(strCurrentLine);
                    strCurrentLine = strCurrentLine.trim();

                }
                if (strCurrentLine.contains("//")) {
                    System.out.println(strCurrentLine.substring(0, strCurrentLine.indexOf("//")));
                    strCurrentLine = strCurrentLine.substring(0, strCurrentLine.indexOf("//"));
                    
                }  
         }
        
        
            //System.out.println(n.x+"******************************************************************************************************************************");
            //if(n.x == "JAVA File"){
            Cs = (1 * new size_1().keywordCount(strCurrentLine)) + (1 * new size_1().identifierCount(strCurrentLine)) + (1 * new size_1().operatorCount(strCurrentLine)) + (1 * new size_1().numericalValueCount(strCurrentLine)) + (1 * new size_1().stringLiteralsCount(strCurrentLine));
            
            Object[] row = {LineNo++, strCurrentLine, new size_1().keywordCount(strCurrentLine), new size_1().identifierCount(strCurrentLine), new size_1().operatorCount(strCurrentLine), new size_1().numericalValueCount(strCurrentLine), new size_1().stringLiteralsCount(strCurrentLine), Cs};            
            model.addRow(row);    
            //}
            //else{
            //Cs = (1 * new size_1().keywordCount(strCurrentLine)) + (1 * new size_1().identifierCount(strCurrentLine)) + (1 * new size_1().operatorCount(strCurrentLine)) + (1 * new size_1().numericalValueCount(strCurrentLine)) + (1 * new size_1().stringLiteralsCount(strCurrentLine));
            
            //Object[] row = {LineNo++, strCurrentLine};            
            //model.addRow(row);  
            //}
            
                    
                     
        }
        return this.sumControl;
        //public int keywordCount(String line);
        //public int identifierCount(String line);
        //public int operatorCount(String line);
        //public int numericalValueCount(String line);
        //public int stringLiteralsCount(String line);
        //System.out.println("Hello");
           
        
        }   
        
    //return 0;
    
    public void Cs(File ff) throws FileNotFoundException{
      DefaultTableModel model = (DefaultTableModel) Stable.getModel();
          FileReader fr = new FileReader(ff);
          BufferedReader br = new BufferedReader(fr);
          String strCurrentLine;
          int z=0;
          for(int y=0;y<Stable.getRowCount();y++)
          {
              //z=Integer.parseInt(STable.getValueAt(y, 3).toString());
              //h=z=Integer.parseInt(STable.getValueAt(y, 3).toString());
          }
          Object[] row = {};
    }
     
     public void condition(File ff) throws FileNotFoundException, IOException{
          CharSequence nc = "&&";
          DefaultTableModel model = (DefaultTableModel) Stable.getModel();
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
                    
                    Object[] row = {null, null, null, null, null, sum};
                    
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

       //sizeComplexity(stringArray);
       //controlComplexity(stringArray);
       //nestedLevelComplexity(lineArray);
    }   
    //Size(File ff) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

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
        Stable = new javax.swing.JTable();
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
        jButton4.setBounds(950, 110, 180, 35);

        Stable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line no", "Program Statements", "Nkw", "Nid", "Nop", "Nnv", "Nsl", "Cs"
            }
        ));
        jScrollPane1.setViewportView(Stable);

        panel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 200, 1060, 460);

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
        jLabel2.setText("Size");
        panel1.add(jLabel2);
        jLabel2.setBounds(70, 100, 210, 30);

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/world.jpg"))); // NOI18N
        panel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 800);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Weight1().setVisible(true);
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
                new Size().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Stable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
