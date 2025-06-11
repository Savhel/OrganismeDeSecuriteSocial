package com.fivet.organismedesecuritesocial.Services.Personne.Creation;

import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Repositories.AssureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateAssure implements CreateAccountInterface<Assure>  {

    @Autowired
    private AssureRepository assureRepository;


    @Override
    public Assure createAccount(Assure assure) {
        return assureRepository.save(assure);
    }


}
