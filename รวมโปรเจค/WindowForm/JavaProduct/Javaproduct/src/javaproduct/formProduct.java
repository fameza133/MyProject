/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaproduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Windows
 */
public class formProduct extends javax.swing.JFrame {

    /**
     * Creates new form formProduct
     */
    

    ResultSet rs;
    PreparedStatement pst;

    /**
     * Creates new form formcatgory
     */
    public void showdata() {
        String sql = "SELECT * FROM tblproduct";
        try {
            Connection con = Javaproduct.connDB();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
            tbproduct.setModel(DbUtils.resultSetToTableModel(rs));
            rs.first();
            datatotext(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public void datatotext(ResultSet rs) {
        try {
            txtid.setText(rs.getString(1)); // line in table db
            txtname.setText(rs.getString(2));
            txttype.setText(rs.getString(3));
            txtprice.setText(rs.getString(4));
            txtcount.setText(rs.getString(5));
            
            
        } catch (Exception e) {
            e.printStackTrace();    
        }
    }
    


    public formProduct() {
        initComponents();
        showdata();
//        showdatacid();
    }
    
    //move page
    public void moveNext(){
        try{
            if(rs.isLast()){
                return;
            }else{
                rs.next();
                datatotext(rs);
            }
                
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void moveBack(){
        try{
            if(rs.isFirst()){
                return;
            }else{
                rs.previous();
                datatotext(rs);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void moveFirst(){
        try{
            rs.first();
            datatotext(rs);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void moveLast(){
        try{
            rs.last();
            datatotext(rs);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    

private void showMessage(String text){
        JOptionPane.showMessageDialog(this,text,"Alert",JOptionPane.INFORMATION_MESSAGE);
        
    }
    
//add delete edit save ---------------------------------------------
    
    public void addDB(){   
        String sql = "INSERT INTO tblproduct(p_id,p_name,p_detail,p_price,p_count) "
                + "VALUES ('"+txtid.getText()+"','"+txtname.getText()+"','"+txttype.getText()+"','"+txtprice.getText()+"','"+txtcount.getText()+"')";
        try{
            Connection con = Javaproduct.connDB();
            Statement stm = con.createStatement();
            int b = stm.executeUpdate(sql);
            if (b != -1) {
                String sql1 = "SELECT * FROM tblproduct";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                tbproduct.setModel(DbUtils.resultSetToTableModel(rs));
                rs.first();
                datatotext(rs);

                showMessage("Insert Succes");
                
            } else {
                JOptionPane.showMessageDialog(this, "Update Error");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    
    
    public void Edit(){
        
       String sql = "UPDATE tblproduct "
                + "SET p_id = '" + txtid.getText() + "',p_name = '" + txtname.getText() + "'"
                + ",p_detail = '" + txttype.getText() + "' ,p_price = '" + txtprice.getText() + "',p_count = '" + txtcount.getText() + "'"
                + "WHERE p_id = '" + txtid.getText() + "'";
            
            try {
            Connection con = Javaproduct.connDB();
            Statement stm = con.createStatement();
            int confirm = JOptionPane.showConfirmDialog(this, "Your confirm Edit Data" + txtname.getText() + "Yes or No" + JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION){
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Edit Data "+txtname.getText()+" Succes");
                String sql1 = "SELECT * FROM tblproduct";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                tbproduct.setModel(DbUtils.resultSetToTableModel(rs));
                rs.first();
                datatotext(rs);
            }else if(confirm==JOptionPane.NO_OPTION){
                return;
            }
            }catch(Exception e){
                e.printStackTrace();
            }
    
    }
  
    
    public void Del() {
        JOptionPane.showConfirmDialog(this, "Do you want to Delete");
        String sql = "DELETE FROM tblproduct WHERE p_id = '" + txtid.getText() + "'";
        try {
            Connection con = Javaproduct.connDB();
                Statement stm = con.createStatement();
                boolean b = stm.execute(sql);
                if (!b) {
                    JOptionPane.showMessageDialog(this, "Delete Succes");
                    String sql1 = "SELECT * FROM tblproduct";
                    pst = con.prepareStatement(sql1);
                    rs = pst.executeQuery();
                    tbproduct.setModel(DbUtils.resultSetToTableModel(rs));
                    rs.first();
                datatotext(rs);
                } else {
                    JOptionPane.showMessageDialog(this, "Delete Error");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        btnexit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnrewind = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txttype = new javax.swing.JTextField();
        btnfast = new javax.swing.JButton();
        txtcount = new javax.swing.JTextField();
        btnback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbproduct = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("จำนวนสินค้า");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("ชิ้น");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("บาท");

        btnexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaproduct/power-button.png"))); // NOI18N
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("ราคา");

        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaproduct/delete.png"))); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaproduct/Edit.png"))); // NOI18N
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaproduct/save.png"))); // NOI18N
        jButton3.setText("Save");

        btnrewind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaproduct/rewind.png"))); // NOI18N
        btnrewind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrewindActionPerformed(evt);
            }
        });

        btnnext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaproduct/next.png"))); // NOI18N
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("ข้อมูลสินค้า");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("รหัส");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("ชื่อสินค้า");

        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaproduct/add.png"))); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("รายละเอียดสินค้า");

        btnfast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaproduct/fast-forward.png"))); // NOI18N
        btnfast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfastActionPerformed(evt);
            }
        });

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaproduct/back.png"))); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        tbproduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "p_id", "p_name", "p_detail", "p_price", "p_count", "c_id"
            }
        ));
        tbproduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbproductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbproduct);

        txtsearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("ค้นหา");

        jMenu1.setText("ข้อมูลสินค้า");
        jMenu1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem2.setText("เพิ่มสินค้า");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem3.setText("เรียกสินค้า");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(112, 112, 112)
                .addComponent(btnexit)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnadd)
                                .addGap(16, 16, 16)
                                .addComponent(btndelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnedit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnrewind, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnfast, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9))
                                    .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtcount, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnexit)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnfast, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnback)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnrewind)
                        .addComponent(btnnext)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(btndelete)
                    .addComponent(btnedit)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnrewindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrewindActionPerformed
        moveFirst();        // TODO add your handling code here:
    }//GEN-LAST:event_btnrewindActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        moveNext();        // TODO add your handling code here:
    }//GEN-LAST:event_btnnextActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
    addDB();
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnfastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfastActionPerformed
        moveLast();   // TODO add your handling code here:
    }//GEN-LAST:event_btnfastActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        moveBack();    // TODO add your handling code here:
    }//GEN-LAST:event_btnbackActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
    Edit();    // TODO add your handling code here:
    }//GEN-LAST:event_btneditActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
     try{
            String data = txtsearch.getText();
            String sql = "SELECT * FROM tblproduct WHERE p_name or p_id=?";
            Connection con = Javaproduct.connDB();
            pst = con.prepareStatement(sql);
            pst.setString(1, data);
            rs = pst.executeQuery();
            tbproduct.setModel(DbUtils.resultSetToTableModel(rs));
            System.out.print(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    formcatgory f2 = new formcatgory();
    f2.show();
    this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    formProduct f1 = new formProduct();
    f1.show();
    this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
    Del();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tbproductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbproductMouseClicked
    try {
            int row = tbproduct.getSelectedRow();
            String selectid = tbproduct.getValueAt(row, 0).toString();
            String sql = "SELECT * FROM tblproduct where p_id = '" + selectid + "'";
            Connection con = Javaproduct.connDB();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
            rs.first();
            datatotext(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbproductMouseClicked

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnexitActionPerformed

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
            java.util.logging.Logger.getLogger(formProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnfast;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnrewind;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbproduct;
    private javax.swing.JTextField txtcount;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttype;
    // End of variables declaration//GEN-END:variables

    
}
