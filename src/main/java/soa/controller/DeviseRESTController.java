package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soa.entities.Devise;
import soa.entities.Responsable;
import soa.repository.DeviseRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/devises")
public class DeviseRESTController {
    @Autowired
    private DeviseRepository deviseRepository;
    @GetMapping(value = "/",
            // spécifier le format de retour en XML
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Devise> getdevise() {

        return deviseRepository.findAll();
}}
