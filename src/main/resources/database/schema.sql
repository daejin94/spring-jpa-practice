/*
  Name: MySQL Sample Database classicmodels
  Link: http://www.mysqltutorial.org/mysql-sample-database.aspx
*/
/* Drop existing tables  */
DROP TABLE IF EXISTS orderdetails cascade;
DROP TABLE IF EXISTS products cascade;
DROP TABLE IF EXISTS product_lines cascade;
DROP TABLE IF EXISTS payments cascade;
DROP TABLE IF EXISTS orders cascade;
DROP TABLE IF EXISTS customers cascade;
DROP TABLE IF EXISTS employees cascade;
DROP TABLE IF EXISTS offices cascade;

/* Create the tables */
CREATE TABLE product_lines
(
    product_line     varchar(50),
    text_description varchar(4000) DEFAULT NULL,
    html_description mediumtext,
    image            mediumblob,
    PRIMARY KEY (product_line)
);

CREATE TABLE products
(
    product_code        varchar(15),
    product_name        varchar(70)    NOT NULL,
    product_line        varchar(50)    NOT NULL,
    product_scale       varchar(10)    NOT NULL,
    product_vendor      varchar(50)    NOT NULL,
    product_description text           NOT NULL,
    quantity_in_stock   smallint(6)    NOT NULL,
    buy_price           decimal(10, 2) NOT NULL,
    msrp                decimal(10, 2) NOT NULL,
    PRIMARY KEY (product_code),
    FOREIGN KEY (product_line) REFERENCES product_lines (product_line)
);

CREATE TABLE offices
(
    office_code   varchar(10),
    city          varchar(50) NOT NULL,
    phone         varchar(50) NOT NULL,
    address_line1 varchar(50) NOT NULL,
    address_line2 varchar(50) DEFAULT NULL,
    state         varchar(50) DEFAULT NULL,
    country       varchar(50) NOT NULL,
    postal_code   varchar(15) NOT NULL,
    territory     varchar(10) NOT NULL,
    PRIMARY KEY (office_code)
);

CREATE TABLE employees
(
    employee_number int,
    last_name       varchar(50)  NOT NULL,
    first_name      varchar(50)  NOT NULL,
    extension       varchar(10)  NOT NULL,
    email           varchar(100) NOT NULL,
    office_code     varchar(10)  NOT NULL,
    reports_to      int DEFAULT NULL, -- 상사를 의미한다고 함
    job_title       varchar(50)  NOT NULL,
    PRIMARY KEY (employee_number),
    FOREIGN KEY (reports_to) REFERENCES employees (employee_number),
    FOREIGN KEY (office_code) REFERENCES offices (office_code)
);

CREATE TABLE customers
(
    customerNumber         int,
    customerName           varchar(50) NOT NULL,
    contactLastName        varchar(50) NOT NULL,
    contactFirstName       varchar(50) NOT NULL,
    phone                  varchar(50) NOT NULL,
    addressLine1           varchar(50) NOT NULL,
    addressLine2           varchar(50)    DEFAULT NULL,
    city                   varchar(50) NOT NULL,
    state                  varchar(50)    DEFAULT NULL,
    postalCode             varchar(15)    DEFAULT NULL,
    country                varchar(50) NOT NULL,
    salesRepEmployeeNumber int            DEFAULT NULL,
    creditLimit            decimal(10, 2) DEFAULT NULL,
    PRIMARY KEY (customerNumber),
    FOREIGN KEY (salesRepEmployeeNumber) REFERENCES employees (employee_number)
);

CREATE TABLE payments
(
    customerNumber int,
    checkNumber    varchar(50)    NOT NULL,
    paymentDate    date           NOT NULL,
    amount         decimal(10, 2) NOT NULL,
    PRIMARY KEY (customerNumber, checkNumber),
    FOREIGN KEY (customerNumber) REFERENCES customers (customerNumber)
);

CREATE TABLE orders
(
    orderNumber    int,
    orderDate      date        NOT NULL,
    requiredDate   date        NOT NULL,
    shippedDate    date DEFAULT NULL,
    status         varchar(15) NOT NULL,
    comments       text,
    customerNumber int         NOT NULL,
    PRIMARY KEY (orderNumber),
    FOREIGN KEY (customerNumber) REFERENCES customers (customerNumber)
);

CREATE TABLE orderdetails
(
    orderNumber     int,
    productCode     varchar(15)    NOT NULL,
    quantityOrdered int            NOT NULL,
    priceEach       decimal(10, 2) NOT NULL,
    orderLineNumber smallint(6)    NOT NULL,
    PRIMARY KEY (orderNumber, productCode),
    FOREIGN KEY (orderNumber) REFERENCES orders (orderNumber),
    FOREIGN KEY (productCode) REFERENCES products (product_code)
);
