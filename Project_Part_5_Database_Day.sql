CREATE TABLE customer (
  customer_id INT PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  email VARCHAR(100),
  phone_number VARCHAR(20)
);

INSERT INTO customer (customer_id, first_name, last_name, email, phone_number)
VALUES
  (1, 'John', 'Doe', 'johndoe@example.com', '1234567890'),
  (2, 'Jane', 'Smith', 'janesmith@example.com', '9876543210');

SELECT * FROM customer;

CREATE TABLE products (
  product_id INT PRIMARY KEY,
  brand VARCHAR(50),
  model VARCHAR(50),
  description TEXT,
  price DECIMAL(10, 2),
  quantity INT
);

INSERT INTO products (product_id, brand, model, description, price, quantity)
VALUES
  (1, 'Brand A', 'Model X', 'Description of Product X', 99.99, 10),
  (2, 'Brand B', 'Model Y', 'Description of Product Y', 199.99, 5);

SELECT * FROM products;

CREATE TABLE transactions (
  transaction_id INT PRIMARY KEY,
  customer_id INT,
  product_id INT,
  transaction_date DATE,
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
  FOREIGN KEY (product_id) REFERENCES products(product_id)
);


INSERT INTO transactions (transaction_id, customer_id, product_id, transaction_date)
VALUES
  (1, 1, 1, '2022-01-01'),
  (2, 2, 2, '2022-02-01'),
  (3, 1, 2, '2022-03-01');


SELECT * FROM transactions;
