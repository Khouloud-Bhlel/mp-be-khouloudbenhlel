package soa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import soa.entities.Devise;
import soa.entities.Facture;
import soa.entities.Responsable;
import soa.metier.FactureMetierImpl;
import soa.repository.FactureRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FactureTest {
    // crée une instance mockée de la classe
    @Mock
    private FactureRepository factureRepository;
    @InjectMocks
    private FactureMetierImpl factureMetier;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    Facture f = new Facture();
    Responsable R1 = new Responsable(1L);
    Devise D1 = new Devise(1L);
    Facture F1 = new Facture(1L, 1, "02/03/2023", R1, D1);
    Facture F2 = new Facture(2L, 2, "10/05/2022", R1, D1);
    Facture F3 = new Facture(3L, 3, "18/12/2023", R1, D1);

    //vérifions les méthodes de FactureMetierImpl fonctionnent comme prévu en utilisant les méthodes when() et verify() de Mockito.
    @Test
    public void testAjoutFacture() {

        //Definir la valeur de retour attendue du mock
        when(factureRepository.save(F1)).thenReturn(F1);
        //Executer le test
        Facture result = factureMetier.ajoutFacture(F1);
        //verfiez
        assertEquals(F1, result);
        //assertEquals(F2, result);
        verify(factureRepository, times(1)).save(F1);
    }

    @Test
    public void testGetListeFacture() {
        List<Facture> factures = new ArrayList<>();
        factures.add(F1);
        factures.add(F2);
        when(factureRepository.findAll()).thenReturn(factures);
        List<Facture> result = factureMetier.getlisteFacture();
        //assertTrue(result.contains(F3));
        assertTrue(result.contains(F1));
        assertTrue(result.contains(F2));
        // assertEquals(3, result.size());
        assertEquals(2, result.size());

    }

    @Test
    public void testGetFactureById() {
        //Long id = 2L;
        Long id = 1L;
        when(factureRepository.findById(id)).thenReturn(java.util.Optional.of(F1));
        Facture result = factureMetier.getFactureById(1L);
        // Facture result = factureMetier.getFactureById(4L);
        assertEquals(F1, result);
        //assertEquals(F2, result);
    }

    @Test
    public void testSupprimerFacture() {
        //F1----id=1L
        factureMetier.supprimerFacture(F1.getId());
        //vérifier que  deleteById a  été appelée une fois avec l'ID spécifié
        verify(factureRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateFacture() {
        // Créer une facture fictive pour le test
        Long id = 1L;
        // Configurer le comportement du factureRepository.findById pour retourner la facture fictive
        when(factureRepository.findById(id)).thenReturn(Optional.of(F1));

        // Configurer le comportement du factureRepository.save pour retourner la facture fictive
        when(factureRepository.save(F1)).thenReturn(F1);

        // Appeler la méthode updateFacture
        Facture result = factureMetier.updateFacture(id, F1);  // Assurez-vous de passer une instance de Facture avec des valeurs appropriées

        // Vérifier que la mise à jour a réussi
        assertNotNull(result);
        assertEquals(F1.getNumero(), result.getNumero());  // Assurez-vous d'ajuster cette vérification en fonction des propriétés de votre Facture
    }
}
