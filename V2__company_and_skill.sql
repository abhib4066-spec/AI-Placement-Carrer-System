ALTER TABLE companies
  ADD COLUMN company_website VARCHAR(255) NULL,
  ADD COLUMN company_description TEXT NULL;

CREATE TABLE skills (
  id BIGINT NOT NULL AUTO_INCREMENT,
  student_id BIGINT NOT NULL,
  name VARCHAR(255) NOT NULL,
  level VARCHAR(128) NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_skills_student FOREIGN KEY (student_id) REFERENCES students(id)
);


