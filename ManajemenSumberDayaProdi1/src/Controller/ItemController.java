// Package untuk kelas controller
package Controller;

import view.MainView;
import model.ItemModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Kelas ini mengatur logika aplikasi dan menghubungkan model dengan view
public class ItemController {
    private MainView view;

    public ItemController(MainView view) {
        this.view = view;

        // Tambahkan listener untuk aksi
        view.addAddItemListener(new AddItemListener());
        view.addUpdateStatusListener(new UpdateStatusListener());
        loadItemsToView();
    }

    // Method untuk memuat data barang ke view
    private void loadItemsToView() {
        List<ItemModel> items = ItemModel.getAllItems();
        Object[][] data = new Object[items.size()][4];
        for (int i = 0; i < items.size(); i++) {
            data[i][0] = items.get(i).getId();
            data[i][1] = items.get(i).getName();
            data[i][2] = items.get(i).getType();
            data[i][3] = items.get(i).getStatus();
        }
        view.setItemTableData(data, new String[]{"ID", "Name", "Type", "Status"});
    }

    // Listener untuk aksi menambah barang
    class AddItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logika untuk menambahkan barang baru
        }
    }

    // Listener untuk aksi memperbarui status barang
    class UpdateStatusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logika untuk memperbarui status barang
        }
    }
}
