CREATE TABLE form_evolution
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    type_evolution_id BIGINT NULL,
    CONSTRAINT pk_form_evolution PRIMARY KEY (id)
);

CREATE TABLE form_learn
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    type_form_learn_id BIGINT NOT NULL,
    CONSTRAINT pk_form_learn PRIMARY KEY (id)
);

CREATE TABLE level_evolution
(
    id    BIGINT NOT NULL,
    level INT    NOT NULL,
    CONSTRAINT pk_level_evolution PRIMARY KEY (id)
);

CREATE TABLE level_learn
(
    id    BIGINT NOT NULL,
    level INT    NOT NULL,
    CONSTRAINT pk_level_learn PRIMARY KEY (id)
);

CREATE TABLE mo_learn
(
    id BIGINT NOT NULL,
    mo VARCHAR(255) NULL,
    CONSTRAINT pk_mo_learn PRIMARY KEY (id)
);

CREATE TABLE movement_secondary_effects
(
    id                   BIGINT AUTO_INCREMENT NOT NULL,
    movements_id         BIGINT NULL,
    secondary_effects_id BIGINT NULL,
    probability          INT NOT NULL,
    CONSTRAINT pk_movement_secondary_effects PRIMARY KEY (id)
);

CREATE TABLE movements
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255) NULL,
    strenght      BIGINT NULL,
    precision_mov BIGINT NULL,
    `description` VARCHAR(500) NULL,
    pp            INT    NOT NULL,
    priority      INT    NOT NULL,
    type_id       BIGINT NOT NULL,
    CONSTRAINT pk_movements PRIMARY KEY (id)
);

CREATE TABLE mt_learn
(
    id BIGINT NOT NULL,
    mt VARCHAR(255) NULL,
    CONSTRAINT pk_mt_learn PRIMARY KEY (id)
);

CREATE TABLE pokemon
(
    pokedex_number BIGINT AUTO_INCREMENT NOT NULL,
    name           VARCHAR(255) NULL,
    weight DOUBLE NULL,
    height DOUBLE NULL,
    evolution_id   BIGINT NULL,
    ps             INT NOT NULL,
    attack         INT NOT NULL,
    defense        INT NOT NULL,
    special        INT NOT NULL,
    speed          INT NOT NULL,
    CONSTRAINT pk_pokemon PRIMARY KEY (pokedex_number)
);

CREATE TABLE pokemon_form_evolution
(
    form_evolution_id BIGINT NOT NULL,
    pokedex_number    BIGINT NOT NULL,
    CONSTRAINT pk_pokemon_form_evolution PRIMARY KEY (form_evolution_id, pokedex_number)
);

CREATE TABLE pokemon_movement_form
(
    pokedex_number BIGINT NOT NULL,
    id_movements   BIGINT NOT NULL,
    id_form_learn  BIGINT NOT NULL,
    CONSTRAINT pk_pokemon_movement_form PRIMARY KEY (pokedex_number, id_movements, id_form_learn)
);

CREATE TABLE pokemon_types
(
    pokedex_number BIGINT NOT NULL,
    types          BIGINT NOT NULL,
    CONSTRAINT pk_pokemon_types PRIMARY KEY (pokedex_number, types)
);

CREATE TABLE secondary_efects
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    secondary_efect VARCHAR(255) NULL,
    CONSTRAINT pk_secondary_efects PRIMARY KEY (id)
);

CREATE TABLE stone
(
    id            BIGINT NOT NULL,
    type_stone_id BIGINT NOT NULL,
    CONSTRAINT pk_stone PRIMARY KEY (id)
);

CREATE TABLE type_attack
(
    type_attack_id BIGINT AUTO_INCREMENT NOT NULL,
    name           VARCHAR(255) NULL,
    CONSTRAINT pk_type_attack PRIMARY KEY (type_attack_id)
);

CREATE TABLE type_evolution
(
    type_evolution_id BIGINT AUTO_INCREMENT NOT NULL,
    type_evolution    VARCHAR(255) NULL,
    CONSTRAINT pk_type_evolution PRIMARY KEY (type_evolution_id)
);

CREATE TABLE type_form_learn
(
    type_form_learn_id BIGINT AUTO_INCREMENT NOT NULL,
    type_learn         VARCHAR(255) NULL,
    CONSTRAINT pk_type_form_learn PRIMARY KEY (type_form_learn_id)
);

CREATE TABLE type_stone
(
    type_stone_id BIGINT AUTO_INCREMENT NOT NULL,
    stone_name    VARCHAR(255) NULL,
    CONSTRAINT pk_type_stone PRIMARY KEY (type_stone_id)
);

