/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.MonAnDAO;
import Controller.SuatAnDAO;
import Model.MonAn;
import Model.SuatAn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author anhtu
 */
public class QLSuatAnView extends javax.swing.JFrame implements ActionListener{
    private SuatAn suatAn;
    private ArrayList<SuatAn> list = new SuatAnDAO().getListSA();
    private TableActionEvent evDialog;
    
    /**
     * Creates new form QLSuatAnView
     */
    public QLSuatAnView() {
        initComponents();   
        //Add Event button
        btt_ThemSuatAn.addActionListener(this);
        btt_XoaSuatAn.addActionListener(this);
        dialogbtt_Save.addActionListener(this);
        dialogbtt_Delete.addActionListener(this);
        dialogbtt_Reset.addActionListener(this);
        
        evDialog = new TableActionEvent() {
            @Override
            public void Increment(int row) {
                boolean flag = false;
                String id = (String)dialogtbl_DSMA.getValueAt(row, 2);
                DefaultTableModel model = (DefaultTableModel) dialogtbl_MonAnSA.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    String tmp = (String) model.getValueAt(i, 3);
                    int quantity = (int) model.getValueAt(i, 2);
                    if (tmp.equals(id)) {
                        // Nếu tìm thấy giá trị mong muốn, thực hiện cập nhật
                        model.setValueAt(quantity + 1, i, 2);
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    String tenMon = (String)dialogtbl_DSMA.getValueAt(row, 0);
                    double donGia = (double)dialogtbl_DSMA.getValueAt(row, 1);
                    model.addRow(new Object[]{
                        tenMon, donGia, 1, id
                    });
                }
            }

            @Override
            public void Decrement(int row) {
                String id = (String)dialogtbl_DSMA.getValueAt(row, 2);
                TableModel model = dialogtbl_MonAnSA.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    String tmp = (String) model.getValueAt(i, 3);
                    int quantity = (int) model.getValueAt(i, 2);
                    if (tmp.equals(id)) {
                        // Nếu tìm thấy giá trị mong muốn, thực hiện cập nhật
                        if(quantity - 1 < 0) quantity += 1;
                            model.setValueAt(quantity - 1, i, 2);
                        break;
                    }
                }
            }
        };
        
        load();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialog_MonAnSuatAn = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dialogtbl_MonAnSA = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        txt_SearchMASA = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        dialogbtt_Delete = new javax.swing.JButton();
        dialogbtt_Reset = new javax.swing.JButton();
        dialogbtt_Save = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        dialogtbl_DSMA = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txt_SearchDSMA = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
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

