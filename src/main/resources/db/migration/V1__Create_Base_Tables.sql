CREATE TABLE IF NOT EXISTS "user" (
	id bigserial PRIMARY KEY,
    login_id VARCHAR(50) NOT NULL,
	"name" VARCHAR(50) NOT NULL,
	"password" TEXT NOT NULL,
	email TEXT NOT NULL,
	phone_no VARCHAR(50) NOT NULL,
    gender VARCHAR(10) NOT NULL,
	"status" VARCHAR(15) NOT NULL,
	"login" VARCHAR(15),
	last_login DATE,

    -- audit
    created_by VARCHAR(50) NOT NULL,
	created_date DATE NOT NULL,
	last_updated_date DATE,
	last_updated_by VARCHAR(50),

	-- delete
	deleted BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS "role" (
	id bigserial PRIMARY KEY,
	"name" VARCHAR(50) NOT NULL,
	"status" VARCHAR(15) NOT NULL,

    -- audit
	created_by VARCHAR(50) NOT NULL,
	created_date DATE NOT NULL,
	last_updated_date DATE,
	last_updated_by VARCHAR(50),

	-- delete
    deleted BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS "permission" (
	id bigserial PRIMARY KEY,
	"name" VARCHAR(50) NOT NULL,
	"status" VARCHAR(15) NOT NULL,

    -- audit
	created_by VARCHAR(50) NOT NULL,
	created_date DATE NOT NULL,
	last_updated_date DATE,
	last_updated_by VARCHAR(50),

	-- delete
    deleted BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS "module" (
	id bigserial PRIMARY KEY,
	"name" VARCHAR(50) NOT NULL,
	"status" VARCHAR(15) NOT NULL,

    -- audit
	created_by VARCHAR(50) NOT NULL,
	created_date DATE NOT NULL,
	last_updated_date DATE,
	last_updated_by VARCHAR(50),

	-- delete
    deleted BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS role_permission (
	id bigserial PRIMARY KEY,
	role_id BIGINT REFERENCES "role"(id) NOT NULL,
	module_id BIGINT REFERENCES "module"(id) NOT NULL,
    permission_id BIGINT REFERENCES "permission"(id) NOT NULL,
    "status" VARCHAR(15) NOT NULL,

    -- audit
	created_by VARCHAR(50) NOT NULL,
	created_date DATE NOT NULL,
	last_updated_date DATE,
	last_updated_by VARCHAR(50),

    -- delete
    deleted BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS user_role (
	id bigserial PRIMARY KEY,
	user_id BIGINT NOT NULL REFERENCES "user"(id) UNIQUE,
	role_id BIGINT REFERENCES "role"(id) NOT NULL,
    "status" VARCHAR(15) NOT NULL,

    -- audit
	created_by VARCHAR(50) NOT NULL,
	created_date DATE NOT NULL,
	last_updated_date DATE,
	last_updated_by VARCHAR(50),

    -- delete
    deleted BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS user_token (
	id bigserial PRIMARY KEY,
	token text NOT NULL,
	token_type VARCHAR(15) NOT NULL,
    revoked BOOLEAN NOT NULL,
    expired BOOLEAN NOT NULL,
    user_id BIGINT REFERENCES "user"(id) NOT NULL,

    -- audit
	created_by VARCHAR(50) NOT NULL,
	created_date DATE NOT NULL,
	last_updated_date DATE,
	last_updated_by VARCHAR(50),

	-- delete
    deleted BOOLEAN NOT NULL
);