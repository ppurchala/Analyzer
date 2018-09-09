CREATE TABLE public.result
(
    id bigint NOT NULL,
    url_id bigint NOT NULL,
    minimum_price NUMERIC (9, 2),
    maximum_price NUMERIC (9, 2),
    medium_price NUMERIC (9, 2),
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.result
OWNER to analyzerdbuser;
