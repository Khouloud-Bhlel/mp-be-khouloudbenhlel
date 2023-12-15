package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.entities.Facture;
import soa.entities.Responsable;
import soa.repository.FactureRepository;
import soa.repository.ResponsableRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clients")
public class ClientRESTController {
    @Autowired
    private ResponsableRepository responsableRepository;
    @GetMapping(value = "/",
            // spécifier le format de retour en XML
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Responsable> getclient() {

        return responsableRepository.findAll();
    }
    @GetMapping(value = "/{nom}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Responsable getresponsablebyname(@PathVariable String nom) {
        return responsableRepository.findByNom(nom);
    }
}
