CREATE TABLE garage (
  id INT ,
  name VARCHAR(45) NULL,
  kind_of_services VARCHAR(45) NULL,
  max_number_of_cars VARCHAR(45) NULL,
  current_number_of_cars VARCHAR(45) NULL,
  hired_employees VARCHAR(45) NULL,
  day_budget VARCHAR(45) NULL,
  turn_over VARCHAR(45) NULL,
    PRIMARY KEY (id));

INSERT INTO GARAGE(id,name,kind_of_services,day_budget,turn_over)
VALUES(7,'Selfie Garage',1,400,0);
