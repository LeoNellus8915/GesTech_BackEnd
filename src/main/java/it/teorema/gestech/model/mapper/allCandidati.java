package it.teorema.gestech.model.mapper;

import java.time.LocalDateTime;

public interface allCandidati {
    int getId();
    LocalDateTime getDataInserimento();
    String getNomeCognome();
    String getCitta();
    String getProfiloNome();
    String getCompetenzaPrincipale();
    String getEsitoNome();
}