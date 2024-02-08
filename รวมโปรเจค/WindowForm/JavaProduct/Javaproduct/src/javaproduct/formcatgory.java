/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaproduct;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Windows
 */
public class formcatgory extends javax.swing.JFrame {

    ResultSet rs;
    PreparedStatement pst;

    /**
     * Creates new form formcatgory
     */
    private void showMessage(String text) {
        JOptionPane.showMessageDialog(this, text, "Alert", JOptionPane.INFORMATION_MESSAGE);

    }

    public void spacetxt() {
        txtid.setText("");
        txtname.setText("");
    }

    //insert delete update edit
    private void addData() {
        String sql = "INSERT INTO tblcatgory(c_id,c_name) "
                + "VALUES ('" + txtid.getText() + "','" + txtname.getText() + "')";
        try {
            Connection con = Javaproduct.connDB();
            Statement stm = con.createStatement();
            int b = stm.executeUpdate(sql);
            if (b != -1) {
                String sql1 = "SELECT * FROM tblcatgory";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                tbcatgory.setModel(DbUtils.resultSetToTableModel(rs));
                rs.first();
                datatotext(rs);

                showMessage("Insert Succes");

            } else {
                JOptionPane.showMessageDialog(this, "Update Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Edit() {
        String sql = "UPDATE tblcatgory SET c_id = '" + txtid.getText() + "',c_name = '" + txtname.getText() + "' "
                + "WHERE c_id = '" + txtid.getText() + "'";

        try {
            Connection con = Javaproduct.connDB();
            Statement stm = con.createStatement();
            int confirm = JOptionPane.showConfirmDialog(this, "Your confirm Edit Data" + txtname.getText() + "Yes or No" + JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION){
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Edit Data "+txtname.getText()+" Succes");
                String sql1 = "SELECT * FROM tblcatgory";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                tbcatgory.setModel(DbUtils.resultSetToTableModel(rs));
                rs.first();
                datatotext(rs);
            }else if(confirm==JOptionPane.NO_OPTION){
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteData() {
        String sql = "DELETE FROM tblcatgory WHERE c_id = '" + txtid.getText() + "'";
        try {
            Connection con = Javaproduct.connDB();
            Statement stm = con.createStatement();
            int confirm = JOptionPane.showConfirmDialog(this, "Your confirm to Delete Data" + txtname.getText() + "Yes or No" + JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION){
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Delete Data "+txtname.getText()+" Succes");
                String sql1 = "SELECT * FROM tblcatgory";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                tbcatgory.setModel(DbUtils.resultSetToTableModel(rs));
                rs.first();
                datatotext(rs);
            }else {
                JOptionPane.showMessageDialog(this, "Delete Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showdata() {
        String sql = "SELECT * FROM tblcatgory";
        try {
            Connection con = Javaproduct.connDB();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
            tbcatgory.setModel(DbUtils.resultSetToTableModel(rs));
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public formcatgory() {
        initComponents();
        showdata();
    }

    //move page
    public void moveNext() {
        try {
            if (rs.isLast()) {
                return;
            } else {
                rs.next();
                datatotext(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveBack() {
        try {
            if (rs.isFirst()) {
                return;
            } else {
                rs.previous();
                datatotext(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveFirst() {
        try {
            rs.first();
            datatotext(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveLast() {
        try {
            rs.last();
            datatotext(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //move page //

//    space input ----------------------------------------------------
//    ----------------------------------------------------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnrewind = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btnfast = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbcatgory = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtname1 = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menuadd = new javax.swing.JMenuItem();
        menucatgory = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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

        btnexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaproduct/power-button.png"))); // NOI18N
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        tbcatgory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Title 3", "Title 4"
            }
        ));
        tbcatgory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbcatgoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbcatgory);

        txtsearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("ค้นหา");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("ชื่อ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("เบอร์มือถือ");

        txtname1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtname1FocusLost(evt);
            }
        });
        txtname1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtname1KeyTyped(evt);
            }
        });

        txtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphoneActionPerformed(evt);
            }
        });
        txtphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtphoneKeyTyped(evt);
            }
        });

        jMenu3.setText("ข้อมูลสินค้า");
        jMenu3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        menuadd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menuadd.setText("เพิ่มสินค้า");
        menuadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuaddActionPerformed(evt);
            }
        });
        jMenu3.add(menuadd);

        menucatgory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menucatgory.setText("เรียกสินค้า");
        menucatgory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucatgoryActionPerformed(evt);
            }
        });
        jMenu3.add(menucatgory);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnrewind, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnfast, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnadd)
                                .addGap(16, 16, 16)
                                .addComponent(btndelete)))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtname1)
                                    .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(txtphone))))
                        .addGap(34, 171, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnexit)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnexit)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnadd)
                            .addComponent(btndelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnedit)
                            .addComponent(jButton3))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnback)
                            .addComponent(btnnext))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnfast)
                            .addComponent(btnrewind)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(txtname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void btnrewindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrewindActionPerformed
        moveFirst();        // TODO add your handling code here:
    }//GEN-LAST:event_btnrewindActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        moveNext();        // TODO add your handling code here:
    }//GEN-LAST:event_btnnextActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        moveBack();    // TODO add your handling code here:
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnfastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfastActionPerformed
        moveLast();   // TODO add your handling code here:
    }//GEN-LAST:event_btnfastActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnexitActionPerformed

    private void tbcatgoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbcatgoryMouseClicked
        try {
            int row = tbcatgory.getSelectedRow();
            String selectid = tbcatgory.getValueAt(row, 0).toString();
            String sql = "SELECT * FROM tblcatgory where c_id = '" + selectid + "'";
            Connection con = Javaproduct.connDB();
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
            rs.first();
            datatotext(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbcatgoryMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        addData();         // TODO add your handling code here:
    }//GEN-LAST:event_btnaddActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
    Edit();        // TODO add your handling code here:
    }//GEN-LAST:event_btneditActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
    DeleteData();        // TODO add your handling code here:
    }//GEN-LAST:event_btndeleteActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        try{
            String data = txtsearch.getText();
            String sql = "SELECT * FROM tblcatgory WHERE c_name or c_id =?";
            Connection con = Javaproduct.connDB();
            pst = con.prepareStatement(sql);
            pst.setString(1, data);
            rs = pst.executeQuery();
            tbcatgory.setModel(DbUtils.resultSetToTableModel(rs));
            System.out.print(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void txtname1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtname1KeyTyped
    
    }//GEN-LAST:event_txtname1KeyTyped

    private void txtphoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphoneKeyTyped
    char ch01 = evt.getKeyChar();
    if(!(Character.isDigit(ch01)||(ch01==KeyEvent.VK_BACK_SPACE))){
        evt.consume();
    }
    
    if(txtphone.getText().length()>=10){
        evt.consume();
    }
        
    }//GEN-LAST:event_txtphoneKeyTyped

    private void txtname1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtname1FocusLost
    if(txtname1.getText().equals("")){
        txtname1.setText("Entername");
        txtname1.setText("");
    }else{
        String name = txtname1.getText();
        Pattern pt = Pattern.compile("^[a-zA-Zกขฮ-์]+([\\s][a-zA-Z]+)*$");
        Matcher mc = pt.matcher(name);
        boolean mf = mc.matches();
        if(!(mf)){
            JOptionPane.showMessageDialog(null, "");
            txtname1.setText("");
            txtname1.requestFocus();
        }
    }
    }//GEN-LAST:event_txtname1FocusLost

    private void menuaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuaddActionPerformed
    formProduct f1 = new formProduct();
    f1.show();
    this.dispose();
    }//GEN-LAST:event_menuaddActionPerformed

    private void menucatgoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucatgoryActionPerformed
    formcatgory f2 = new formcatgory();
    f2.show();
    this.dispose();
    }//GEN-LAST:event_menucatgoryActionPerformed

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
    formProduct f1 = new formProduct();
    f1.show();
    this.dispose();
    }//GEN-LAST:event_jMenu3ActionPerformed

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
            java.util.logging.Logger.getLogger(formcatgory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formcatgory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formcatgory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formcatgory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formcatgory().setVisible(true);
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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuadd;
    private javax.swing.JMenuItem menucatgory;
    private javax.swing.JTable tbcatgory;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtname1;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
