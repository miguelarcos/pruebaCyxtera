package co.easysolutions.conctactProjectMigue.service;


import co.easysolutions.conctactProjectMigue.model.Contacs;
import co.easysolutions.conctactProjectMigue.repository.ConctacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConctacServiceImp implements ConctacService {

    private final ConctacRepository conctacRepository;

    @Autowired
    public ConctacServiceImp(ConctacRepository conctacRepository) {
        this.conctacRepository = conctacRepository;
    }

    @Override
    public void save(String name) {
        conctacRepository.save(new Contacs(name));
    }

    @Override
    public void save(Contacs contacs) {
        conctacRepository.save(contacs);
    }

    @Override
    public List<Contacs> searchByName(String parcialName) {
        return conctacRepository.findByNameStartingWith(parcialName);
    }
}
