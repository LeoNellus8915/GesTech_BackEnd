ALTER TABLE `gestech`.`as_profili_dettagli_candidati` 
CHANGE COLUMN `id_dettagli_candidati` `id_dettaglio_candidato` INT NULL DEFAULT NULL ;

ALTER TABLE `gestech`.`hr_dettagli_candidati` 
DROP COLUMN `linguaggio_campo_libero`;
