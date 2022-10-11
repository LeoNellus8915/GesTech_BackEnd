ALTER TABLE `gestech`.`hy_commenti_richieste` 
CHANGE COLUMN `id_dettaglio_candidato` `id_persona` INT NULL DEFAULT NULL ;

ALTER TABLE `gestech`.`hy_ruoli_persona` 
RENAME TO  `gestech`.`hy_ruoli_persone` ;

ALTER TABLE `gestech`.`hy_profili_dettagli_candidati` 
CHANGE COLUMN `id_livelli` `id_livello` INT NULL DEFAULT NULL ;