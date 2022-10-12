ALTER TABLE `gestech`.`hy_commenti_richieste` 
CHANGE COLUMN `id_dettaglio_candidato` `id_persona` INT NULL DEFAULT NULL ;

ALTER TABLE `gestech`.`hy_ruoli_persona` 
RENAME TO  `gestech`.`hy_ruoli_persone` ;

ALTER TABLE `gestech`.`hy_profili_dettagli_candidati` 
CHANGE COLUMN `id_livelli` `id_livello` INT NULL DEFAULT NULL ;

CREATE TABLE sy_richieste_persone (
  id int NOT NULL AUTO_INCREMENT,
  id_persona int DEFAULT NULL,
  id_richiesta int DEFAULT NULL,
  visualizzato tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id)
)

DELETE FROM `gestech`.`hr_contratti` WHERE (`id` = '1');
INSERT INTO `gestech`.`hr_contratti` (`id`, `id_persona`, `id_azienda`) VALUES ('1', '1', '5');