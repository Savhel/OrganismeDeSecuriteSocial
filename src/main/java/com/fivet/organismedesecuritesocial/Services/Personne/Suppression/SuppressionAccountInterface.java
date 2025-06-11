package com.fivet.organismedesecuritesocial.Services.Personne.Suppression;

import java.util.UUID;

public interface SuppressionAccountInterface<T> {
    Boolean supprimerAccount(UUID idPersonne);
}
