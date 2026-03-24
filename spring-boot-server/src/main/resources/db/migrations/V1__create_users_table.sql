CREATE EXTENSION IF NOT EXISTS "pgcrypto";

DO $$ BEGIN
CREATE TYPE document_type_enum AS ENUM ('CC', 'CE', 'PP');
EXCEPTION WHEN duplicate_object THEN NULL;
END $$;

DO $$ BEGIN
CREATE TYPE role_enum AS ENUM ('USER', 'ADMIN');
EXCEPTION WHEN duplicate_object THEN NULL;
END $$;

CREATE TABLE IF NOT EXISTS users (
                                     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    names VARCHAR(100) NOT NULL,
    last_names VARCHAR(100) NOT NULL,
    document_type document_type_enum NOT NULL,
    document VARCHAR(15) NOT NULL,
    password TEXT NOT NULL,
    role role_enum NOT NULL DEFAULT 'USER',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID,
    updated_at TIMESTAMP,
    updated_by UUID,
    deleted_at TIMESTAMP,
    deleted_by UUID,

    CONSTRAINT uq_document_type_document UNIQUE (document_type, document)
);