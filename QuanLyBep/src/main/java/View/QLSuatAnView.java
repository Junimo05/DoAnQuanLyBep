/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.MonAnDAO;
import Controller.SuatAnDAO;
import Model.MonAn;
import Model.SuatAn;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author anhtu
 */
public class QLSuatAnView extends javax.swing.JFrame implements ActionListener{
    private SuatAn suatAn;
    private ArrayList<SuatAn> list = new SuatAnDAO().getListSA();
    /**
     * Creates new form QLSuatAnView
     */
    public QLSuatAnView() {
        initComponents();
        btt_ThemSuatAn.addActionListener(this);
        btt_XoaSuatAn.addActionListener(this);
        load();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialog_SuaMonAn = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_MonAnSA = new javax.swing.JTable();
        txt_Search1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dialogjbl_DsMA = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btt_ThemSuatAn = new javax.swing.JButton();
        btt_XoaSuatAn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        txt_Search = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SuatAn = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btt_QLSuatAn = new javax.swing.JMenu();
        btt_QLMonAn = new javax.swing.JMenu();
        btt_QLNguyenLieu = new javax.swing.JMenu();
        btt_QLNhanVien = new javax.swing.JMenu();

        dialog_SuaMonAn.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dialog_SuaMonAnWindowClosing(evt);
            }
        });

        tbl_MonAnSA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Món Ăn", "Tên Món Ăn", "Đơn Giá", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_MonAnSA.setColumnSelectionAllowed(true);
        tbl_MonAnSA.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_MonAnSA);
        tbl_MonAnSA.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tbl_MonAnSA.getColumnModel().getColumnCount() > 0) {
            tbl_MonAnSA.getColumnModel().getColumn(0).setResizable(false);
            tbl_MonAnSA.getColumnModel().getColumn(1).setResizable(false);
            tbl_MonAnSA.getColumnModel().getColumn(2).setResizable(false);
            tbl_MonAnSA.getColumnModel().getColumn(3).setResizable(false);
        }

        txt_Search1.setBorder(null);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jLabel8.setToolTipText("");
        jLabel8.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Search1))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Search1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        dialogjbl_DsMA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Món Ăn", "Số Lượng", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dialogjbl_DsMA.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(dialogjbl_DsMA);
        if (dialogjbl_DsMA.getColumnModel().getColumnCount() > 0) {
            dialogjbl_DsMA.getColumnModel().getColumn(0).setResizable(false);
            dialogjbl_DsMA.getColumnModel().getColumn(1).setResizable(false);
            dialogjbl_DsMA.getColumnModel().getColumn(2).setResizable(false);
        }
        //

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout dialog_SuaMonAnLayout = new javax.swing.GroupLayout(dialog_SuaMonAn.getContentPane());
        dialog_SuaMonAn.getContentPane().setLayout(dialog_SuaMonAnLayout);
        dialog_SuaMonAnLayout.setHorizontalGroup(
            dialog_SuaMonAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialog_SuaMonAnLayout.setVerticalGroup(
            dialog_SuaMonAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialog_SuaMonAn.pack();
        dialog_SuaMonAn.setLocationRelativeTo(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản Lý Suất Ăn");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btt_ThemSuatAn.setText("Thêm");
        btt_ThemSuatAn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btt_XoaSuatAn.setText("Xóa");
        btt_XoaSuatAn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btt_XoaSuatAn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btt_ThemSuatAn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btt_ThemSuatAn, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btt_XoaSuatAn, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        txt_Search.setBorder(null);
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jLabel7.setToolTipText("");
        jLabel7.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_Search)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tbl_SuatAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Suất Ăn", "Sẵn Sàng", "Tổng Giá Tiền", "Thời Gian"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_SuatAn.setColumnSelectionAllowed(true);
        tbl_SuatAn.getTableHeader().setReorderingAllowed(false);
        tbl_SuatAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SuatAnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_SuatAn);
        tbl_SuatAn.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tbl_SuatAn.getColumnModel().getColumnCount() > 0) {
            tbl_SuatAn.getColumnModel().getColumn(0).setResizable(false);
            tbl_SuatAn.getColumnModel().getColumn(1).setResizable(false);
            tbl_SuatAn.getColumnModel().getColumn(2).setResizable(false);
            tbl_SuatAn.getColumnModel().getColumn(3).setResizable(false);
        }
        ListSelectionModel selectionModel = tbl_SuatAn.getSelectionModel();

        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!selectionModel.isSelectionEmpty()) {
                    btt_XoaSuatAn.setEnabled(true);
                }
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        btt_QLSuatAn.setText("Quản Lý Suất Ăn");
        btt_QLSuatAn.setToolTipText("");
        jMenuBar1.add(btt_QLSuatAn);

        btt_QLMonAn.setText("Quản Lý Món Ăn");
        btt_QLMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btt_QLMonAnMouseClicked(evt);
            }
        });
        jMenuBar1.add(btt_QLMonAn);

        btt_QLNguyenLieu.setText("Quản Lý Nguyên Liệu");
        btt_QLNguyenLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btt_QLNguyenLieuMouseClicked(evt);
            }
        });
        jMenuBar1.add(btt_QLNguyenLieu);

        btt_QLNhanVien.setText("Quản Lý Nhân Viên");
        btt_QLNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btt_QLNhanVienMouseClicked(evt);
            }
        });
        jMenuBar1.add(btt_QLNhanVien);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btt_ThemSuatAn) {
            btt_ThemSuatAnClicked();
        } else if (e.getSource() == btt_XoaSuatAn) {
            btt_XoaSuatAnClicked();
        }
    }

    public void btt_ThemSuatAnClicked(){
        suatAn = new SuatAn();
        if(new SuatAnDAO().ThemSuatAn(suatAn)) {
            JOptionPane.showMessageDialog(rootPane, "Thêm suất ăn thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            dialog_SuaMonAn.setVisible(true);
            loadTableSA();
            loadTableSuaMA(NORMAL);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Thêm suất ăn không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btt_XoaSuatAnClicked(){
        DefaultTableModel model = (DefaultTableModel) tbl_SuatAn.getModel();
        int rowIndex = tbl_SuatAn.getSelectedRow();
        String maSAStr = model.getValueAt(rowIndex, 0).toString();
        int maSA = Integer.parseInt(maSAStr);
        if(new SuatAnDAO().xoaSuatAn(maSA)) {
            JOptionPane.showMessageDialog(rootPane, "Xóa Thành Công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            
            //Update
            model = (DefaultTableModel) tbl_SuatAn.getModel();
            int selectedIndex = tbl_SuatAn.getSelectedRow();
            if(selectedIndex >= 0){
                model.removeRow(selectedIndex);
                loadTableSA();
            }
        } else {
          JOptionPane.showMessageDialog(rootPane, "Xóa Không Thành Công", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void load(){
        btt_XoaSuatAn.setEnabled(false);
        loadTableSA();
    }
    
    private void loadTableSA(){
        list = new SuatAnDAO().getListSA();
        DefaultTableModel model = (DefaultTableModel) tbl_SuatAn.getModel();
        model.setRowCount(0);
        int n = list.size()-1;
        for(int i = 0 ; i <= n; i++){
            SuatAn tmp = list.get(i);
            model.addRow(new Object[]{
                tmp.getMaSuatAn(), tmp.getSanSang(), tmp.getTongTien(), tmp.getThoiGian()
            });
        } 
    }
    
    private void loadTableSuaMA(int MA){
        ArrayList<MonAn> list = new SuatAnDAO().getListMA(MA);
        DefaultTableModel model = (DefaultTableModel) tbl_MonAnSA.getModel();
        model.setRowCount(0);
        TableColumn buttonColumn = dialogjbl_DsMA.getColumnModel().getColumn(2);
        buttonColumn.setCellRenderer(new ButtonRenderer());
        int n = list.size()-1;
        for(int i = 0 ; i <= n; i++){
            MonAn tmp = list.get(i);
            model.addRow(new Object[]{
                tmp.getMaMon(), tmp.getTenMon(), tmp.getdongia(), tmp.getSoLuong()
            });
        }
    }
    
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            setText((value == null) ? "" : value.toString());

            return this;
        }
    }

    public void enableButtMF(){
        btt_ThemSuatAn.setEnabled(true);
        btt_XoaSuatAn.setEnabled(true);
    }
    
    public void disableButtMF(){
        btt_ThemSuatAn.setEnabled(false);
        btt_XoaSuatAn.setEnabled(false);
    }
    private void dialog_SuaMonAnWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialog_SuaMonAnWindowClosing
        enableButtMF();
    }//GEN-LAST:event_dialog_SuaMonAnWindowClosing

    private void btt_QLMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_QLMonAnMouseClicked
        new QLMonAnView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btt_QLMonAnMouseClicked

    private void btt_QLNguyenLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_QLNguyenLieuMouseClicked
        new QLNLView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btt_QLNguyenLieuMouseClicked

    private void btt_QLNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_QLNhanVienMouseClicked
        new QLNhanVienView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btt_QLNhanVienMouseClicked

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased
        String keyword = txt_Search.getText().toLowerCase(); 
        DefaultTableModel tableModel = (DefaultTableModel) tbl_SuatAn.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        tbl_SuatAn.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
    }//GEN-LAST:event_txt_SearchKeyReleased
    
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       new HomePage().setVisible(true);
    }//GEN-LAST:event_formWindowClosing
        
    
    
    Set<Integer> selectedRows = new HashSet<>();
    Set<Integer> selectedCols = new HashSet<>();
    private void tbl_SuatAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SuatAnMouseClicked
        int row = tbl_SuatAn.rowAtPoint(evt.getPoint());
        int col = tbl_SuatAn.columnAtPoint(evt.getPoint());
        
        // Check if the cell is valid and left mouse button is clicked
        if(evt.getClickCount() == 2){
            dialog_SuaMonAn.setVisible(true);
            String ma = tbl_SuatAn.getValueAt(row, 0).toString();
            int MA = Integer.parseInt(ma);
            loadTableSuaMA(MA);
        }else if (row >= 0 && col >= 0 && SwingUtilities.isLeftMouseButton(evt)) {
            // If cell is already selected and isSelected is true, then deselect it
            if (selectedRows.contains(row) && selectedCols.contains(col)) {
                tbl_SuatAn.removeRowSelectionInterval(row, row);
                tbl_SuatAn.removeColumnSelectionInterval(col, col);
                selectedRows.remove(row);
                selectedCols.remove(col);
            } else {
                // Otherwise, select the cell
                tbl_SuatAn.addRowSelectionInterval(row, row);
                tbl_SuatAn.addColumnSelectionInterval(col, col);
                selectedRows.add(row);
                selectedCols.add(col);
                btt_XoaSuatAn.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tbl_SuatAnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btt_QLMonAn;
    private javax.swing.JMenu btt_QLNguyenLieu;
    private javax.swing.JMenu btt_QLNhanVien;
    private javax.swing.JMenu btt_QLSuatAn;
    private javax.swing.JButton btt_ThemSuatAn;
    private javax.swing.JButton btt_XoaSuatAn;
    private javax.swing.JDialog dialog_SuaMonAn;
    private javax.swing.JTable dialogjbl_DsMA;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_MonAnSA;
    private javax.swing.JTable tbl_SuatAn;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_Search1;
    // End of variables declaration//GEN-END:variables

}
