package it.teorema.gestech.model.mapper;

import java.time.LocalDateTime;

public interface AllCandidati {
    int getId();
    LocalDateTime getDataInserimento();
    String getNomeCognome();
    String getCitta();
    String getProfiloNome();
    String getCompetenzaPrincipale();
    String getEsitoNome();
}