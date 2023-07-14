-- Create the users table
CREATE TABLE users (
    id INT AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    high_score INT DEFAULT 0,
    PRIMARY KEY (id)
);
