# Welcome to the Electronics store Java Project!
# Group: 
- SE-2216
# Team Members:
- Abylai Taitoleuov
- Damir Asainov

# Project Overview:
The hardware store system is a comprehensive solution designed to manage and facilitate the sale of electronic products. It provides a seamless platform for customers to explore, purchase, and share feedback on a variety of electronic items.

## Purpose:
The primary goal is to offer customers a user-friendly interface for interacting with the hardware store, ensuring a smooth experience from product discovery to purchase and post-purchase feedback.

## Objectives:

### Display Products:
- Present a list of available electronic products.

### Purchase and Payment:
- Enable customers to select and purchase products.
- Provide various payment methods for flexibility.

### Feedback System:
- Allow customers to leave feedback on purchased products.

# Main Body:

## Features and Design Patterns:

### 1. Feedback System:
- **Classes:** `DefaultFeedbackSystem`, `FeedbackInterface`
- **Description:** Handles customer feedback.
- **Usage:** Utilized in the `StoreFeedbackAdapter` to adapt feedback for the store.

### 2. Product Management:
- **Classes:** `Product`, `ProductManagement`, `ProductManager`
- **Description:** Manages the creation, storage, and retrieval of products.
- **Usage:** Employed in various system components to handle products.

### 3. Decorator Pattern:
- **Classes:** `DiscountDecorator`, `GiftDecorator`, `ProductDecorator`, `BaseProduct`
- **Description:** In the context of the hardware store system, the Decorator pattern is employed to enhance products with additional functionalities, such as discounts and gifts, without modifying their core structure.
- **Usage:** The Decorator pattern is applied to extend the functionality of products dynamically. Each decorator class adds a specific behavior, such as discounts or gifts, to the base product. The decorated products can then be used interchangeably with the base products, and clients can combine multiple decorators to create a product with multiple functionalities.

### 4. Observer Pattern:
- **Classes:** `Customer`, `Observer`, `StoreNotifier`
- **Description:** The Observer pattern is a behavioral design pattern where an object, known as the subject, maintains a list of its dependents, called observers. The subject notifies the observers of any state changes, typically by calling one of their methods. This pattern establishes a one-to-many relationship between the subject and its observers, allowing multiple objects to listen and react to changes in the subject's state.
- **Usage:** The Observer pattern is employed to implement a notification system where customers (observers) can subscribe to receive updates from the store (subject). When there are changes in the store, such as discounts or gifts being applied to products, the StoreNotifier notifies all subscribed customers by calling their update method. This enables customers to stay informed about ongoing promotions or special offers. The Observer pattern helps decouple the store's logic from the notification mechanism, promoting flexibility and maintainability in the system.

### 5. Strategy Pattern:
- **Classes:** `CreditCardPayment`, `ElectronicStore`, `KaspiPayment`, `PayPalPayment`, `PaymentStrategy`
- **Description:** In the context of the hardware store system, the Strategy pattern is applied to handle payment processing by allowing different payment strategies to be defined and seamlessly switched.
- **Usage:**  In the hardware store system facilitates flexibility in choosing and applying different payment strategies. Clients, such as the electronic store or external entities, can dynamically select a payment strategy, allowing the system to adapt to various payment methods without modifying the core logic.

### 6. Factory Pattern:
- **Classes:** `LaptopFactory`, `PhoneFactory`, `TVFactory`, `ProductFactory`
- **Description:** In the context of the hardware store system, the Factory pattern is employed to abstract the process of product creation, allowing flexibility and extensibility when introducing new product types.
- **Usage:** The usage of the Factory pattern in the hardware store system is exemplified through the creation of specific product instances. Clients, such as the system's product management module or external entities, interact with the respective factory classes to obtain instances of desired product types. This approach decouples the client code from the specifics of object creation, promoting a modular and maintainable system.

### 7. Singleton Pattern:
- **Class:** `Database`
- **Description:** Implements the Singleton pattern to ensure a single instance of the database is created and accessed throughout the application's lifecycle.
- **Usage:**
  Accessed through the static method `getInstance()`, ensuring only one instance of the database exists.
  The singleton instance is utilized in various parts of the system, providing a centralized point for product management.
  The `Database` class is used to manage the product database.

## UML Diagram:
[Include a UML diagram illustrating the relationships between classes and design patterns.]

# Conclusion:

## Key Points:
- The project incorporates various design patterns, including Decorator, Observer, Strategy, and Factory patterns.

## Project Outcomes:
- Successful implementation of a hardware store system.

## Challenges Faced:
- [Specify any challenges faced during development.]

## Future Improvements:
- [Suggestions for future enhancements, optimizations, or additional features.]
