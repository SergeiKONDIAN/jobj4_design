CREATE TABLE employees (
    ID SERIAL PRIMARY KEY,
    empName VARCHAR(255),
	age INT,
	dateOfBirth DATE
);
INSERT INTO employees (empName, age, dateOfBirth) VALUES ('Bob', 35, '1989-01-01');
UPDATE employees SET empName = 'Mike';
DELETE FROM employees;