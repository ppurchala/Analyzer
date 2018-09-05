CREATE TABLE public.url
(
    id bigint NOT NULL,
    url character varying(1000),
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.url
OWNER to analyzerdbuser;
