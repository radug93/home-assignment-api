insert into product (name, code, price, image_url, description, active)
VALUES ('Washing machine', 'KCJAOW-DADDL-KCASDH', 4000, 'https://unsplash.com/photos/s5kTY-Ve1c0',
        'At least your clothes are smelling good now', true);
insert into product (name, code, price, image_url, description, active)
VALUES ('DSLR camera', 'DLSAO-PLEWNL-MCAKD', 3000,'https://unsplash.com/photos/sdlka2-Ve1c0',
        'Take a picture and it will last longer!', true);
insert into product (name, code, price, image_url, description, active)
VALUES ('TV', 'TVKAWOM-DKAS-LOOO2', 3500, 'https://unsplash.com/photos/s5kTY-VlDOW',
        'Bigger is better', true);
insert into product (name, code, price, image_url, description, active)
VALUES ('Phone', 'SMS-IPG-KLCWOJH', 4500, 'https://unsplash.com/photos/s5MO92-Ve1c0',
        'Make sure it is more expensive than your TV', true);
insert into product (name, code, price, image_url, description, active)
VALUES ('Espresso machine', 'CF-DKASD-CKASO', 1500, 'https://unsplash.com/photos/slowJW-LOO2',
        'Fuel for programming', true);
insert into product (name, code, price, image_url, description, active)
VALUES ('Robo Vacuum', 'KP23KJ-KOWMG-LDAONM', 2500, 'https://unsplash.com/photos/sKDL-Ve1c0',
        'Radu, you do not nee this', false);

insert into roles (name) VALUES ('ROLE_USER');
insert into roles (name) VALUES ('ROLE_MODERATOR');
insert into roles (name) VALUES ('ROLE_ADMIN');

insert into users (username, email, password) VALUES ('authUser', 'authUser@ggg.com', '$2a$10$HAGSVbYRjCWUF3RsSoGQW.cp5x0bVC1OGFjJFpotGbgu9EfjvXMMq');

insert into user_roles (user_id, role_id) VALUES (1 ,1);