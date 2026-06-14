CREATE TABLE students (
  id BIGINT NOT NULL AUTO_INCREMENT,
  full_name VARCHAR(255) NOT NULL,
  cgpa DECIMAL(3,2) NOT NULL,
  email VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE companies (
  id BIGINT NOT NULL AUTO_INCREMENT,
  company_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uk_company_name (company_name)
);

CREATE TABLE placements (
  id BIGINT NOT NULL AUTO_INCREMENT,
  student_id BIGINT NOT NULL,
  company_id BIGINT NOT NULL,
  status VARCHAR(64) NOT NULL,
  notes TEXT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_placements_student FOREIGN KEY (student_id) REFERENCES students(id),
  CONSTRAINT fk_placements_company FOREIGN KEY (company_id) REFERENCES companies(id)
);

