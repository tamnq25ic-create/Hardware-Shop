/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package management;
import dao.InvoicesDAO;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import management.Invoices;

/**
 *
 * @author ACER
 */
public class Reports extends javax.swing.JPanel {

    /**
     * Creates new form Customer
     */
    public Reports() {
    initComponents();
    initReport();

    jComboBox1.setSelectedIndex(1); // Theo tháng
    jComboBox1ActionPerformed(null);
    jButton1ActionPerformed(null);

// CHỈ auto load nếu không phải "Theo ngày"
if (!jComboBox1.getSelectedItem().toString().equals("Theo ngày")) {
    jButton1ActionPerformed(null);
}

    
}
private DefaultTableModel reportModel;

    private void initReport() {
    // Định dạng báo cáo
    jComboBox1.removeAllItems();
    jComboBox1.addItem("Theo ngày");
    jComboBox1.addItem("Theo tháng");
    jComboBox1.addItem("Theo năm");

    // Trạng thái
    jComboBox2.removeAllItems();
    jComboBox2.addItem("All");
    jComboBox2.addItem("Paid");
    jComboBox2.addItem("UnPaid");

    // Table model 
    reportModel = (DefaultTableModel) jTable2.getModel();
    reportModel.setRowCount(0);
    // KÍCH HOẠT AUTO-FILL NGAY KHI MỞ
    jComboBox1.setSelectedIndex(0);
    jComboBox1ActionPerformed(null);

}
    private boolean validateInput(String format, String from, String to) {

    if (format.equals("Theo ngày")) {
        if (from.isEmpty() || to.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Vui lòng nhập đầy đủ Từ ngày và Đến ngày",
                    "Lỗi",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Sau này có thể check định dạng yyyy-MM-dd
    return true;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Định dạng");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid", "UnPaid", "All" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Trạng thái:");

        jButton1.setText("Xem báo cáo");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel3.setText("Từ ngày:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Báo cáo hóa đơn");

        jLabel4.setText("Đến:");

        jButton2.setText("Xuất");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INID", "Customer_Name", "SaleDate", "Status", "TotalBill"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(51, 51, 51)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(99, 99, 99))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(317, 317, 317))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(331, 331, 331))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Chưa chọn định dạng!");
        return;
    }
        String format = jComboBox1.getSelectedItem().toString();
    String fromDate = jTextField1.getText().trim();
    String toDate = jTextField2.getText().trim();
    String status = jComboBox2.getSelectedItem().toString();

    if (!validateInput(format, fromDate, toDate)) return;

    reportModel.setRowCount(0);

    InvoicesDAO dao = new InvoicesDAO();
    List<Invoices> list = dao.getReport( fromDate, toDate, status);

    if (list.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "Không có dữ liệu phù hợp",
                "Thông báo",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    for (Invoices i : list) {
        reportModel.addRow(new Object[]{
            i.getMaHD(),
            i.getKhachHang(),
            i.getNgayLap(),
            i.getTrangThai(),
            i.getTongTien()
        });
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedItem() == null) {
        return;
    }

    String format = jComboBox1.getSelectedItem().toString();
    LocalDate today = LocalDate.now();

    switch (format) {
        case "Theo ngày":
            jTextField1.setEnabled(true);
            jTextField2.setEnabled(true);
            jTextField1.setText("");
            jTextField2.setText("");
            break;

        case "Theo tháng":
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);

            LocalDate firstDayOfMonth = today.withDayOfMonth(1);
            LocalDate lastDayOfMonth = today.withDayOfMonth(today.lengthOfMonth());

            jTextField1.setText(firstDayOfMonth.toString());
            jTextField2.setText(lastDayOfMonth.toString());
            break;

        case "Theo năm":
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);

            LocalDate firstDayOfYear = LocalDate.of(today.getYear(), 1, 1);
            LocalDate lastDayOfYear = LocalDate.of(today.getYear(), 12, 31);

            jTextField1.setText(firstDayOfYear.toString());
            jTextField2.setText(lastDayOfYear.toString());
            break;
    }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (jTable2.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this,
                "Không có dữ liệu để xuất!",
                "Thông báo",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Lưu báo cáo");
    chooser.setSelectedFile(new File("BaoCaoHoaDon.csv"));

    int result = chooser.showSaveDialog(this);
    if (result != JFileChooser.APPROVE_OPTION) return;

    try (FileWriter writer = new FileWriter(chooser.getSelectedFile())) {

        // Header
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            writer.write(jTable2.getColumnName(i));
            if (i < jTable2.getColumnCount() - 1) writer.write(",");
        }
        writer.write("\n");

        // Data
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            for (int j = 0; j < jTable2.getColumnCount(); j++) {
                Object value = jTable2.getValueAt(i, j);
                writer.write(value == null ? "" : value.toString());
                if (j < jTable2.getColumnCount() - 1) writer.write(",");
            }
            writer.write("\n");
        }

        JOptionPane.showMessageDialog(this,
                "Xuất báo cáo thành công!",
                "Thành công",
                JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Xuất thất bại!",
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

