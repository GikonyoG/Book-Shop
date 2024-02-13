# Bookshop Management System

## Overview

The Bookshop Management System is a comprehensive software solution designed to facilitate the management of a bookshop's operations, including inventory management, customer interactions, and administrative tasks. This system is implemented in Java and provides a robust platform for managing books, including physical books (paperbacks), ebooks, and audiobooks.

## Features

- **Admin and Customer Interfaces**: Separate login interfaces for administrators and customers, ensuring tailored functionalities for each user type.
- **Inventory Management**: Admins can add, update, or remove books from the inventory.
- **Search and Purchase**: Customers can search for books by title or author and complete purchases.
- **Dynamic Pricing**: Support for different types of books, including ebooks, audiobooks, and paperbacks, with specific attributes for each.
- **Order Management**: Customers can view their shopping cart, proceed to checkout, and view total prices, including dynamic pricing based on book types.
- **User Account Management**: System supports user account creation and management, ensuring a personalized shopping experience.

## Structure

The system is composed of several Java classes:

- **User Interface Classes**: `loginFrame`, `Login` for user authentication.
- **Admin Classes**: `adminButtonController`, `adminFileHandler` for handling administrative tasks.
- **Customer Classes**: `customerButtonHandler`, `customerCheckout`, `customerFileHandler`, `customerSearchBook`, `customerTotalPrice` for customer-related functionalities.
- **Book Classes**: `Books`, `Paperback`, `Ebook`, `Audiobook` for representing different types of books.
- **Utility Classes**: `User`, `UserAccount` for managing user data.
- **Test Classes**: `test`, `test2` for system testing.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Any Java IDE (e.g., Eclipse, IntelliJ IDEA)

### Setup and Installation

1. Clone the repository or download the source code.
2. Import the project into your Java IDE.
3. Ensure `Stock.txt` and `UserAccounts.txt` are placed in the correct directory for file handling operations.
4. Compile and run `loginFrame.java` to start the application.

### Usage

- **Admin Login**: Use predefined credentials or create a new admin account to manage book inventory.
- **Customer Login**: New users can create an account to start purchasing books.

## Contributing

We welcome contributions to the Bookshop Management System. Please feel free to fork the repository, make your changes, and submit a pull request for review.

## License

This project is open-source and available under the MIT License. See the LICENSE file for more details.

---
