package soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import soa.entities.*;
import java.text.ParseException;

import soa.metier.FactureDetailMetierInterface;
import soa.metier.FactureMetierInterface;
import soa.repository.FactureRepository;

import java.text.SimpleDateFormat;
import java.util.List;


@SpringBootApplication
public class SpringJpaApplication2 {
    //déclaration des objets de type Repository
    //Déclaration d'un objet métier pour gérer les produits

    static FactureMetierInterface factureMetier;
    static FactureRepository fact;
    static FactureDetailMetierInterface factureDetailMetier;


    public static void main(String[] args) {
        ApplicationContext contexte = SpringApplication.run(SpringJpaApplication2.class, args);
        factureMetier = contexte.getBean(FactureMetierInterface.class);
        factureDetailMetier = contexte.getBean(FactureDetailMetierInterface.class);
fact  = contexte.getBean(FactureRepository.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = null;
        java.util.Date date2 = null;
        java.util.Date date3 = null;
        java.util.Date date4 = null;

        //trois objets de type date
        try {
            date1 = sdf.parse("2023-04-15");
            date2 = sdf.parse("2023-02-15");
            date3 = sdf.parse("2023-05-15");
            date4 = sdf.parse("2023-10-15");

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Exemple d'utilisation pour la gestion des facture
        System.out.println("--------- Gestion des facture----------");

        System.out.println("--------- ajouter une facture----------");




        System.out.println("--------- all facture----------");
        List<Facture> ListeFacture = factureMetier.getlisteFacture();
        System.out.println("All facture: " + ListeFacture);

        System.out.println("--------- find Facture by ID----------");
        Long id = 1L;
        Facture facture = factureMetier.getFactureById(id);
        System.out.println("Retrieved Facture by ID " + id + ": " + facture);

        System.out.println("--------- update Facture----------");
        Long idUpdate = 1L;
        int num = 25;

    }}
