package co.easysolutions.conctactProjectMigue.service;

import co.easysolutions.conctactProjectMigue.model.Contacs;
import co.easysolutions.conctactProjectMigue.repository.ConctacRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ConctacServiceImpTest {


    private ConctacService conctacService;


    @MockBean
    private ConctacRepository conctacRepository;

    @Before
    public void setUp() {

        Contacs alex = new Contacs("pepa");

        List<Contacs> contacsMocks = Arrays.asList(alex);


        Mockito.when(conctacRepository.findByNameStartingWith("pepa")).thenReturn(contacsMocks);
        Mockito.when(conctacRepository.findById("pepa")).thenReturn(Optional.of(alex));

        Mockito.doNothing().when(conctacRepository).save(alex);

        this.conctacService = new ConctacServiceImp(this.conctacRepository);
    }

    @Test
    public void save() {
        Contacs alex = new Contacs("pepa");
        conctacService.save(alex);
        assertEquals(alex.getName(),conctacRepository.findById("pepa").get().getName());
    }



    @Test
    public void searchByName() {

        List<Contacs> contacs = conctacService.searchByName("pepa");
        assertEquals("pepa",contacs.get(0).getName());

    }
}