CREATE TABLE types
(
    type_id        BIGINT AUTO_INCREMENT NOT NULL,
    name           VARCHAR(255) NULL,
    type_attack_id BIGINT NULL,
    CONSTRAINT pk_types PRIMARY KEY (type_id)
);

ALTER TABLE stone
    ADD CONSTRAINT uc_stone_type_stone UNIQUE (type_stone_id);

ALTER TABLE form_evolution
    ADD CONSTRAINT FK_FORM_EVOLUTION_ON_TYPE_EVOLUTION FOREIGN KEY (type_evolution_id) REFERENCES type_evolution (type_evolution_id);

ALTER TABLE form_learn
    ADD CONSTRAINT FK_FORM_LEARN_ON_TYPE_FORM_LEARN FOREIGN KEY (type_form_learn_id) REFERENCES type_form_learn (type_form_learn_id);

ALTER TABLE level_evolution
    ADD CONSTRAINT FK_LEVEL_EVOLUTION_ON_ID FOREIGN KEY (id) REFERENCES form_evolution (id);

ALTER TABLE level_learn
    ADD CONSTRAINT FK_LEVEL_LEARN_ON_ID FOREIGN KEY (id) REFERENCES form_learn (id);

ALTER TABLE movements
    ADD CONSTRAINT FK_MOVEMENTS_ON_TYPE FOREIGN KEY (type_id) REFERENCES types (type_id);

ALTER TABLE movement_secondary_effects
    ADD CONSTRAINT FK_MOVEMENT_SECONDARY_EFFECTS_ON_MOVEMENTS FOREIGN KEY (movements_id) REFERENCES movements (id);

ALTER TABLE movement_secondary_effects
    ADD CONSTRAINT FK_MOVEMENT_SECONDARY_EFFECTS_ON_SECONDARY_EFFECTS FOREIGN KEY (secondary_effects_id) REFERENCES secondary_efects (id);

ALTER TABLE mo_learn
    ADD CONSTRAINT FK_MO_LEARN_ON_ID FOREIGN KEY (id) REFERENCES form_learn (id);

ALTER TABLE mt_learn
    ADD CONSTRAINT FK_MT_LEARN_ON_ID FOREIGN KEY (id) REFERENCES form_learn (id);

ALTER TABLE pokemon_movement_form
    ADD CONSTRAINT FK_POKEMON_MOVEMENT_FORM_ON_ID_FORM_LEARN FOREIGN KEY (id_form_learn) REFERENCES form_learn (id);

ALTER TABLE pokemon_movement_form
    ADD CONSTRAINT FK_POKEMON_MOVEMENT_FORM_ON_ID_MOVEMENTS FOREIGN KEY (id_movements) REFERENCES movements (id);

ALTER TABLE pokemon_movement_form
    ADD CONSTRAINT FK_POKEMON_MOVEMENT_FORM_ON_POKEDEX_NUMBER FOREIGN KEY (pokedex_number) REFERENCES pokemon (pokedex_number);

ALTER TABLE pokemon
    ADD CONSTRAINT FK_POKEMON_ON_EVOLUTION FOREIGN KEY (evolution_id) REFERENCES pokemon (pokedex_number);

ALTER TABLE stone
    ADD CONSTRAINT FK_STONE_ON_ID FOREIGN KEY (id) REFERENCES form_evolution (id);

ALTER TABLE stone
    ADD CONSTRAINT FK_STONE_ON_TYPE_STONE FOREIGN KEY (type_stone_id) REFERENCES type_stone (type_stone_id);

ALTER TABLE types
    ADD CONSTRAINT FK_TYPES_ON_TYPE_ATTACK FOREIGN KEY (type_attack_id) REFERENCES type_attack (type_attack_id);

ALTER TABLE pokemon_form_evolution
    ADD CONSTRAINT fk_pokforevo_on_form_evolution_entity FOREIGN KEY (form_evolution_id) REFERENCES form_evolution (id);

ALTER TABLE pokemon_form_evolution
    ADD CONSTRAINT fk_pokforevo_on_pokemon_entity FOREIGN KEY (pokedex_number) REFERENCES pokemon (pokedex_number);

ALTER TABLE pokemon_types
    ADD CONSTRAINT fk_poktyp_on_pokemon_entity FOREIGN KEY (pokedex_number) REFERENCES pokemon (pokedex_number);

ALTER TABLE pokemon_types
    ADD CONSTRAINT fk_poktyp_on_type_entity FOREIGN KEY (types) REFERENCES types (type_id);