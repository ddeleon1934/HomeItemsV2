# Home Inventory App

The Home Inventory App is a simple Java-based console application designed to help you manage your home inventory. It allows you to add, search, edit, and remove items, and it persists data using JSON. The app is structured with a clean separation of concerns, making it easy to maintain and extend.

## Features

- **Add New Items:** Add inventory items with details such as name, brand, category, and quantity.
- **Search Items:** Search by item name or category.
- **Edit Items:** Modify existing items by updating their name, brand, category, or quantity.
- **Remove Items:** Remove items from your inventory.
- **View All Items:** Display all items in a formatted table.
- **JSON Persistence:** Save and load your inventory data from a JSON file.

## Project Structure

The application is organized into four main classes, each with a distinct responsibility:

### 1. HomeItem

- **Purpose:**  
  Represents the data model for an inventory item.

- **Key Attributes:**  
  - `name`
  - `brand`
  - `category`
  - `quantity`

- **Functionality:**  
  Contains constructors, getters, and setters for its attributes.

- **Description:**  
  An object that encapsulates the essential details of an inventory item.

---

### 2. HomeItemRepository

- **Purpose:**  
  Manages data persistence and retrieval for inventory items.

- **Key Functions:**  
  - Loading and saving items from/to a JSON file.
  - Searching for items by name or category.
  - Adding, editing, and removing items.

- **Functionality:**  
  Acts as the data access layer by handling file I/O operations and maintaining the collection of items.

- **Description:**  
  This class isolates the data management logic from other parts of the app, making it easier to manage and extend the persistence mechanism.

---

### 3. HomeInventoryApp

- **Purpose:**  
  Serves as the service layer, acting as an intermediary between the user interface and the repository.

- **Key Functions:**  
  - Wrapping repository calls to provide higher-level operations.
  - Potentially incorporating additional business logic (e.g., validation, alerts, logging) in the future.

- **Functionality:**  
  Currently, it passes user requests (such as search, add, edit, and remove) from the UI to the repository. It’s designed to facilitate future enhancements.

- **Description:**  
  Although thin now, this layer is the ideal place to add extra business logic as your app evolves.

---

### 4. Main

- **Purpose:**  
  Provides the console-based user interface and serves as the application entry point.

- **Key Functions:**  
  - Displaying a menu of options.
  - Accepting and processing user input.
  - Delegating operations to the HomeInventoryApp service layer.

- **Functionality:**  
  Uses a `Scanner` for input and a switch-case structure to handle different operations like searching, adding, editing, removing, and viewing items.

- **Description:**  
  The Main class creates a simple and intuitive text-based interface that allows users to interact with the inventory system.

## Getting Started

### Prerequisites

- **Java JDK 8 or later:** Ensure you have the appropriate JDK installed.
- **Maven/IDE:** Use Maven or your favorite IDE (like IntelliJ IDEA or Eclipse) for building and running the project.

### Running the App

1. **Clone the Repository:**  
   Download or clone the project to your local machine.

2. **Build the Project:**  
   Use Maven or your IDE to compile the project.

3. **Run the Application:**  
   Run the `Main` class to start the console-based interface.


## Screenshots
![Screenshot 2025-02-25 153146- 2-25a](https://github.com/user-attachments/assets/705b2c68-1cbd-4b61-9667-4109e75ae593)

![Screenshot 2025-02-25 153146- 2-25b](https://github.com/user-attachments/assets/006e6aa4-8064-4376-8d4d-0871d0060f67)

![image](https://github.com/user-attachments/assets/f3f030a3-68fd-4000-8389-919a23dc53c9)

## Future Enhancements

- **Graphical User Interface:**  
  Integrate a JavaFX UI for a more modern and user-friendly desktop experience.

- **Advanced Business Logic:**  
  Expand the service layer to include features such as input validation, low-stock alerts, logging, and reporting.

- **Data Export/Import:**  
  Implement functionality to export or import inventory data in different formats.

## Conclusion

The Home Inventory App provides a solid foundation for managing a home inventory, with a clean separation between data modeling, data persistence, business logic, and user interface. This structure makes the app both easy to maintain and scalable for future enhancements.

Happy coding!

