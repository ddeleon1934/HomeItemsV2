import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static HomeInventoryApp app = new HomeInventoryApp();

    public static void main(String[] args) {
        int userChoice = 0;
        System.out.println("-----Welcome to the Home Inventory!-----\n");
        do {
            System.out.println("\n-----------------------------------");
            System.out.println("1. Search item by Name keyword.");
            System.out.println("2. Search item by Category.");
            System.out.println("3. Add a New Item");
            System.out.println("4. Edit an Item");
            System.out.println("5. Remove an Item");
            System.out.println("6. View all Items");
            System.out.println("7. Exit from the inventory system.");
            System.out.println("-----------------------------------");
            System.out.print("\nChoose any option: ");

            userChoice = scan.nextInt();
            scan.nextLine(); // consume newline

            switch(userChoice) {
                case 1:
                    System.out.print("Enter the Name of the item: ");
                    app.findByName(scan.nextLine());
                    break;
                case 2:
                    System.out.print("Enter Category: ");
                    app.findByCategory(scan.nextLine());
                    break;
                case 3:
                    addNewItem();
                    break;
                case 4:
                    editExistingItem();
                    break;
                case 5:
                    removeExistingItem();
                    break;
                case 6:
                    app.viewAllItems();
                    break;
                case 7:
                    System.out.println("\nThanks for using the inventory system. \nSee you again.");
                    break;
                default:
                    System.out.println("\nInvalid Choice!");
            }
        } while(userChoice != 7);
    }
    private static void addNewItem() {
        scan.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = scan.nextLine();
        System.out.print("Enter Brand: ");
        String brand = scan.nextLine();
        System.out.print("Enter Category: ");
        String category = scan.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scan.nextInt();
        // For a new item, assume zero are in use
        HomeItem newItem = new HomeItem( name, brand, category, quantity);
        app.addItem(newItem);
        System.out.println("Item added successfully.");
    }
    private static void editExistingItem() {
        System.out.print("Enter the Name of the item to edit: ");
        String name = scan.nextLine();
        System.out.println("Which field would you like to edit?");
        System.out.println("1. Name");
        System.out.println("2. Brand");
        System.out.println("3. Category");
        System.out.println("4. Quantity");
        System.out.print("Enter option number: ");
        int field = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter the new value: ");
        String newValue = scan.nextLine();

        if (app.editItem(name, field, newValue)) {
            System.out.println("Item updated successfully.");
        } else {
            System.out.println("Item update failed. Please check your input.");
        }
    }
    private static void removeExistingItem() {
        System.out.print("Enter the Name of the item to remove: ");
        String name = scan.nextLine();
        if (app.removeItem(name))
            System.out.println("Item removed successfully.");
        else
            System.out.println("Item with Name \"" + name + "\" not found.");
    }
}
