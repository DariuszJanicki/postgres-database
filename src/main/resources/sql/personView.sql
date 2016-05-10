CREATE OR REPLACE VIEW public.person_view AS
SELECT
  row_number() OVER () AS id,
  p.id AS person_id,
  p.name AS name,
  p.surname AS surname
FROM public.person p;