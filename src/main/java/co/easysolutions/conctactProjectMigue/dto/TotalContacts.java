package co.easysolutions.conctactProjectMigue.dto;

import co.easysolutions.conctactProjectMigue.model.Contacs;

import java.util.List;

public class TotalContacts {

    private int total;
    private List<Contacs> contacs;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Contacs> getContacs() {
        return contacs;
    }

    public void setContacs(List<Contacs> contacs) {
        this.contacs = contacs;
    }
}
