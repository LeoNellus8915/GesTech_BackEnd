package it.teorema.gestech.model.mapper;

import java.time.LocalDateTime;

public interface AllCandidati {
    int getId();
    LocalDateTime getDataInserimento();
    String getNome();
    String getCognome();
    String getCitta();
    String getCompetenzaPrincipale();
    String getEsitoNome();
}