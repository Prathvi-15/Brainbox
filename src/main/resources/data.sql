-- Clear dependent tables first (articles refer to users)
DELETE FROM article;
DELETE FROM user;
DELETE FROM role;

-- Insert roles
INSERT INTO role (id, name) VALUES (1, 'ADMIN');
INSERT INTO role (id, name) VALUES (2, 'USER');
INSERT INTO role (id, name) VALUES (3, 'CONTRIBUTOR');
INSERT INTO role (id, name) VALUES (4, 'REVIEWER');

-- Insert users (all with password: 'password' encoded using BCrypt)
-- You can use https://bcrypt-generator.com/ to encode your own
INSERT INTO user (id, username, password) VALUES
(1, 'admin', '$2a$10$7zQ7zJ/0e0WJ0sovRZLQfOXAMGgU2KFeBB9M0hA.fB4D9lfMeo2iy'),
(2, 'john_user', '$2a$10$7zQ7zJ/0e0WJ0sovRZLQfOXAMGgU2KFeBB9M0hA.fB4D9lfMeo2iy'),
(3, 'contributor_1', '$2a$10$7zQ7zJ/0e0WJ0sovRZLQfOXAMGgU2KFeBB9M0hA.fB4D9lfMeo2iy'),
(4, 'reviewer_1', '$2a$10$7zQ7zJ/0e0WJ0sovRZLQfOXAMGgU2KFeBB9M0hA.fB4D9lfMeo2iy');

-- You can manually assign roles in Java code (on user registration or during service init)
-- OR insert them below once the user_roles table is created by Hibernate
-- But avoid it in data.sql for startup safety

-- Sample articles for various users
INSERT INTO article (id, title, content, approved, author_id) VALUES
(1, 'Admin Article', 'This article was added by Admin', true, 1),
(2, 'User Article', 'User can only view articles', true, 2),
(3, 'Pending Contributor Article', 'Needs review before publish', false, 3),
(4, 'Reviewed Article', 'This was approved by a reviewer', true, 3);
