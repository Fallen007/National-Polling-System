--administrators table creation
CREATE TABLE IF NOT EXISTS public.administrators
(
    email character varying NOT NULL,
    password character varying NOT NULL,
    CONSTRAINT administrators_pkey PRIMARY KEY (email)
)

--voters table creation
CREATE TABLE IF NOT EXISTS public.voters
(
    voter_id bigint NOT NULL,
    name character varying NOT NULL,
    gender character varying NOT NULL,
    age integer NOT NULL,
    ethnicity character varying NOT NULL,
    state character varying NOT NULL,
    email character varying NOT NULL,
    CONSTRAINT voters_pkey PRIMARY KEY (voter_id),
    CONSTRAINT email_unique_constraint UNIQUE (email),
    CONSTRAINT age_over_18_constraint CHECK (age >= 18)
)

--elections table creation
CREATE TABLE IF NOT EXISTS public.elections
(
    election_id integer NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL,
    CONSTRAINT elections_pkey PRIMARY KEY (election_id)
)

--election_candidates table creation
CREATE TABLE IF NOT EXISTS public.election_candidates
(
    election_id integer NOT NULL,
    candidate_id bigint NOT NULL,
    candidate_voter_id bigint NOT NULL,
    political_party character varying NOT NULL,
    CONSTRAINT election_candidates_pkey PRIMARY KEY (candidate_id),
    CONSTRAINT candidate_voter_id_fkey_constraint FOREIGN KEY (candidate_voter_id)
    REFERENCES public.voters (voter_id),
    CONSTRAINT election_id_fkey_constraint FOREIGN KEY (election_id)
    REFERENCES public.elections (election_id)
)

--election_votes table creation
CREATE TABLE IF NOT EXISTS public.election_votes
(
    election_id integer NOT NULL,
    candidate_id bigint NOT NULL,
    voter_id bigint NOT NULL,
    CONSTRAINT candidate_id_fkey_constraint FOREIGN KEY (candidate_id)
    REFERENCES public.election_candidates (candidate_id),
    CONSTRAINT election_id_fkey_constraint FOREIGN KEY (election_id)
    REFERENCES public.elections (election_id),
    CONSTRAINT voter_id_fkey_constraint FOREIGN KEY (voter_id)
    REFERENCES public.voters (voter_id)
)

--otp table creation
CREATE TABLE IF NOT EXISTS public.otp
(
    email character varying NOT NULL,
    generated_otp character varying NOT NULL,
    otp_expiration_time timestamp without time zone NOT NULL,
    CONSTRAINT otp_pkey PRIMARY KEY (email)
)