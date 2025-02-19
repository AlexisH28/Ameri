-- Crear la base de datos
CREATE DATABASE ameri_db;
\c ameri_db;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    role VARCHAR(20) DEFAULT 'USER' NOT NULL
);

INSERT INTO users (full_name, username, email, password, birth_date, role) 
VALUES ('Admin User', 'admin', 'admin@ameri.com', '$2a$10$EjemploDeHashBCrypt', '1990-01-01', 'ADMIN');

CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    text TEXT NOT NULL,
    image_url VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE comments (
    id SERIAL PRIMARY KEY,
    post_id INT REFERENCES posts(id) ON DELETE CASCADE,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    text TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE likes (
    id SERIAL PRIMARY KEY,
    post_id INT REFERENCES posts(id) ON DELETE CASCADE,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE follows (
    id SERIAL PRIMARY KEY,
    follower_id INT REFERENCES users(id) ON DELETE CASCADE,
    following_id INT REFERENCES users(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE notifications (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    message TEXT NOT NULL,
    is_read BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (full_name, username, email, password, birth_date, role) VALUES
('User One', 'user1', 'user1@ameri.com', '$2a$10$EjemploDeHashBCrypt', '2000-05-15', 'USER'),
('User Two', 'user2', 'user2@ameri.com', '$2a$10$EjemploDeHashBCrypt', '1998-08-22', 'USER');

INSERT INTO posts (user_id, text, image_url) VALUES
(2, 'Mi primera publicación en Ameri!', NULL),
(3, 'Disfrutando del concierto de Ameri & Duki 🎶', 'https://example.com/image.jpg');

INSERT INTO comments (post_id, user_id, text) VALUES
(1, 3, '¡Genial publicación!'),
(2, 2, 'Wow, qué buen evento!');

INSERT INTO likes (post_id, user_id) VALUES
(1, 3),
(2, 2);

INSERT INTO follows (follower_id, following_id) VALUES
(2, 3),
(3, 2);

INSERT INTO notifications (user_id, message) VALUES
(2, 'User Two te ha seguido.'),
(3, 'User One ha comentado en tu publicación.');
