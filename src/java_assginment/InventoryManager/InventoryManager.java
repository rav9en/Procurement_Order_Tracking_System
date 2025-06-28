/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java_assginment.InventoryManager;

public class InventoryManager {
    public static void main(String[] args) {
        Item.savePredefinedItemsToFile("src/User_data/items.txt");
        Supplier.savePredefinedSuppliersToFile("src/User_data/suppliers.txt");
    }
}