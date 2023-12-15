package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.entities.FactureDetail;
import soa.metier.FactureDetailMetierImpl;
import soa.metier.FactureDetailMetierInterface;
import soa.metier.FactureMetierImpl;
import soa.repository.FactureDetailRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/factureDetail")
public class FactureDetailRESTController {

    @Autowired
    private FactureDetailRepository factureDetailRepository;
    @Autowired

    private  FactureDetailMetierImpl factureDetailMetier;

    @PostMapping("/")
    public void ajoutFactureDetail(@RequestBody FactureDetail df) {

        factureDetailMetier.ajoutFactureDetail(df);
    }

    @PostMapping("/{factureId}")
    public void ajoutFactureDetail(@RequestBody FactureDetail df, @PathVariable Long factureId) {
        factureDetailRepository.save(df);
    }
    @GetMapping("/")
    public List<FactureDetail> getAllFactureDetails() {
        return factureDetailRepository.findAll();
    }


    @GetMapping("/{id}")
    public FactureDetail getFactureDetailById(@PathVariable Long id) {
        return factureDetailRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void supprimerFactureDetail(@PathVariable Long id) {
        factureDetailMetier.supprimerFactureDetail(id);
    }

    @PutMapping("/{id}")
    public FactureDetail updateFactureDetail(@PathVariable Long id) {
        return factureDetailMetier.updateFactureDetail(id);
    }
    @PostMapping("/calculeMontant")
    public double calculeMontant(@RequestBody FactureDetail factureDetail) {
        return factureDetailMetier.calculeMontant(factureDetail);
    }
}
