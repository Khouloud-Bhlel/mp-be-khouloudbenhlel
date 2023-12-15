package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.entities.Produit;
import soa.entities.Responsable;
import soa.repository.ProduitRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // pour déclarer un service web de type REST
@RequestMapping("/produits") // http://localhost:8081/produits
public class ProduitRESTController {
    @Autowired // pour l'injection de dépendances
    private ProduitRepository produitRepos;

    // Message d'accueil
    // http://localhost:8081/produits/index (GET)
    @GetMapping(value = "/index")
    public String accueil() {
        return "BienVenue au service Web REST 'produits'.....";
    }

    // Afficher la liste des produits
    // http://localhost:8081/produits/ (GET)
    @GetMapping(
            // spécifier le path de la méthode
            value = "/",
            // spécifier le format de retour en XML
            produces = { MediaType.APPLICATION_JSON_VALUE}

    )
    public List<Produit> getAllProduits() {
        return produitRepos.findAll();
    }




    // Afficher un produit en spécifiant son 'id'
    // http://localhost:8081/produits/{id} (GET)
    @GetMapping(
            // spécifier le path de la méthode qui englobe un paramètre
            value = "/{id}",
            // spécifier le format de retour en XML
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public Produit getProduit(@PathVariable Long id) {
        Produit p = produitRepos.findById(id).get();
        return p;
    }

    // Supprimer un produit par 'id' avec la méthode 'GET'
    // http://localhost:8080/produits/delete/{id} (GET)
    @GetMapping(
            // spécifier le path de la méthode
            value = "/delete/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitRepos.deleteById(id);
    }

    // ajouter un produit avec la méthode "POST"
    // http://localhost:8080/produits/ (POST)
    @PostMapping(
            // spécifier le path de la méthode
            value = "/",
            //spécifier le format de retour
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}
    )
    public Produit saveProduit(@RequestBody Produit p) {
        return produitRepos.save(p);
    }

    // modifier un produit avec la méthode "PUT"
// http://localhost:8080/produits/ (PUT)
    @PutMapping(
// spécifier le path de la méthode
            value = "/" ,
//spécifier le format de retour
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Produit updateProduit(@RequestBody Produit p)
    {
        return produitRepos.save(p);
    }

// Supprimer un produit avec la méthode 'DELETE' // http://localhost:8080/produits/ (DELETE)
@DeleteMapping( // spécifier le path de la méthode
 value = "/")
public void deleteProduit(@RequestBody Produit p) { produitRepos.delete(p); }
    @GetMapping(value = "/{id}/prix", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double getProduitPrixById(@PathVariable Long id) {
        Produit produit = produitRepos.findById(id).orElse(null);
        if (produit != null) {
            return produit.getPrix();
        } else {
            // Gérer le cas où le produit n'est pas trouvé, par exemple en renvoyant un code d'erreur ou une valeur par défaut
            return null;
        }
    }
}