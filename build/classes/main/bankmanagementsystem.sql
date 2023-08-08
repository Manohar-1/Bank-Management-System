CREATE TABLE signup (
  formNo VARCHAR(4) NOT NULL,
  name VARCHAR(20) NOT NULL,
  fname VARCHAR(30) NOT NULL,
  Odob VARCHAR(30) NOT NULL,
  gender VARCHAR(6) NOT NULL,
  email VARCHAR(30) NOT NULL,
  maritalStatus VARCHAR(10) NOT NULL,
  address VARCHAR(30) NOT NULL,
  city VARCHAR(20) NOT NULL,
  state VARCHAR(20) NOT NULL,
  pincode VARCHAR(20) NOT NULL
);

CREATE TABLE additional (
  formNo VARCHAR(5) NOT NULL,
  religion VARCHAR(10) NOT NULL,
  category VARCHAR(8) NOT NULL,
  income VARCHAR(30) NOT NULL,
  education VARCHAR(30) NOT NULL,
  occupation VARCHAR(30) NOT NULL,
  aadhaarNo VARCHAR(30) NOT NULL,
  seniorCitizen VARCHAR(5) NOT NULL,
  existingAccount VARCHAR(5) NOT NULL,
  panNumber VARCHAR(20) NOT NULL
);


CREATE TABLE accountdetails (
  formNo VARCHAR(10) NOT NULL,
  accountType VARCHAR(40) NOT NULL,
  accountNumber VARCHAR(20) NOT NULL,
  opinumber VARCHAR(5) NOT NULL,
  serviceRequired VARCHAR(40) NOT NULL
);

CREATE TABLE bankaccount (
  accountNumber VARCHAR(20) NOT NULL,
  pinNumber VARCHAR(5) NOT NULL,
  balance VARCHAR(20) NOT NULL
);

CREATE TABLE history (
  accountNumber VARCHAR(20) NOT NULL,
  transactionTime TIMESTAMP NOT NULL,
  amount VARCHAR(20) NOT NULL
);
