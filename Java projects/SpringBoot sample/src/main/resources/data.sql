INSERT INTO users (id, password, username) VALUES ('1', 'admin', 'admin');
INSERT INTO users (id, password, username) VALUES ('2', '12345', 'user');

INSERT INTO roles (id, role) VALUES ('1', 'ADMIN');
INSERT INTO roles (id, role) VALUES ('2', 'USER');

INSERT INTO users_roles (user_id, role_id) VALUES ('1', '1');
INSERT INTO users_roles (user_id, role_id) VALUES ('1', '2');
INSERT INTO users_roles (user_id, role_id) VALUES ('2', '2');
