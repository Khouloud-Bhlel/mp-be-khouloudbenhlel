package soa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import soa.entities.Facture;
import soa.entities.FactureDetail;
import soa.entities.Produit;
import soa.metier.FactureDetailMetierImpl;
import soa.repository.FactureDetailRepository;
import soa.repository.FactureRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Optional;
@ExtendWith(MockitoExtension.class)

public class FactureDetailTest {

    @Mock
    private FactureDetailRepository factureDetailRepository;
    @InjectMocks
    private FactureDetailMetierImpl factureDetailMetier;
    FactureDetail FD1 = new FactureDetail(1L, 5, 10.0, 50.0, new Facture(), new Produit());
    FactureDetail FD2 = new FactureDetail(2L, 4, 10.0, 40.0, new Facture(), new Produit());

    @Test
    public void testAjoutFactureDetail() {
        //Definir la valeur de retour attendue du mock

        when(factureDetailRepository.save(any(FactureDetail.class))).thenReturn(FD1);

        factureDetailMetier.ajoutFactureDetail(FD1);

        verify(factureDetailRepository, times(1)).save(FD1);
    }

    @Test
    public void testGetFactureDetailById() {
        when(factureDetailRepository.findById(1L)).thenReturn(java.util.Optional.of(FD1));

        FactureDetail result = factureDetailMetier.getFactureDetailById(1L);

        assertEquals(FD1, result);
    }

    @Test
    public void testSupprimerFactureDetail() {
        factureDetailMetier.supprimerFactureDetail(1L);

        verify(factureDetailRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateFactureDetail() {
        when(factureDetailRepository.findById(1L)).thenReturn(java.util.Optional.of(FD1));
        when(factureDetailRepository.save(any(FactureDetail.class))).thenReturn(FD1);

        FactureDetail result = factureDetailMetier.updateFactureDetail(1L);

        assertEquals(FD1, result);
    }
    @Test
    public void testMontantFactureDetail() {

        assertEquals(5, FD1.getQuantite());
        assertEquals(10.0, FD1.getPrix());
        assertEquals(50.0, FD1.getMontant());
    }

    @Test
    public void testAjoutFactureDetailCalculMontant() {
        when(factureDetailRepository.save(any(FactureDetail.class))).thenReturn(FD2);

        factureDetailMetier.ajoutFactureDetail(FD2);

        assertEquals(40.0, FD2.getMontant());
        verify(factureDetailRepository, times(1)).save(FD2);
    }
}
