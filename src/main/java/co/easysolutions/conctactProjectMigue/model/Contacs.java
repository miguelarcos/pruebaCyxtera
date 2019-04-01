package co.easysolutions.conctactProjectMigue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contacs {

    @Id
    @Column(nullable = false, length = 21)
    private String name;


    public Contacs() {

    }

    public Contacs(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
