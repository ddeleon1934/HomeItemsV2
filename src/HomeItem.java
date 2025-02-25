public class HomeItem {
    private String name;
    private String brand;
    private String category;
    private int quantity;

    // No-argument constructor required for JSON deserialization
    public HomeItem() {
    }
    public HomeItem(String name, String brand, String category, int quantity) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
    }
    public String getName() {
        return name; }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {  return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }


}
