package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soa.entities.Produit;
import soa.repository.ProduitRepository;
import java.util.List;
import java.util.Optional;
@RestController // pour déclarer un service web de type REST
@RequestMapping("/produits") // relatif à http://localhost:8081/produits
public class ProduitRESTController {

    @Autowired
    private ProduitRepository produitRepos;

    // Message d'accueil
    @GetMapping(value = "/index")
    public String accueil() {
        return "Bienvenue au service Web REST 'produits'.....";
    }

    // Afficher la liste des produits
    @GetMapping(value = "/", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Produit> getAllProduits() {
        return produitRepos.findAll();
    }

    // Récupérer un produit par son ID
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        Optional<Produit> produit = produitRepos.findById(id);
        return produit.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Supprimer un produit par 'id' avec la méthode 'DELETE'
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        if (produitRepos.existsById(id)) {
            produitRepos.deleteById(id);
            return ResponseEntity.noContent().build(); // No content - successful deletion
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Ajouter un produit avec la méthode "POST"
    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Produit saveProduit(@RequestBody Produit p) {
        return produitRepos.save(p);
    }

    // Modifier un produit avec la méthode "PUT"
    @PutMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Produit updateProduit(@RequestBody Produit p) {
        return produitRepos.save(p);
    }

    // Supprimer un produit avec la méthode 'DELETE'
    @DeleteMapping(value = "/")
    public void deleteProduit(@RequestBody Produit p) {
        produitRepos.delete(p);
    }
}


/*package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.entities.Produit;
import soa.repository.ProduitRepository;
import java.util.List;
import java.util.Optional;


@RestController // pour déclarer un service web de type REST
@RequestMapping("/produits") // relatif à http://localhost:8081/produits
public class ProduitRESTController {

    @Autowired // pour l'injection de dépendances
    private ProduitRepository produitRepos;

    // Message d'accueil
    // http://localhost:8081/produits/index (GET)
    @GetMapping(value = "/index")
    public String accueil() {
        return "Bienvenue au service Web REST 'produits'.....";
    }

    // Afficher la liste des produits
    // http://localhost:8081/produits/ (GET)
    // spécifier le format de retour en XML
    @GetMapping(value = "/" ,produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
    public List<Produit> getAllProduits() {
        return produitRepos.findAll();
    }

    // Récupérer un produit par son ID
    // http://localhost:8081/produits/{id} (GET)
    @GetMapping(value = "/{id}" , produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE})
    public Produit getProduitById(@PathVariable Long id) {
        Optional<Produit> produit = produitRepos.findById(id);
        if (produit.isPresent()) {
            return produit.get();
        } else {
            throw new RuntimeException("Produit introuvable pour l'id : " + id);
        }
    }

    // Supprimer un produit par 'id' avec la méthode 'GET'
// http://localhost:8081/produits/delete/{id} (GET)
    @GetMapping(
// spécifier le path de la méthode
            value = "/delete/{id}")
    public void deleteProduit(@PathVariable Long id)
    {
        produitRepos.deleteById(id);
    }

    // ajouter un produit avec la méthode "POST"
// http://localhost:8081/produits/ (POST)
    @PostMapping(
// spécifier le path de la méthode
            value = "/" ,
//spécifier le format de retour
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE }
    )
    public Produit saveProduit(@RequestBody Produit p)
    {
        return produitRepos.save(p);
    }

    // modifier un produit avec la méthode "PUT"
// http://localhost:8081/produits/ (PUT)
    @PutMapping(
// spécifier le path de la méthode
            value = "/" ,
//spécifier le format de retour
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE }
    )
    public Produit updateProduit(@RequestBody Produit p)
    {
        return produitRepos.save(p);
    }

    // Supprimer un produit avec la méthode 'DELETE'
// http://localhost:8081/produits/ (DELETE)
    @DeleteMapping(
// spécifier le path de la méthode
            value = "/")
    public void deleteProduit(@RequestBody Produit p)
    {
        produitRepos.delete(p);
    }
}*/
