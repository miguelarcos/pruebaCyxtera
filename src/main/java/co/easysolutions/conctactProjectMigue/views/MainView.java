package co.easysolutions.conctactProjectMigue.views;

import co.easysolutions.conctactProjectMigue.model.Contacs;
import co.easysolutions.conctactProjectMigue.service.ConctacService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route
public class MainView extends VerticalLayout {

    @Autowired
    private ConctacService conctacService;


    Label inputNameL = new Label();
    TextField inputName = new TextField();
    Binder<Contacs> bindName = new Binder<>(Contacs.class);
    Contacs contacs = new Contacs();


    Label inputNameSearch = new Label();
    TextField inputSearch = new TextField();
    Binder<Contacs> bindSearch = new Binder<>(Contacs.class);
    Contacs contacsSearch = new Contacs();

    Grid<Contacs> grid = new Grid<>();



    public MainView() {

        inputNameL.add("Input Name of Conctact");
        bindName.bind(inputName, Contacs::getName, Contacs::setName);

        add(inputNameL);
        add(inputName);


        Button saveButton = new Button("Save",
                event -> {
                    try {
                        bindName.writeBean(contacs);
                        conctacService.save(contacs);
                        contacs = new Contacs();
                        bindName.readBean(contacs);
                        notifyVSuccesfuul("Se Guardo Exitosamente");
                    } catch (ValidationException e) {
                        notifyValidationException(e);
                    }
                });


        add(saveButton);

        Label sz = new Label("");
        sz.setWidth(null);
        sz.setHeight("30px");
        add(sz);


        inputNameSearch.add("Input Name to search");
        bindSearch.bind(inputSearch, Contacs::getName, Contacs::setName);

        add(inputNameSearch);
        add(inputSearch);

        Grid.Column<Contacs> nameColumn = grid.addColumn(Contacs::getName).setHeader("Name");

        Button searchButton = new Button("Search",
                event -> {
                    try {
                        bindSearch.writeBean(contacsSearch);
                        List<Contacs> contacts = conctacService.searchByName(contacsSearch.getName());

                        grid.setItems(contacts);
                        nameColumn.setFooter("Total: " + contacts.size() + " people");


                        notifyVSuccesfuul("Se busco Exitosamente");
                    } catch (ValidationException e) {
                        notifyValidationException(e);
                    }
                });
        add(searchButton);
        add(grid);



    }

    private void notifyValidationException(ValidationException e) {
        Notification.show("Error" + e.getMessage());
    }

    private void notifyVSuccesfuul(String message) {
        Notification.show("Exito" + message);
    }
}