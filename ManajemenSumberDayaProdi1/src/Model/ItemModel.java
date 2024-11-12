// Package untuk kelas model
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Kelas ini mengatur operasi CRUD untuk data barang/ruangan
public class ItemModel {
    private int id;
    private String name;
    private String type;
    private String status;
    private String description;

    // Constructor
    public ItemModel(int id, String name, String type, String status, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.description = description;
    }

    // Getter dan Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // Static methods untuk operasi CRUD
    public static List<ItemModel> getAllItems() {
        List<ItemModel> items = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM items")) {
            while (rs.next()) {
                items.add(new ItemModel(rs.getInt("id"), rs.getString("name"),
                        rs.getString("type"), rs.getString("status"),
                        rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void addItem(ItemModel item) {
        String sql = "INSERT INTO items (name, type, status, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getType());
            stmt.setString(3, item.getStatus());
            stmt.setString(4, item.getDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateItemStatus(int id, String status) {
        String sql = "UPDATE items SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
