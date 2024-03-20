insert into user(name,job) value ("Ivan", "Custover");
insert into user(name,job) value ("Sergey","Customer");
insert into user(name,job) value ("Darya","Customer");
insert into user(name,job) value ("Tim","Employee");
insert into user(name,job) value ("Natasha","Employee");
insert into user(name,job) value ("Roman","Customer");
insert into user(name,job) value ("Irina","Customer");
insert into user(name,job) value ("David","Employee");

insert into plane(number) value ("NT-567");
insert into plane(number) value ("SRT-7612");
insert into plane(number) value ("TYR-832");
insert into plane(number) value ("POT-912");
insert into plane(number) value ("JTY-672");

insert into city(name) value ("Minsk");
insert into city(name) value ("Gomel");
insert into city(name) value ("Moskow");
insert into city(name) value ("Antalya");
insert into city(name) value ("St. Petersburg");
insert into city(name) value ("St. Petersburg");

insert into airport(name,city_id) value ("airport Minsk",1);
insert into airport(name,city_id) value ("airport Gomel",2);
insert into airport(name,city_id) value ("airport Moskow",3);
insert into airport(name,city_id) value ("airport Antalya",4);
insert into airport(name,city_id) value ("airport St. Petersburg",5);
insert into airport(name,city_id) value ("airport Kaliningrad",6);

insert into route value (1, 342, "2024-03-21 10:00:00", "2024-03-21 12:00:00", 1, 2, "2:00:00", 1, "planned", 342);
insert into route value (2, 546, "2024-03-22 17:00:00", "2024-03-22 20:00:00", 3, 4, "3:00:00", 2, "planned", 587);
insert into route value (3, 658, "2024-03-20 13:20:00", "2024-03-20 15:00:00", 5, 6, "01:40:00", 3, "planned", 396);
insert into route value (4, 869, "2024-03-21 08:36:00", "2024-03-21 10:11:00", 3, 5, "01:25:00", 2, "planned", 471);
insert into route value (5, 187, "2024-03-20 11:50:00", "2024-03-20 14:50:00", 1, 6, "03:00:00", 1, "planned", 871);
insert into route value (6, 746, "2024-03-22 14:10:00", "2024-03-22 15:55:00", 2, 4, "01:45:00", 1, "planned", 533);
insert into route value (7, 546, "2024-03-21 17:00:00", "2024-03-21 20:00:00", 3, 4, "03:00:00", 2, "planned", 587);
insert into route value (8, 746, "2024-03-23 14:10:00", "2024-03-23 15:55:00", 2, 4, "01:45:00", 1, "planned", 533);

insert into ticket value (1, 1, 1, "planned", 45);
insert into ticket value (2, 2, 2, "planned", 74);
insert into ticket value (3, 3, 2, "planned", 70);
insert into ticket value (4, 4, 3, "planned", 121);
insert into ticket value (5, 5, 4, "planned", 78);
insert into ticket value (6, 5, 7, "planned", 56);
insert into ticket value (7, 6, 5, "planned", 98);
insert into ticket value (8, 7, 6, "planned", 39);

insert into user_plane value (1, 1, 1, "Customer");
insert into user_plane value (2, 2, 2, "Customer");
insert into user_plane value (3, 3, 3, "Customer");
insert into user_plane value (4, 2, 4, "Сaptain");
insert into user_plane value (5, 2, 5, "Stewardess");
insert into user_plane value (6, 2, 6, "Customer");
insert into user_plane value (7, 3, 6, "Customer");
insert into user_plane value (8, 3, 3, "Customer");
insert into user_plane value (9, 3, 4, "Сaptain");
insert into user_plane value (10, 3, 5, "Stewardess");
insert into user_plane value (11, 2, 8, "Pilot");



