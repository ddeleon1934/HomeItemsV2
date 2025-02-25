import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class HomeItemRepository {
    private ArrayList<HomeItem> items;
    private final String jsonFile = "home_inventory.json"; // Updated file name
    // Constructor now loads items from JSON
    public HomeItemRepository(){
        loadItems();
    }
    // Load items from the JSON file; if it doesn't exist, create with default data
    private void loadItems() {
        try {
            FileReader reader = new FileReader(jsonFile);
            Type itemListType = new TypeToken<ArrayList<HomeItem>>(){}.getType();
            items = new Gson().fromJson(reader, itemListType);
            reader.close();
            if (items == null) {
                items = new ArrayList<>();
            }
        } catch (IOException e) {
            // File doesn't exist or error reading; initialize with default items
            items = new ArrayList<>();
            items.add(new HomeItem( "Laptop", "Dell", "Electronics", 2));
            items.add(new HomeItem( "Office Chair", "Herman Miller", "Furniture", 5));
            items.add(new HomeItem( "Blender", "Ninja", "Kitchen", 3));
            items.add(new HomeItem( "TV", "Samsung", "Electronics", 1));
            items.add(new HomeItem( "Desk Lamp", "Philips", "Lighting", 4));
            items.add(new HomeItem( "Vacuum Cleaner", "Dyson", "Appliances", 2));
            saveItems(); // Save the default list to create the file
        }
    }
    private void saveItems() {
        try (FileWriter writer = new FileWriter(jsonFile)) {
            new Gson().toJson(items, writer);
        } catch (IOException e) {
            System.out.println("Error saving items: " + e.getMessage());
        }
    }
    public void searchByName(String name) {
        int itemsFound = 0;
        for(HomeItem item : items) {
            if(item.getName().toLowerCase().contains(name.toLowerCase())) {
                itemDetails(item);
                itemsFound++;
            }
        }
        System.out.printf("\n%d Item%s Found.\n", itemsFound, itemsFound > 1 ? "s" : "");
    }
    public boolean searchByCategory(String category){
        int itemsFound = 0;
        for(HomeItem item : items) {
            if(item.getCategory().equalsIgnoreCase(category)) {
                itemDetails(item);
                itemsFound++;
            }
        }
        System.out.printf("\n%d Item%s Found.\n", itemsFound, itemsFound > 1 ? "s" : "");
        return itemsFound > 0;
    }
    public void itemDetails(HomeItem item) {
        System.out.println("\n+> Item details: \n");
        System.out.println("\tName: " + item.getName() +
                "\n\tBrand: " + item.getBrand() +
                "\n\tCategory: " + item.getCategory() +
                "\n\tQuantity: " + item.getQuantity());
    }
    public void addItem(HomeItem item) {
        items.add(item);
        saveItems();
    }
    public boolean editItem(String itemName, int field, String newValue) {
        for (HomeItem item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                switch (field) {
                    case 1: // Edit Name
                        item.setName(newValue);
                        break;
                    case 2: // Edit Brand
                        item.setBrand(newValue);
                        break;
                    case 3: // Edit Category
                        item.setCategory(newValue);
                        break;
                    case 4: // Edit Quantity
                        try {
                            int qty = Integer.parseInt(newValue);
                            item.setQuantity(qty);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid quantity entered. Edit aborted.");
                            return false;
                        }
                        break;
                    default:
                        System.out.println("Invalid field selection.");
                        return false;
                }
                saveItems();
                return true;
            }
        }
        return false;
    }
    public boolean removeItem(String name) {
        Iterator<HomeItem> iter = items.iterator();
        while (iter.hasNext()) {
            HomeItem item = iter.next();
            if (item.getName().equalsIgnoreCase(name)) {
                iter.remove();
                saveItems();
                return true;
            }
        }
        return false;
    }
    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("No items available.");
        } else {
            System.out.printf("%-20s %-15s %-15s %-10s%n", "Name", "Brand", "Category", "Quantity");
            System.out.println("---------------------------------------------------------------------");
            for (HomeItem item : items) {
                System.out.printf("%-20s %-15s %-15s %-10d%n",
                        item.getName(), item.getBrand(), item.getCategory(), item.getQuantity());
            }
        }
    }
}
