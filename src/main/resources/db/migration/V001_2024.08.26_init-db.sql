CREATE TABLE clients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    username VARCHAR(100),
    password VARCHAR(255),
    pets VARCHAR(100),
    location VARCHAR(100),
    FOREIGN KEY (pets) REFERENCES pets(owner_name),
    FOREIGN KEY (location) REFERENCES locations(clients)
);

CREATE TABLE pets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pet_type VARCHAR(100),
    pet_sex VARCHAR(50),
    pet_age INT,
    pet_size VARCHAR(50),
    pet_name VARCHAR(100),
    health_state VARCHAR(100),
    ownerName VARCHAR(100),
    location VARCHAR(100),
    registration_date DATE,
    FOREIGN KEY (owner_name) REFERENCES clients(username)
);

CREATE TABLE locations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    location_name VARCHAR(100),
    clients VARCHAR(100),
    FOREIGN KEY (clients) REFERENCES clients(location_id)
);