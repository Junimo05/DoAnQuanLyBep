/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Model.NguyenLieu;
import Controller.NguyenLieuDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controller.NguyenLieuDAO;
//import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author anhtu
 */
public class QLNLView extends javax.swing.JFrame implements ActionListener {
    private NguyenLieu nl;
    private ArrayList<NguyenLieu> list = new NguyenLieuDAO().getListNL();
    /**
     * Creates new form QLNLView
     */
    public QLNLView() {
        initComponents();
        //swap
        btt_QLMonAn.addActionListener(this);
        btt_QLNguyenLieu.addActionListener(this);
        btt_QLSuatAn.addActionListener(this);
        btt_QLNhanVien.addActionListener(this);
        //button
        bttCapNhat.addActionListener(this);
        bttNhap.addActionListener(this);
        bttXoa.addActionListener(this);
        bttXoaNhap.addActionListener(this);
        load();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Ma_lbl = new javax.swing.JLabel();
        txt_MaNguyenLieu = new javax.swing.JTextField();
        NguyenLieu_lbl = new javax.swing.JLabel();
        txt_TenNguyenLieu = new javax.swing.JTextField();
        DonGia_lbl = new javax.swing.JLabel();
        txt_DonGia = new javax.swing.JTextField();
        SoLuong_lbl = new javax.swing.JLabel();
        txt_SoLuong = new javax.swing.JTextField();
        NgayNhap_lbl = new javax.swing.JLabel();
        txt_NgayNhap = new com.toedter.calendar.JDateChooser();
        bttXoaNhap = new javax.swing.JButton();
        bttNhap = new javax.swing.JButton();
        bttXoa = new javax.swing.JButton();
        bttCapNhat = new javax.swing.JButton();
        NL_Table = new javax.swing.JScrollPane();
        tbl_NguyenLieu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txt_Search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btt_QLSuatAn = new javax.swing.JMenu();
        btt_QLMonAn = new javax.swing.JMenu();
        btt_QLNguyenLieu = new javax.swing.JMenu();
        btt_QLNhanVien = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Nhân Viên");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Ma_lbl.setText("Mã");

        NguyenLieu_lbl.setText("Nguyên Liệu");

        DonGia_lbl.setText("Đơn Giá");

        SoLuong_lbl.setText("Số Lượng");

        NgayNhap_lbl.setText("Ngày Nhập");

        bttXoaNhap.setText("Xóa Nhập");

        bttNhap.setText("Nhập");

        bttXoa.setText("Xóa");

        bttCapNhat.setText("Cập Nhật");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(SoLuong_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(txt_DonGia)
                            .addComponent(txt_TenNguyenLieu)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Ma_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(NguyenLieu_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DonGia_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NgayNhap_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txt_NgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_MaNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bttNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bttXoaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bttCapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ma_lbl)
                    .addComponent(txt_MaNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NguyenLieu_lbl)
                    .addComponent(txt_TenNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DonGia_lbl)
                    .addComponent(txt_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SoLuong_lbl)
                    .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NgayNhap_lbl)
                    .addComponent(txt_NgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttXoaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );

        tbl_NguyenLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Nguyên Liệu", "Đơn Giá", "Số Lượng", "Ngày Nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_NguyenLieu.setColumnSelectionAllowed(true);
        tbl_NguyenLieu.getTableHeader().setReorderingAllowed(false);
        tbl_NguyenLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NguyenLieuMouseClicked(evt);
            }
        });
        ListSelectionModel selectionModel = tbl_NguyenLieu.getSelectionModel();

        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!selectionModel.isSelectionEmpty()) {
                    bttCapNhat.setEnabled(true);
                    bttXoa.setEnabled(true);
                    if(e.getValueIsAdjusting()){
                        txt_MaNguyenLieu.setEnabled(false);
                        int selectedRow = tbl_NguyenLieu.getSelectedRow();
                        if(selectedRow != -1){
                            //lay du lieu
                            Object ma = tbl_NguyenLieu.getValueAt(selectedRow, 0);
                            Object ten = tbl_NguyenLieu.getValueAt(selectedRow, 1);
                            Object dongia = tbl_NguyenLieu.getValueAt(selectedRow, 2);
                            Object soluong = tbl_NguyenLieu.getValueAt(selectedRow, 3);
                            Object ngaynhap = tbl_NguyenLieu.getValueAt(selectedRow, 4);
                            //Gan du lieu
                            txt_MaNguyenLieu.setText(ma.toString());
                            txt_TenNguyenLieu.setText(ten.toString());
                            txt_DonGia.setText(dongia.toString());
                            txt_SoLuong.setText(soluong.toString());
                            txt_NgayNhap.setDate((Date)ngaynhap);
                        }
                    }
                }else {
                    bttCapNhat.setEnabled(false);
                    bttXoa.setEnabled(false);
                    txt_MaNguyenLieu.setEnabled(true);
                }
            }
        });
        NL_Table.setViewportView(tbl_NguyenLieu);
        tbl_NguyenLieu.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tbl_NguyenLieu.getColumnModel().getColumnCount() > 0) {
            tbl_NguyenLieu.getColumnModel().getColumn(0).setResizable(false);
            tbl_NguyenLieu.getColumnModel().getColumn(1).setResizable(false);
            tbl_NguyenLieu.getColumnModel().getColumn(2).setResizable(false);
            tbl_NguyenLieu.getColumnModel().getColumn(3).setResizable(false);
            tbl_NguyenLieu.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txt_Search.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Search))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_Search)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        btt_QLSuatAn.setText("Quản Lý Suất Ăn");
        btt_QLSuatAn.setToolTipText("");
        btt_QLSuatAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btt_QLSuatAnMouseClicked(evt);
            }
        });
        jMenuBar1.add(btt_QLSuatAn);

        btt_QLMonAn.setText("Quản Lý Món Ăn");
        btt_QLMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btt_QLMonAnMouseClicked(evt);
            }
        });
        jMenuBar1.add(btt_QLMonAn);

        btt_QLNguyenLieu.setText("Quản Lý Nguyên Liệu");
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NL_Table, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NL_Table, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Events
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(bttNhap)){
            bttNhapClick();
        }else if(e.getSource().equals(bttXoaNhap)){
            bttXoaNhapClick();
        }else if(e.getSource().equals(bttXoa)){
            bttXoaClick();
        }else if(e.getSource().equals(bttCapNhat)){
            bttCapNhatClick();  
        }
    }
    
    public void bttNhapClick() {
        nl = new NguyenLieu();
        String maNLStr = txt_MaNguyenLieu.getText();
        String tenNL = txt_TenNguyenLieu.getText();
        String giaNLStr = txt_DonGia.getText();
        String soluongNLStr = txt_SoLuong.getText();
        Date selectedDate = txt_NgayNhap.getDate();
        
        java.sql.Date ngayNhap = null; 
        if (selectedDate != null) {
            // Chuyển đổi Date thành java.sql.Date
            ngayNhap = new java.sql.Date(selectedDate.getTime());
        }

        // Validate input values
        String errorMessage = validateInputValues(maNLStr, tenNL, giaNLStr, soluongNLStr, ngayNhap);
        if (errorMessage != null) {
          JOptionPane.showMessageDialog(rootPane, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
          return;
        }

        // Set input values to NguyenLieu instance
        int maNL = Integer.parseInt(maNLStr);
        int giaNL = Integer.parseInt(giaNLStr);
        int soluongNL = Integer.parseInt(soluongNLStr);

        nl.setMaNL(maNL);
        nl.setTenNL(tenNL);
        nl.setGiaNL(giaNL);
        nl.setSoluongNL(soluongNL);
        nl.setNgay(ngayNhap);
        
        //Check
        if(new NguyenLieuDAO().ThemNguyenLieu(nl)) {
          JOptionPane.showMessageDialog(rootPane, "Thêm Thành Công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(rootPane, "Thêm Không Thành Công", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        DefaultTableModel model = (DefaultTableModel) tbl_NguyenLieu.getModel();
        loadTable();
    }
    
    //Data is valid ?
    private String validateInputValues(String maNLStr, String tenNL, String giaNLStr, String soluongNLStr, Date ngayNhap) {
        if (!isNumeric(maNLStr)) {
          return "Mã Nguyên Liệu phải là số";
        }

        int maNL = Integer.parseInt(maNLStr);

        if (maNL <= 0) {
          return "Mã Nguyên Liệu phải lớn hơn 0";
        }
        if(maNLStr.isEmpty()){
            return "Mã Nguyên Liệu không được để trống";
        }
        if (tenNL.isEmpty()) {
          return "Tên Nguyên Liệu không được để trống";
        }

        if (!isNumeric(giaNLStr)) {
          return "Đơn giá phải là số";
        }

        int giaNL = Integer.parseInt(giaNLStr);

        if (giaNL <= 0) {
          return "Đơn giá phải lớn hơn 0";
        }

        if (!isNumeric(soluongNLStr)) {
          return "Số lượng phải là số";
        }

        int soluongNL = Integer.parseInt(soluongNLStr);

        if (soluongNL <= 0) {
          return "Số lượng phải lớn hơn 0";
        }

        if (ngayNhap == null) {
          return "Ngày nhập không được để trống";
        }

        return null;
    }

    private boolean isNumeric(String str) {
      return str.matches("-?\\d+(\\.\\d+)?");
    }
    
    //
    public void bttXoaClick(){
        String maNLStr = txt_MaNguyenLieu.getText();
        int maNL = Integer.parseInt(maNLStr);
        if(new NguyenLieuDAO().xoaNguyenLieu(maNL)) {
            JOptionPane.showMessageDialog(rootPane, "Xóa Thành Công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            
            //Update
            DefaultTableModel model = (DefaultTableModel) tbl_NguyenLieu.getModel();
            int selectedIndex = tbl_NguyenLieu.getSelectedRow();
            if(selectedIndex >= 0){
                model.removeRow(selectedIndex);
                loadTable();
                bttXoaNhapClick();
            }
        } else {
          JOptionPane.showMessageDialog(rootPane, "Xóa Không Thành Công", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void bttXoaNhapClick(){
        txt_MaNguyenLieu.setEnabled(true);
        txt_MaNguyenLieu.setText("");
        txt_TenNguyenLieu.setText("");
        txt_DonGia.setText("");
        txt_SoLuong.setText("");
        txt_NgayNhap.setDate(null);
        
    }
    
    public void bttCapNhatClick(){
        nl = new NguyenLieu();
        String maNLStr = txt_MaNguyenLieu.getText();
        String tenNL = txt_TenNguyenLieu.getText();
        String giaNLStr = txt_DonGia.getText();
        String soluongNLStr = txt_SoLuong.getText();
        Date selectedDate = txt_NgayNhap.getDate();
        
        java.sql.Date ngayNhap = null; 
        if (selectedDate != null) {
            // Chuyển đổi Date thành java.sql.Date
            ngayNhap = new java.sql.Date(selectedDate.getTime());
        }
        
        // Validate input values
        String errorMessage = validateInputValues(maNLStr, tenNL, giaNLStr, soluongNLStr, ngayNhap);
        if (errorMessage != null) {
          JOptionPane.showMessageDialog(rootPane, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
          return;
        }
        
        int maNL = Integer.parseInt(maNLStr);
        int giaNL = Integer.parseInt(giaNLStr);
        int soluongNL = Integer.parseInt(soluongNLStr);

        nl.setMaNL(maNL);
        nl.setTenNL(tenNL);
        nl.setGiaNL(giaNL);
        nl.setSoluongNL(soluongNL);
        nl.setNgay(ngayNhap);
        
        if(new NguyenLieuDAO().CapNhatNguyenLieu(nl)) {
          JOptionPane.showMessageDialog(rootPane, "Cập Nhật Thành Công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
          loadTable();
          bttXoaNhapClick();
        } else {
          JOptionPane.showMessageDialog(rootPane, "Cập Nhật Không Thành Công", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void load(){
        bttCapNhat.setEnabled(false);
        bttXoa.setEnabled(false);
        loadTable();
    }
    
    private void loadTable(){
        list = new NguyenLieuDAO().getListNL();
        DefaultTableModel model = (DefaultTableModel) tbl_NguyenLieu.getModel();
        model.setRowCount(0);
        int n = list.size()-1;
        for(int i = 0 ; i <= n; i++){
            NguyenLieu tmp = list.get(i);
            model.addRow(new Object[]{
                tmp.getMaNL(), tmp.getTenNL(), tmp.getGiaNL(), tmp.getSoluongNL(), tmp.getNgay()
            });
        }
        
    }
    
    private void btt_QLSuatAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_QLSuatAnMouseClicked
        new QLSuatAnView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btt_QLSuatAnMouseClicked

    private void btt_QLMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_QLMonAnMouseClicked
        new QLMonAnView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btt_QLMonAnMouseClicked

    private void btt_QLNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_QLNhanVienMouseClicked
        new QLNhanVienView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btt_QLNhanVienMouseClicked

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased
        String keyword = txt_Search.getText().toLowerCase(); // Lấy giá trị đã nhập và chuyển đổi sang chữ thường
        DefaultTableModel tableModel = (DefaultTableModel) tbl_NguyenLieu.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel); // Tạo đối tượng RowSorter để sắp xếp và lọc dữ liệu trên bảng
        tbl_NguyenLieu.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));// Lọc các hàng trên bảng theo chuỗi tìm kiếm, không phân biệt hoa thường
    }//GEN-LAST:event_txt_SearchKeyReleased
    
    //
    Set<Integer> selectedRows = new HashSet<>();
    Set<Integer> selectedCols = new HashSet<>();
    private void tbl_NguyenLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NguyenLieuMouseClicked
        int row = tbl_NguyenLieu.rowAtPoint(evt.getPoint());
        int col = tbl_NguyenLieu.columnAtPoint(evt.getPoint());
        
        // Check if the cell is valid and left mouse button is clicked
        if (row >= 0 && col >= 0 && SwingUtilities.isLeftMouseButton(evt)) {
            // If cell is already selected and isSelected is true, then deselect it
            if (selectedRows.contains(row) && selectedCols.contains(col)) {
                tbl_NguyenLieu.removeRowSelectionInterval(row, row);
                tbl_NguyenLieu.removeColumnSelectionInterval(col, col);
                selectedRows.remove(row);
                selectedCols.remove(col);
                bttXoaNhapClick();
            } else {
                // Otherwise, select the cell
                tbl_NguyenLieu.addRowSelectionInterval(row, row);
                tbl_NguyenLieu.addColumnSelectionInterval(col, col);
                selectedRows.add(row);
                selectedCols.add(col);
            }
        }
    }//GEN-LAST:event_tbl_NguyenLieuMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DonGia_lbl;
    private javax.swing.JLabel Ma_lbl;
    private javax.swing.JScrollPane NL_Table;
    private javax.swing.JLabel NgayNhap_lbl;
    private javax.swing.JLabel NguyenLieu_lbl;
    private javax.swing.JLabel SoLuong_lbl;
    private javax.swing.JButton bttCapNhat;
    private javax.swing.JButton bttNhap;
    private javax.swing.JButton bttXoa;
    private javax.swing.JButton bttXoaNhap;
    private javax.swing.JMenu btt_QLMonAn;
    private javax.swing.JMenu btt_QLNguyenLieu;
    private javax.swing.JMenu btt_QLNhanVien;
    private javax.swing.JMenu btt_QLSuatAn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable tbl_NguyenLieu;
    private javax.swing.JTextField txt_DonGia;
    private javax.swing.JTextField txt_MaNguyenLieu;
    private com.toedter.calendar.JDateChooser txt_NgayNhap;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_SoLuong;
    private javax.swing.JTextField txt_TenNguyenLieu;
    // End of variables declaration//GEN-END:variables

    
}
