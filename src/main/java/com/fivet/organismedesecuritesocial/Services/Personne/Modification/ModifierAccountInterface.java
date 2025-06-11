package com.fivet.organismedesecuritesocial.Services.Personne.Modification;

import java.util.UUID;

public interface ModifierAccountInterface<T> {
    T modifierAccount(T t, UUID idPersonne);
}