        dialog_MonAnSuatAn.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dialog_MonAnSuatAnWindowClosing(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 3, true));

        dialogtbl_MonAnSA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên Món Ăn", "Đơn Giá", "Số Lượng", "Mã"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dialogtbl_MonAnSA.setColumnSelectionAllowed(true);
        dialogtbl_MonAnSA.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(dialogtbl_MonAnSA);
        dialogtbl_MonAnSA.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (dialogtbl_MonAnSA.getColumnModel().getColumnCount() > 0) {
            dialogtbl_MonAnSA.getColumnModel().getColumn(0).setResizable(false);
            dialogtbl_MonAnSA.getColumnModel().getColumn(1).setResizable(false);
            dialogtbl_MonAnSA.getColumnModel().getColumn(2).setResizable(false);
            dialogtbl_MonAnSA.getColumnModel().getColumn(3).setResizable(false);
        }
        dialogtbl_MonAnSA.getColumnModel().getColumn(3).setMinWidth(0);
        dialogtbl_MonAnSA.getColumnModel().getColumn(3).setMaxWidth(0);

        ListSelectionModel dialogSelectionModel = dialogtbl_MonAnSA.getSelectionModel();

        dialogSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!dialogSelectionModel.isSelectionEmpty()) {
                    if(e.getValueIsAdjusting()){
                        dialogbtt_Delete.setEnabled(true);
                        int selectedRow = dialogtbl_MonAnSA.getSelectedRow();
                        if(selectedRow != -1){
                            //lấy dữ liệu
                            Object ten = dialogtbl_MonAnSA.getValueAt(selectedRow, 0);
                            //gán dữ liệu
                            txt_SearchDSMA.setText(ten.toString());
                        }
                    }
                }else {
                    txt_SearchDSMA.setText("");
                    dialogbtt_Delete.setEnabled(false);
                }
            }
        });

        TableModelListener tableModelListener = new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // setEnable button
                dialogbtt_Reset.setEnabled(true);
                //
                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 2) {
                    int row = e.getFirstRow();
                    int quantity = Integer.parseInt(dialogtbl_MonAnSA.getValueAt(row, 2).toString());
                    if (quantity == 0) {
                        ((DefaultTableModel) dialogtbl_MonAnSA.getModel()).removeRow(row);
                    }
                }
            }
        };

        dialogtbl_MonAnSA.getModel().addTableModelListener(tableModelListener);

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 2, true));

        txt_SearchMASA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));
        txt_SearchMASA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchMASAKeyReleased(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jLabel8.setToolTipText("");
        jLabel8.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_SearchMASA)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_SearchMASA, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogbtt_Delete.setText("Xóa Món Ăn");

        dialogbtt_Reset.setText("Hoàn Tác");

        dialogbtt_Save.setText("Lưu Thay Đổi");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dialogbtt_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dialogbtt_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dialogbtt_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dialogbtt_Save)
                        .addComponent(dialogbtt_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dialogbtt_Reset))
                .addContainerGap())
        );

        dialogtbl_MonAnSA.getColumnModel().getColumn(3).setMinWidth(0);
        dialogtbl_MonAnSA.getColumnModel().getColumn(3).setMaxWidth(0);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dialogtbl_DSMA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Món Ăn", "Đơn Giá", "Mã", "Thao Tác"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dialogtbl_DSMA.setRowHeight(40);
        dialogtbl_DSMA.getTableHeader().setReorderingAllowed(false);
        dialogtbl_DSMA.getColumnModel().getColumn(2).setMinWidth(0);
        dialogtbl_DSMA.getColumnModel().getColumn(2).setMaxWidth(0);
        scrollPane.setViewportView(dialogtbl_DSMA);
        if (dialogtbl_DSMA.getColumnModel().getColumnCount() > 0) {
            dialogtbl_DSMA.getColumnModel().getColumn(0).setResizable(false);
            dialogtbl_DSMA.getColumnModel().getColumn(1).setResizable(false);
            dialogtbl_DSMA.getColumnModel().getColumn(2).setResizable(false);
            dialogtbl_DSMA.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 2, true));

        txt_SearchDSMA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));
        txt_SearchDSMA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchDSMAKeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jLabel9.setToolTipText("");
        jLabel9.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_SearchDSMA)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_SearchDSMA, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dialog_MonAnSuatAnLayout = new javax.swing.GroupLayout(dialog_MonAnSuatAn.getContentPane());
        dialog_MonAnSuatAn.getContentPane().setLayout(dialog_MonAnSuatAnLayout);
        dialog_MonAnSuatAnLayout.setHorizontalGroup(
            dialog_MonAnSuatAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialog_MonAnSuatAnLayout.setVerticalGroup(
            dialog_MonAnSuatAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialog_MonAnSuatAn.pack();
        dialog_MonAnSuatAn.setLocationRelativeTo(null);

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
                }else{
                    btt_XoaSuatAn.setEnabled(false);
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

    /*
     * Events Controller
     */    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btt_ThemSuatAn) {
            btt_ThemSuatAnClicked();
        } else if (e.getSource() == btt_XoaSuatAn) {
            btt_XoaSuatAnClicked();
        } else if (e.getSource() == dialogbtt_Save) {
            dialogbtt_SaveClicked();
        } else if (e.getSource() == dialogbtt_Delete) {
            dialogbtt_DeleteClicked();
        } else if (e.getSource() == dialogbtt_Reset) {
            dialogbtt_ResetClicked();
        }
    }

    public void btt_ThemSuatAnClicked(){
        suatAn = new SuatAn();
        if(new SuatAnDAO().ThemSuatAn(suatAn)) {
            JOptionPane.showMessageDialog(rootPane, "Thêm suất ăn thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            dialog_MonAnSuatAn.setVisible(true);
            loadTableSA();
            String ma = tbl_SuatAn.getValueAt(tbl_SuatAn.getRowCount()-1, 0).toString();
            int MA = Integer.parseInt(ma);
            loadTableMonAnSuatAn(MA);
            loadTableDSMA();
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
    
    public void dialogbtt_SaveClicked(){
        TableModel model = dialogtbl_MonAnSA.getModel();
        //Cập Nhật
        int MaSA = getMaSA();
        boolean flag = true;
        for (int i = 0; i < model.getRowCount(); i++) {
            String MaMA = (String) model.getValueAt(i, 3);
            Integer sl = Integer.valueOf(model.getValueAt(i, 2).toString());
            int soLuong = sl.intValue();
            if(!new SuatAnDAO().updateOrInsertListMASA(MaSA, MaMA, soLuong)){
                flag = false;
            }
        }
        
        if(flag) {
            JOptionPane.showMessageDialog(rootPane, "Cập Nhật thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            dialogbtt_ResetClicked();
            loadTableDSMA();
            //Cap nhat trong Model
            CapNhatMonAn(MaSA);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cập Nhật không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void dialogbtt_DeleteClicked(){
        DefaultTableModel model = (DefaultTableModel) dialogtbl_MonAnSA.getModel();
        int rowIndex = dialogtbl_MonAnSA.getSelectedRow();
        int maSA = getMaSA();
        String maMAStr = model.getValueAt(rowIndex, 3).toString();
        if(new SuatAnDAO().deleteRow(maSA,maMAStr)) {
            JOptionPane.showMessageDialog(rootPane, "Xóa Thành Công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            
            //Update
            model = (DefaultTableModel) dialogtbl_MonAnSA.getModel();
            int selectedIndex = dialogtbl_MonAnSA.getSelectedRow();
            if(selectedIndex >= 0){
                model.removeRow(selectedIndex);
                dialogbtt_ResetClicked();
            }
        } else {
          JOptionPane.showMessageDialog(rootPane, "Xóa Không Thành Công", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void dialogbtt_ResetClicked(){
        ArrayList<MonAn> list = new SuatAnDAO().getListMA(getMaSA());
        DefaultTableModel model = (DefaultTableModel) dialogtbl_MonAnSA.getModel();
        model.setRowCount(0);
        int n = list.size()-1;
        for(int i = 0 ; i <= n; i++){
            MonAn tmp = list.get(i);
            model.addRow(new Object[]{
                tmp.getTenMon(), tmp.getdongia(), tmp.getSoLuong(), tmp.getMaMon()
            });
        }
    }
    
//Model 
    public void CapNhatMonAn(int maSA){
        SuatAn tmp;
        for (SuatAn SA : list) {
            if(SA.getMaSuatAn() == maSA){
                tmp = SA;
            }
        }
        
        
    }
//
//Chức năng hỗ trợ
    
    private int getMaSA(){
        String tmp = dialog_MonAnSuatAn.getTitle();
        int num = Integer.parseInt(tmp.replaceAll("[^0-9]", ""));
        return num;
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

    private void loadTableMonAnSuatAn(int MA){
        dialogbtt_Delete.setEnabled(false);
        dialogbtt_Reset.setEnabled(false);
        dialog_MonAnSuatAn.setTitle("Suất ăn " + MA);
        ArrayList<MonAn> list = new SuatAnDAO().getListMA(MA);
        DefaultTableModel model = (DefaultTableModel) dialogtbl_MonAnSA.getModel();
        model.setRowCount(0);
        int n = list.size()-1;
        for(int i = 0 ; i <= n; i++){
            MonAn tmp = list.get(i);
            model.addRow(new Object[]{
                tmp.getTenMon(), tmp.getdongia(), tmp.getSoLuong(), tmp.getMaMon()
            });
        }
    }

    public void loadTableDSMA(){
        ArrayList<MonAn> list = new SuatAnDAO().getListDSMA();
        DefaultTableModel model = (DefaultTableModel) dialogtbl_DSMA.getModel();
        model.setRowCount(0);
        int n = list.size()-1;
        for(int i = 0 ; i <= n; i++){
            MonAn tmp = list.get(i);
            model.addRow(new Object[]{
                tmp.getTenMon(), tmp.getdongia(), tmp.getMaMon()
            });
        }
        dialogtbl_DSMA.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        dialogtbl_DSMA.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(evDialog));
    }

    public void enableButtMF(){
        btt_ThemSuatAn.setEnabled(true);
        btt_XoaSuatAn.setEnabled(true);
    }

    public void disableButtMF(){
        btt_ThemSuatAn.setEnabled(false);
        btt_XoaSuatAn.setEnabled(false);
    }
//
    
//Events Hỗ Trợ
    
    private void dialog_MonAnSuatAnWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialog_MonAnSuatAnWindowClosing
        enableButtMF();
    }//GEN-LAST:event_dialog_MonAnSuatAnWindowClosing

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
            dialog_MonAnSuatAn.setVisible(true);
            String ma = tbl_SuatAn.getValueAt(row, 0).toString();
            int MA = Integer.parseInt(ma);
            loadTableMonAnSuatAn(MA);
            loadTableDSMA();
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

    private void txt_SearchDSMAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchDSMAKeyReleased
        String keyword = txt_SearchDSMA.getText().toLowerCase(); 
        DefaultTableModel tableModel = (DefaultTableModel) dialogtbl_DSMA.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel); 
        dialogtbl_DSMA.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
    }//GEN-LAST:event_txt_SearchDSMAKeyReleased

    private void txt_SearchMASAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchMASAKeyReleased
        String keyword = txt_SearchMASA.getText().toLowerCase(); 
        DefaultTableModel tableModel = (DefaultTableModel) dialogtbl_MonAnSA.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel); 
        dialogtbl_MonAnSA.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
    }//GEN-LAST:event_txt_SearchMASAKeyReleased
    
    //Table Danh Sach Mon An Dialog
    
//Tạo Panel Chứa Button + Events
    public class PanelAction extends javax.swing.JPanel {
        public PanelAction() {
            initComponents2();
        }
      
        public void initEvents(TableActionEvent event, int row){
            btt_Plus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    event.Increment(row);
                }
            });
            
            btt_Minus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    event.Decrement(row);
                }
            });
        }
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents2() {

            btt_Plus = new ActionButton();
            btt_Minus = new ActionButton();

            btt_Plus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus.png"))); // NOI18N
            btt_Plus.setAlignmentX(0.5F);
            btt_Plus.setMaximumSize(new java.awt.Dimension(32, 32));
            btt_Plus.setMinimumSize(new java.awt.Dimension(32, 32));
            btt_Plus.setPreferredSize(new java.awt.Dimension(32, 32));

            btt_Minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minus.png"))); // NOI18N
            btt_Minus.setMaximumSize(new java.awt.Dimension(32, 32));
            btt_Minus.setMinimumSize(new java.awt.Dimension(32, 32));
            btt_Minus.setPreferredSize(new java.awt.Dimension(32, 32));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btt_Plus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btt_Minus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btt_Minus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btt_Plus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }// </editor-fold>                                           
        private ActionButton btt_Minus;
        private ActionButton btt_Plus;                 
    }
    
    public class ActionButton extends JButton{
        private boolean mousePress;
        public ActionButton(){
            setContentAreaFilled(false);
            setBorder(new EmptyBorder(3, 3, 3, 3));
            addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e) {
                    mousePress = true;
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    mousePress = false;
                }              
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int width = getWidth();
            int height = getHeight();
            int size = Math.min(width, height);
            int x = (width - size)/2;
            int y = (height - size)/2;
            if(mousePress){
                g2.setColor(new Color(158, 158, 158));
            }else{
                 g2.setColor(new Color(199, 199, 199));
            }
            g2.fill(new Ellipse2D.Double(x, y, size, size));
            g2.dispose();
            super.paintComponent(g);
        }
    }
