# COSC2440---Individual-Project---Shopping-System
Name: Nguyen Quoc An - S3938278
Lecturer: Dr. Dang Tran Tri

--------------------------
Some of the javadoc was written with the help of ChatGPT
For the continued of this project, please refer to the COSC2440---Group-Project---Shopping-System (Solo-version) (https://github.com/an6122003/COSC2440_Group-Project_Shopping-System/tree/master)
--------------------------

Assessment Details
Important: make sure you only use built-in classes/interfaces in a default installation of Java (and its version is at most JDK 19). Your work is NOT valid if it requires external libraries (except JUnit 5) to function properly. Besides the required classes/interfaces, your code must contain one Main class containing the entry public static void main method. We will launch your code from that point. For works that do not follow the above rules, their scores can be deducted up to 50% of the final score.

You must create appropriate unit tests for testable functions using JUnit 5. Furthermore, your must use Maven as the build tool for this project. If your work fails to follow those requirements, up to 50% of the achieved score can be deducted.

For every Java file, you must insert the following Javadoc comment at the top of the file (after package declaration)

/**
 * @author <Your Full Name - Your Student ID>
 */
Furthermore, for code and ideas obtained from external sources, you must cite them appropriately.
Background:

You are developing an online shopping service. This service allows users to browse, search, view, and buy products. Each product contains the following information:

- name (String, unique among all products)
- description (String)
- quantity available (non-negative integer)
- price (double)

The information about each product is not visible outside of the product itself. As such, you must provide the ability to change or view them to the external code.

Each product can only be a digital product or a physical product at the moment. No general product can exist in the service. For each kind of product (i.e., digital or physical), you must provide a different String representation.

For a digital product, the String representation of it is

"DIGITAL - <product name>" (you must replace <product name> with the actual name of the product)

For a physical product, the String representation of it is

"PHYSICAL - <product name>" (you must replace <product name> with the actual name of the product)

Physical products also have a weight (double). Again, weight is not visible outside of the physical product itself. As such, you must provide the necessary operations to change/view this value to the external code.

Some products (i.e., some physical products and some digital products as well) can be used as gifts. For those products, customers can apply two operations:

- void setMessage(String msg)
and
- String getMessage()
to set and retrieve the greeting message of the gift product.

A shopping cart contains a set of Strings. Each String corresponds to a product name (we assume all Strings are valid product names). In this project, let's assume that the quantity of each product in a shopping cart is only one (Note: this is the quantity of a product in the shopping cart, not the quantity available of that product in the service).

A shopping cart must support three operations:

- boolean addItem(String productName)

add the product with the given name to the shopping cart; if the quantity available of the product is zero, do nothing and return false; if the product with the given name exists in the cart already, do nothing and return false; otherwise, decrease the quantity available of that product by one, add the product name to the cart, and return true.

- boolean removeItem(String productName)
remove the product with the given name from the shopping cart; if the product with the given name does not exist in the cart, do nothing and return false; otherwise, increase the quantity available of that product by one, remove the product name from the cart, and return true.

- double cartAmount()
calculate and return the total price amount of all products in the cart. Furthermore, if a cart contains physical products, you must add the shipping fee to the total price before returning it. The shipping fee is calculated as:

shipping fee = (total weight of all physical products) * (base fee)

In this project, let's use a fixed value of 0.1 for the base fee.

To speed up the delivery process, all shopping carts are sorted based on the total weight of all physical items in each cart. You must ensure that Java can compare two shopping cart objects based on their total weights.

Finally, create a simple text-based UI program to let users: create new products, edit products, create a new shopping cart, add products to the current shopping cart, remove products from the current shopping cart, display the cart amount, create a new shopping cart, display all shopping carts based on their total weight (described above).

UI requirement: this is a console application. You need to develop a text-based menu system to interact with users. You can use java.util.Scanner to get user input from the console
