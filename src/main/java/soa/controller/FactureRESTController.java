package soa.controller;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import soa.entities.Facture;
import soa.metier.FactureMetierImpl;
import soa.repository.FactureRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/factures")
public class FactureRESTController {

    @Autowired
    private FactureMetierImpl factureMetier;
    private Facture facture;
    @Autowired
    private FactureRepository factureRepository;

    @GetMapping(value = "/",
            // spécifier le format de retour en XML
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Facture> getlisteFacture() {
        return factureRepository.findAll();
    }

    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable Long id) {
        return

                factureMetier.getFactureById(id);
    }

    @PostMapping("/")
    public Facture ajoutFacture(@RequestBody Facture f) {

        return factureMetier.ajoutFacture(f);
    }

    @PutMapping("/")
    public Facture updateFacture(@RequestBody Facture f) {
        return factureRepository.save(f);
    }

    @DeleteMapping("/{id}")
    public void supprimerFacture(@PathVariable Long id) {
        factureMetier.supprimerFacture(id);

    }


}