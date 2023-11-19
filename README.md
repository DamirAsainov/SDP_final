# Welcome to the Hardware store Java Project!
# Group: 
- SE-2216
# Team Members:
- Abylai Taitoleuov
- Damir Asainov

# Project Overview:
Our project revolves around the creation of a comprehensive hardware store system, designed to manage and facilitate the sale of electronic products. The primary purpose is to provide a seamless platform for customers to explore, purchase, and share feedback on a variety of electronic items. 

## Purpose:
The primary goal is to offer customers a user-friendly interface for interacting with the hardware store, ensuring a smooth experience from product discovery to purchase and post-purchase feedback.

## Importance of Design Patterns:
- In the realm of software development, the implementation of design patterns plays a pivotal role. Design patterns are proven solutions to recurring design problems, offering a structured approach to building robust and maintainable software systems. By incorporating design patterns, we aim to enhance the scalability, flexibility, and maintainability of our hardware store system.
  
## Objectives:

### Display Products:
- Present a list of available electronic products.

### Purchase and Payment:
- Enable customers to select and purchase products.
- Provide various payment methods for flexibility.

### Feedback System:
- Allow customers to leave feedback on purchased products.

### Implementation of Design Patterns:
- Demonstrate the practical application of various design patterns such as Observer, Decorator, Strategy, and Factory patterns in real-world software development.


# Main Body:

## Features and Design Patterns:

### 1. Adapter pattern:
![image](https://github.com/DamirAsainov/SDP_final/assets/121009414/987b0708-040c-40e7-9c77-5ac7308624d5)

- **Classes:** `DefaultFeedbackSystem`, `FeedbackInterface`
- **Description:** Handles customer feedback.
- **Usage:** Utilized in the `StoreFeedbackAdapter` to adapt feedback for the store.

### 2. Product Management:
- **Classes:** `Product`, `ProductManagement`, `ProductManager`
- **Description:** Manages the creation, storage, and retrieval of products.
- **Usage:** Employed in various system components to handle products.

### 3. Decorator Pattern:
![image](https://github.com/DamirAsainov/SDP_final/assets/121009414/ab750f0b-02f8-456b-b7a5-ff633d8cf9a0)

- **Classes:** `DiscountDecorator`, `GiftDecorator`, `ProductDecorator`, `BaseProduct`
- **Description:** In the context of the hardware store system, the Decorator pattern is employed to enhance products with additional functionalities, such as discounts and gifts, without modifying their core structure.
- **Usage:** The Decorator pattern is applied to extend the functionality of products dynamically. Each decorator class adds a specific behavior, such as discounts or gifts, to the base product. The decorated products can then be used interchangeably with the base products, and clients can combine multiple decorators to create a product with multiple functionalities.

### 4. Observer Pattern:
![image](https://github.com/DamirAsainov/SDP_final/assets/121009414/f76bc700-5ee2-475a-b53a-92bf2a8f21d9)

- **Classes:** `Customer`, `Observer`, `StoreNotifier`
- **Description:** The Observer pattern is a behavioral design pattern where an object, known as the subject, maintains a list of its dependents, called observers. The subject notifies the observers of any state changes, typically by calling one of their methods. This pattern establishes a one-to-many relationship between the subject and its observers, allowing multiple objects to listen and react to changes in the subject's state.
- **Usage:** The Observer pattern is employed to implement a notification system where customers (observers) can subscribe to receive updates from the store (subject). When there are changes in the store, such as discounts or gifts being applied to products, the StoreNotifier notifies all subscribed customers by calling their update method. This enables customers to stay informed about ongoing promotions or special offers. The Observer pattern helps decouple the store's logic from the notification mechanism, promoting flexibility and maintainability in the system.

### 5. Strategy Pattern:
![image](https://github.com/DamirAsainov/SDP_final/assets/121009414/c3e24ab7-ffe8-48e1-b0ff-d44aa8a5b078)

- **Classes:** `CreditCardPayment`, `ElectronicStore`, `KaspiPayment`, `PayPalPayment`, `PaymentStrategy`
- **Description:** In the context of the hardware store system, the Strategy pattern is applied to handle payment processing by allowing different payment strategies to be defined and seamlessly switched.
- **Usage:**  In the hardware store system facilitates flexibility in choosing and applying different payment strategies. Clients, such as the electronic store or external entities, can dynamically select a payment strategy, allowing the system to adapt to various payment methods without modifying the core logic.

### 6. Factory Pattern:
![image](https://github.com/DamirAsainov/SDP_final/assets/121009414/8a5b707a-ee92-4b39-988a-74f5a72db949)
- **Classes:** `LaptopFactory`, `PhoneFactory`, `TVFactory`, `ProductFactory`
- **Description:** In the context of the hardware store system, the Factory pattern is employed to abstract the process of product creation, allowing flexibility and extensibility when introducing new product types.
- **Usage:** The usage of the Factory pattern in the hardware store system is exemplified through the creation of specific product instances. Clients, such as the system's product management module or external entities, interact with the respective factory classes to obtain instances of desired product types. This approach decouples the client code from the specifics of object creation, promoting a modular and maintainable system.

### 7. Singleton Pattern:
![image](https://github.com/DamirAsainov/SDP_final/assets/121009414/0a9147fe-3624-4957-b539-563da33ccaca)

- **Class:** `Database`
- **Description:** Implements the Singleton pattern to ensure a single instance of the database is created and accessed throughout the application's lifecycle.
- **Usage:**
  Accessed through the static method `getInstance()`, ensuring only one instance of the database exists.
  The singleton instance is utilized in various parts of the system, providing a centralized point for product management.
  The `Database` class is used to manage the product database.

## UML Diagram:
![image](https://github.com/DamirAsainov/SDP_final/assets/121009414/00765dc7-9621-4839-a87c-699691279235)


# Conclusion:

## Key Points:
- The project incorporates various design patterns, including Decorator, Observer, Strategy, Singleton, Adapter and Factory patterns.

## Project Outcomes:
- Successful implementation of a hardware store system.
- Integration of various design patterns for modular and maintainable code.

## Challenges Faced:
- We had a hard time putting together the different software design patterns in our project because we didn't fully understand them. It's crucial to learn more before taking on complex tasks.
- The poorly designed UML diagrams became a major challenge in our project. The lack of clarity raised crucial questions, making coding a daunting task. This emphasized the importance of having a solid plan before starting such projects.

## Future Improvements:
- Implement PostgreSQL or another database for persistent data storage.
- Create methods to interact with the database for products, customer data, and feedback.
- Implement user authentication and registration features.
- Allow customers to create accounts, log in, and track order history.
- Develop a graphical user interface (GUI) using JavaFX or Swing.
- Design a user-friendly interface for both customers and administrators.
- Implement order tracking functionality for customers.
- Provide real-time updates on order processing, shipping, and delivery.
- Organize products into categories.
- Implement a search functionality and filters for price range or brand.

# References 
- Freeman, E., Robson, E., Bates, B., & Sierra, K. (2004). Head First Design Patterns: A Brain-Friendly Guide. “O’Reilly Media, Inc.”
- https://www.w3schools.com/java/
- https://refactoring.guru/design-patterns
- https://www.tutorialspoint.com/design_pattern/index.htm
