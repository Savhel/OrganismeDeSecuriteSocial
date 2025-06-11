package com.fivet.organismedesecuritesocial.Services.Personne.Lecture;

import java.util.List;
import java.util.UUID;

public interface LectureAccountInterface<T> {
    T lireAccount(UUID idPersonne);
    List<T> lireAccounts();
}
