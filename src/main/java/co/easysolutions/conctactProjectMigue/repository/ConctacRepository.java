package co.easysolutions.conctactProjectMigue.repository;

import co.easysolutions.conctactProjectMigue.model.Contacs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConctacRepository extends JpaRepository<Contacs, String> {

    List<Contacs> findByNameStartingWith(String parcialName);
}
