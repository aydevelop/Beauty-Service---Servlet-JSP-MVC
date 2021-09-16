CREATE DATABASE IF NOT EXISTS beautyservice;
USE beautyservice;

CREATE TABLE IF NOT EXISTS role
(
    id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS user
(
    id         INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email      VARCHAR(40)  NOT NULL,
    password   VARCHAR(256) NOT NULL,
    first_name VARCHAR(20)  NOT NULL,
    last_name  VARCHAR(20)  NOT NULL,
    role_id    INT          NOT NULL,
    lang       VARCHAR(10)  NULL,
    FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS category
(
    id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS `service`
(
    id             INT            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name_ua        VARCHAR(40)    NOT NULL,
    name_en        VARCHAR(40)    NOT NULL,
    price          DECIMAL(10, 2) NOT NULL,
    image          VARCHAR(100)   NOT NULL,
    description_ua VARCHAR(1000)  NOT NULL,
    description_en VARCHAR(1000)  NOT NULL,
    category_id    INT            NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `master_service`
(
    id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    master_id  INT NOT NULL,
    service_id INT NOT NULL,
    FOREIGN KEY (master_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (service_id) REFERENCES service (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `order`
(
    id              INT                                                  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data_time       DATETIME                                             NOT NULL,
    status          ENUM ('is_new', 'is_paid', 'is_canceled', 'is_done') NOT NULL DEFAULT 'is_new',
    feedback_text   VARCHAR(200)                                         NULL,
    feedback_rating INT                                                  NULL,
    client_id       INT                                                  NOT NULL,
    master_id       INT                                                  NOT NULL,
    service_id      INT                                                  NOT NULL,
    FOREIGN KEY (client_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (master_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (service_id) REFERENCES service (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

INSERT INTO category (id, name)
VALUES (1, 'Перукарські послуги'),
       (2, 'Манікюр та педикюр'),
       (3, 'Послуги косметолога'),
       (4, 'Макіяж та візаж'),
       (5, 'Нарощення вій'),
       (6, 'Тату / татуаж / боді арт хною'),
       (7, 'Масаж та СПА');

INSERT INTO role (id, name)
VALUES (1, 'Гість'),
       (2, 'Клієнт'),
       (3, 'Адміністратор'),
       (4, 'Майстер');

INSERT INTO service (id, name_ua, name_en, price, image, description_ua, description_en, category_id)
VALUES (1, 'Освітлення коренів', 'Root lighting', 111.00, '111', 'Освітлення коренів ...........',
        'Root lighting ............', 1),
       (2, 'Манікюр європейський необрізний', 'European untrimmed manicure ', 111.00, '111',
        'Манікюр європейський необрізний ..........', 'European untrimmed manicure ..........', 2),
       (3, 'Нарощуваня вій (об’єм 2D)', 'Eyelash extensions (2D volume)', 111.00, '111',
        'Нарощуваня вій (об’єм 2D) ..........', 'Eyelash extensions .....', 5),
       (4, 'Покриття нігтів гелем + гель-лак', 'Covering nails with gel + gel varnish', 111.00, '111',
        ' Покриття нігтів гелем + гель-лак ..........', 'Covering nails with gel + gel varnish .....', 2),
       (5, 'Татуаж брів (класичний)', 'Eyebrow tattoo (classic)', 111.00, '111', 'Татуаж брів (класичний) ..........',
        'Eyebrow tattoo (classic)  .....', 3),
       (6, 'Корекція татуажу брів', 'Eyebrow tattoo correction ', 111.00, '111', 'Корекція татуажу брів ..........',
        'Eyebrow tattoo correction  .....', 6),
       (7, 'Зняття + нарощування волосся 1 прядка', 'Eyelash extensions (2D volume)', 111.00, '111',
        'Зняття + нарощування волосся 1 прядка ..........', 'Eyelash extensions .....', 7);

/*
    password=1234
*/
INSERT INTO user (id, email, password, first_name, last_name, role_id)
VALUES (1, 'kbartelli2@wufoo.com',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Kamila', 'Bartelli', 1),
       (2, 'hbridsonp@adobe.com',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Hally', 'Bridson', 2),
       (3, 'jbisco16@boston.com',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Barbi', 'Vasilik', 3),
       (4, 'cblakden@netlog.com',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Cristie', 'Blakden', 1),
       (5, 'ltoppas1t@etsy.com',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Lorraine', 'Toppas', 2),
       (6, 'vsoulsbya@slideshar',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Kitti', 'Mangenot', 3),
       (7, 'jmurleys@1und1.de',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Siana', 'Kivelhan', 4),
       (8, 'meckh2u@stanford.edu',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Malory', 'Eckh', 4),
       (9, 'cfowdeny@nbcnews.com',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Colet', 'Fowden', 1),
       (10, 'dvaunc@oracle.com',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Debbie', 'Vaun', 2),
       (11, 'eikinv@spiegel.de',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Alyss', 'Tweedell', 3),
       (12, 'omaymond@etsy.com',
        'b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7',
        'Othelia', 'Maymond', 4);


INSERT INTO master_service (id, master_id, service_id)
VALUES (1, 4, 2),
       (2, 9, 1),
       (3, 3, 3),
       (4, 5, 3),
       (5, 3, 3),
       (6, 6, 3);

INSERT INTO `order` (id, data_time, status, feedback_text, feedback_rating, client_id, master_id, service_id)
VALUES (1, '2021-09-12 12:50:00', 'is_done', 'good', 5, 10, 7, 3),
       (2, '2021-10-12 12:50:00', 'is_done', 'good', 5, 5, 7, 1),
       (3, '2021-11-12 12:50:00', 'is_done', 'good', 5, 5, 7, 3);