//   
    
//Thiết lập Editor, Renderer, ActionEvents
    public class TableActionCellEditor extends DefaultCellEditor{
        
        private TableActionEvent event;
        public TableActionCellEditor(TableActionEvent event) {
            super(new JCheckBox());
            this.event = event;
        }
        
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            PanelAction action = new PanelAction();
            action.initEvents(event, row);
            return action;
        }
    }
    public class TableActionCellRender extends DefaultTableCellRenderer{
        public TableActionCellRender() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            PanelAction action = new PanelAction();
            if(!isSelected && row % 2 == 0){
                action.setBackground(Color.WHITE);
            }else{
                action.setBackground(com.getBackground());
            }
            action.setBackground(com.getBackground());
            return action;
        }  
    }
    public interface TableActionEvent {
        public void Increment(int row);
        public void Decrement(int row);
    }
//    
    
/*//*/ 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btt_QLMonAn;
    private javax.swing.JMenu btt_QLNguyenLieu;
    private javax.swing.JMenu btt_QLNhanVien;
    private javax.swing.JMenu btt_QLSuatAn;
    private javax.swing.JButton btt_ThemSuatAn;
    private javax.swing.JButton btt_XoaSuatAn;
    private javax.swing.JDialog dialog_MonAnSuatAn;
    private javax.swing.JButton dialogbtt_Delete;
    private javax.swing.JButton dialogbtt_Reset;
    private javax.swing.JButton dialogbtt_Save;
    private javax.swing.JTable dialogtbl_DSMA;
    private javax.swing.JTable dialogtbl_MonAnSA;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tbl_SuatAn;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_SearchDSMA;
    private javax.swing.JTextField txt_SearchMASA;
    // End of variables declaration//GEN-END:variables

}
