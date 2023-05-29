/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package View.Palette.Header;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author anhtu
 */
public class HeaderMA extends DefaultTableCellRenderer {
    public HeaderMA() {
        setOpaque(false);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int rowIndex, int columnIndex) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, rowIndex, columnIndex);

            // Thiết lập font, màu chữ và border cho header
            setFont(new Font("sanserif", Font.BOLD, 14));
            setForeground(Color.BLACK);
            setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    
            return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Lấy độ rộng và chiều cao của header để tạo GradientPaint
        int w = getWidth();
        int h = getHeight();

        // Tạo GradientPaint với màu xanh dương ở trên cùng và màu trắng ở dưới cùng
        GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#66CCFF"), 0, h, Color.WHITE);

        g2.setPaint(gradient);
        g2.fillRect(0, 0, w, h);

        g2.dispose();
        super.paintComponent(g);
    }
}
