package manajemensumberdayaprodi1;

// Tidak berada di package khusus (package utama)

import view.MainView;
import Controller.ItemController;

// Kelas ini adalah titik masuk utama untuk menjalankan aplikasi
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainView view = new MainView();
            new ItemController(view);
            view.setVisible(true);
        });
    }
}
