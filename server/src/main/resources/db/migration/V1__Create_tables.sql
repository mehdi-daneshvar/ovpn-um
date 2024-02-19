-- Table: State
CREATE TABLE state (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(50) NOT NULL,
   CONSTRAINT pk_state PRIMARY KEY (id)
);

ALTER TABLE state ADD CONSTRAINT uc_state_name UNIQUE (name);
--
-- Table: City
CREATE TABLE city (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(50) NOT NULL,
   state_id BIGINT NOT NULL,
   CONSTRAINT pk_city PRIMARY KEY (id)
);

ALTER TABLE city ADD CONSTRAINT uc_city_name UNIQUE (name);

ALTER TABLE city ADD CONSTRAINT FK_CITY_ON_STATE FOREIGN KEY (state_id) REFERENCES state (id);--
-- Table: OrganisationUnit
CREATE TABLE organisation_unit (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(50) NOT NULL,
   city_id BIGINT NOT NULL,
   parent_id BIGINT NULL,
   CONSTRAINT pk_organisationunit PRIMARY KEY (id)
);

ALTER TABLE organisation_unit ADD CONSTRAINT uc_organisationunit_name UNIQUE (name);

ALTER TABLE organisation_unit ADD CONSTRAINT FK_ORGANISATIONUNIT_ON_CITY FOREIGN KEY (city_id) REFERENCES city (id);

ALTER TABLE organisation_unit ADD CONSTRAINT FK_ORGANISATIONUNIT_ON_PARENT FOREIGN KEY (parent_id) REFERENCES organisation_unit (id);
--