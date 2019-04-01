package co.easysolutions.conctactProjectMigue.controller;

import co.easysolutions.conctactProjectMigue.dto.TotalContacts;
import co.easysolutions.conctactProjectMigue.model.Contacs;
import co.easysolutions.conctactProjectMigue.service.ConctacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Controller
public class ConctactNameController {


    private final ConctacService conctacService;

    @Autowired
    public ConctactNameController(ConctacService conctacService) {
        this.conctacService = conctacService;
    }


    @GetMapping("/api/conctact/{parcialName}")
    public ResponseEntity<TotalContacts> serachByName(@PathVariable String parcialName) {
        List<Contacs> result = conctacService.searchByName(parcialName);
        TotalContacts totalContacts = new TotalContacts();
        totalContacts.setContacs(result);
        totalContacts.setTotal(result.size());
        return ResponseEntity.ok(totalContacts);
    }

    @PostMapping("/api/conctact")
    public ResponseEntity<Void> addConctact(@RequestBody String name) {

        conctacService.save(name);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(name)
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
