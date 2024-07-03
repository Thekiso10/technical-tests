-- Insert Brand
INSERT INTO brand (id, name) VALUES (1, 'Seat');
INSERT INTO brand (id, name) VALUES (2, 'Mercedes-Benz');
INSERT INTO brand (id, name) VALUES (3, 'Peugeot');
INSERT INTO brand (id, name) VALUES (4, 'Nissan');
INSERT INTO brand (id, name) VALUES (5, 'Audi');

-- Insert Model
INSERT INTO model (id, brand_id, name, img_url) VALUES (10, 1, 'Arona', 'https://www.diariomotor.com/imagenes/2018/03/skoda_lanzamiento_su_seat_arona_00.jpg');
INSERT INTO model (id, brand_id, name, img_url) VALUES (11, 1, 'Ibiza', null);
INSERT INTO model (id, brand_id, name, img_url) VALUES (12, 1, 'Leon', 'https://www.topgear.com/sites/default/files/images/news-article/carousel/2019/01/4e9fb55f7ef03a11029c2fb4864fb621/20181201_siemoneitracing_vader_leoncuprast_001_front34_online.jpg');

INSERT INTO model (id, brand_id, name, img_url) VALUES (13, 2, 'Classe A', null);
INSERT INTO model (id, brand_id, name, img_url) VALUES (14, 2, 'Classe C', 'https://www.autobild.es/sites/autobild.es/public/dc/fotos/batch_20C0673_002.jpg');
INSERT INTO model (id, brand_id, name, img_url) VALUES (15, 2, 'Classe G', 'https://img.remediosdigitales.com/9afd76/21c0550_001/1366_2000.jpeg');

INSERT INTO model (id, brand_id, name, img_url) VALUES (16, 3, '306', null);
INSERT INTO model (id, brand_id, name, img_url) VALUES (17, 3, '406', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQckrOZz_I1oeV3efjMpuTZqhfhbz09nEcGmYqREiXN&s');
INSERT INTO model (id, brand_id, name, img_url) VALUES (18, 3, 'Partner', null);

INSERT INTO model (id, brand_id, name, img_url) VALUES (19, 4, 'Almera', 'https://www.autoscout24.es/cms-content-assets/2g0k6EgGWyAzDAjcU2xZIl-8cdbf2a75557b35a85ed332d204620c6-nissan-almera-l-01-1100.jpg');
INSERT INTO model (id, brand_id, name, img_url) VALUES (20, 4, 'Juke', 'https://cdn.motor1.com/images/mgl/rbrEE/s1/2018-nissan-juke-euro-spec.jpg');
INSERT INTO model (id, brand_id, name, img_url) VALUES (21, 4, 'Qashqai', null);

INSERT INTO model (id, brand_id, name, img_url) VALUES (22, 5, 'A4', 'https://images.prismic.io/carwow/d87f95a9-0970-45b1-ac67-86642f39dce7_Audi-A4_08-1.jpg?fit=clip&q=60&w=750&cs=tinysrgb&auto=format');
INSERT INTO model (id, brand_id, name, img_url) VALUES (23, 5, 'RS3', 'https://www.autobild.es/sites/autobild.es/public/styles/main_element/public/dc/fotos/Audi_A3_2020.jpg?itok=MkiCOhpe');
INSERT INTO model (id, brand_id, name, img_url) VALUES (24, 5, 'Q7', null);

-- Insert Employer
INSERT INTO employer (id, name, num_employer, favour_model_id) VALUES (30, 'Eduard', 111, null);
INSERT INTO employer (id, name, num_employer, favour_model_id) VALUES (31, 'Maria', 222, null);