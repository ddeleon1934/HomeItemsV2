public class HomeInventoryApp {
    HomeItemRepository repo = new HomeItemRepository();
    public void findByName(String name) {
        repo.searchByName(name);
    }
    public boolean findByCategory(String category) {
        return repo.searchByCategory(category);
    }
    public void addItem(HomeItem item) {
        repo.addItem(item);
    }
    public boolean editItem(String name, int field, String newValue) {
        return repo.editItem(name, field, newValue);
    }
    public boolean removeItem(String name) {
        return repo.removeItem(name);
    }
    public void viewAllItems() {
        repo.viewItems();
    }
}
