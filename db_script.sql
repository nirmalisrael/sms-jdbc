-- Create the database
CREATE DATABASE student;

-- Connect to the student database
\c student

-- Create the student_details table
CREATE TABLE student_details (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    dob DATE,
    email VARCHAR(100),
    phone VARCHAR(20),
    dr_no VARCHAR(20),
    st_name VARCHAR(100),
    village VARCHAR(100),
    district VARCHAR(100),
    pincode VARCHAR(20)
);

-- Insert five rows into the student_details table
INSERT INTO public.student_details (name, dob, email, phone, dr_no, st_name, village, district, pincode)
VALUES 
    ('John Doe', '2000-01-15', 'johndoe@example.com', '1234567890', '12', 'Maple Street', 'Springfield', 'Greene', '12345'),
    ('Jane Smith', '1999-05-23', 'janesmith@example.com', '0987654321', '34', 'Oak Avenue', 'Shelbyville', 'Shelby', '54321'),
    ('Robert Brown', '2001-07-30', 'robertbrown@example.com', '5555555555', '56', 'Pine Road', 'Ogdenville', 'Ogden', '67890'),
    ('Emily Davis', '1998-11-10', 'emilydavis@example.com', '6666666666', '78', 'Cedar Lane', 'North Haverbrook', 'Haverbrook', '98765'),
    ('Michael Wilson', '2002-03-25', 'michaelwilson@example.com', '7777777777', '90', 'Birch Boulevard', 'Capitol City', 'Capitol', '11223');

