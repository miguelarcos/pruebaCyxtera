package co.easysolutions.conctactProjectMigue.service;

import co.easysolutions.conctactProjectMigue.model.Contacs;

import java.util.List;

public interface ConctacService {
    void save(String name);

    void save(Contacs contacs);
    List<Contacs> searchByName(String parcialName);
}
