// Package untuk kelas view
package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

// Kelas ini mengatur tampilan utama aplikasi
public class MainView extends JFrame {
    private JTable itemTable;
    private JButton btnAddItem, btnUpdateStatus;

    public MainView() {
        setTitle("Manajemen Sumber Daya Prodi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        itemTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(itemTable);

        btnAddItem = new JButton("Add Item");
        btnUpdateStatus = new JButton("Update Status");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAddItem);
        buttonPanel.add(btnUpdateStatus);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Method untuk mendapatkan tabel barang
    public JTable getItemTable() {
        return itemTable;
    }

    // Method untuk mengatur data pada tabel
    public void setItemTableData(Object[][] data, String[] columnNames) {
        itemTable.setModel(new DefaultTableModel(data, columnNames));
    }

    // Listener untuk tombol tambah barang
    public void addAddItemListener(ActionListener listener) {
        btnAddItem.addActionListener(listener);
    }

    // Listener untuk tombol perbarui status barang
    public void addUpdateStatusListener(ActionListener listener) {
        btnUpdateStatus.addActionListener(listener);
    }
}
