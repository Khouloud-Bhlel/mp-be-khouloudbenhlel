package soa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import soa.entities.*;
import soa.repository.*;

@SpringBootApplication
public class SpringJpaApplication
{
    //déclaration des objets de type Repository
    //Déclaration d'un repository pour gérer les produits
    static ProduitRepository produitRepos ;
    //Déclaration d'un repository pour gérer les catégories
    static CategorieRepository categorieRepos;
    //Déclaration d'un repository pour gérer les stocks
    static StockRepository stockRepos;
    //Déclaration d'un repository pour gérer les responsables
    static ResponsableRepository responsableRepos;
    //Déclaration d'un repository pour gérer les factures
    static FactureRepository factureRepos;

    //Déclaration d'un repository pour gérer les factures
    static FactureDetailRepository factureDetailRepos;
    //Déclaration d'un repository pour gérer les devises
    static DeviseRepository deviseRepos;
    //Déclaration d'un repository pour gérer les reglement
    static ReglementFactureRepository reglementFactureRepository;
    //Déclaration d'un repository pour gérer les reglement
    static ReglementRepository reglementRepos;


    public static void main(String[] args) {
        System.out.println("---------Démarrage----------");
        //Commencer par réaliser les injections de dépendances pour les objets de type Repository
        // référencer le contexte
        ApplicationContext contexte = SpringApplication.run(SpringJpaApplication.class, args);

        // Récupérer une implémentation de l'interface "ProduitRepository" par injection de dépendance
        produitRepos = contexte.getBean(ProduitRepository.class);
        // Récupérer une implémentation de l'interface "CategorieRepository" par injection de dépendance
        categorieRepos = contexte.getBean(CategorieRepository.class);
        // Récupérer une implémentation de l'interface "StockRepository" par injection de dépendance
        stockRepos = contexte.getBean(StockRepository.class);
        // Récupérer une implémentation de l'interface "ResponsableRepository" par injection de dépendance
        responsableRepos = contexte.getBean(ResponsableRepository.class);
        // Récupérer une implémentation de l'interface "FactureRepository" par injection de dépendance
        factureRepos = contexte.getBean(FactureRepository.class);
        // Récupérer une implémentation de l'interface "FactureDetailRepository" par injection de dépendance
        factureDetailRepos = contexte.getBean(FactureDetailRepository.class);
        // Récupérer une implémentation de l'interface "DeviseRepository" par injection de dépendance
        deviseRepos = contexte.getBean(DeviseRepository.class);
        // Récupérer une implémentation de l'interface "ReglementRepository" par injection de dépendance
       reglementRepos = contexte.getBean(ReglementRepository.class);
        // Récupérer une implémentation de l'interface "ReglementRepository" par injection de dépendance
        reglementFactureRepository = contexte.getBean(ReglementFactureRepository.class);
        System.out.println("---------Insertion de deux catégories----------");
        // créer deux catégories (en mémoire)
        Categorie cat1 = new Categorie("AL", "Alimentaire");
        Categorie cat2 = new Categorie("PL", "Plastique");


        //Attacher les deux catégories à la BD (insertion)
        categorieRepos.save(cat1);
        categorieRepos.save(cat2);

        //objet pour formater les dates selon le pattern "yyyy-MM-dd"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = null;
        java.util.Date date2 = null;
        java.util.Date date3 = null;
        java.util.Date date4 = null;


        // Insérer 3 produits
        System.out.println("---------Insertion de trois produits----------");
        Produit p1 = new Produit(1l,"Yaourt", 0.400, 20, date1, cat1);
        Produit p2 = new Produit(2L,"Chocolat", 2000.0, 5, date2, cat1);
        Produit p3 = new Produit(3L,"Panier", 1.200, 30, date3, cat2);

        produitRepos.save(p1);
        produitRepos.save(p2);
        produitRepos.save(p3);

        //Afficher la liste des produits
        afficherTousLesProduits();

        //Afficher la liste des produits d'une catégorie donnée
       // afficherTousLesProduitsDeLaCategorie(1L);


        // gérer les reponsables des stocks
        //créer un responsable "Ali Ben Saleh" et l'affecter à un nouveau Stock de "Tunis"
        Responsable r1 = new Responsable(1L,"Ben Saleh", "Ali");
        responsableRepos.save(r1);



        //créer un responsable "Omar Ben Ahmed" et l'affecter à un nouveau Stock de "Sousse"
        Responsable r2 = new Responsable(2L,"Ben Ahmed", "Omar");
        responsableRepos.save(r2);

        //créer un responsable "Samira Sallemi" et l'affecter à un nouveau Stock de "Sfax"
        Responsable r3 = new Responsable(3L,"Sallemi", "Samira");
        responsableRepos.save(r3);

Responsable r=new Responsable(1l);
        //Afficher la liste des responsables (chaque responsable avec le stock qui lui est associé s’il existe)
        afficherTousLesResponsables();

        //insertion devise
        Devise d1=new Devise(1l,"DINAR","DT");
        deviseRepos.save(d1);
        Devise d2=new Devise(2l,"EURO","£");
        deviseRepos.save(d1);
        // insertion facture en affecter un responsable
       Facture f1=new Facture(1L,4,"5/9/2023",r1,d1);
        factureRepos.save(f1);
        Facture f2=new Facture(3l,5,"20/1/2023",r2,d2);
        factureRepos.save(f2);
        //afficher les list des fectures
        afficherTousLesFactures();


         //insertion detailfacture
        FactureDetail dfact1=new FactureDetail(1l,1,400,f1,p1);
        factureDetailRepos.save(dfact1);

        FactureDetail dfact2=new FactureDetail(2l,1,2000,f2,p2);
        factureDetailRepos.save(dfact2);

        // insertion reglement
        Reglement rg=new Reglement(1L,400,date4,5.6,2.5);
        reglementRepos.save(rg);
        // insertion reglement facture
        ReglementFacture rf=new ReglementFacture(1l,800,f1,rg);
        reglementFactureRepository.save(rf);
    }
    static void afficherTousLesResponsables()
    {
        System.out.println("********************Début**********************");
        System.out.println("Afficher tous les responsables avec leurs stocks");
        System.out.println("***********************************************");
        Collection <Responsable> lr = responsableRepos.findAll();
        for (Responsable r : lr)
        {
            System.out.println(r);
        }
        System.out.println("********************Fin************************");
    }
    static void afficherTousLesProduits()
    {
        System.out.println("********************Début**********************");
        System.out.println("Afficher tous les produits...");
        System.out.println("***********************************************");

        List<Produit> lp = produitRepos.findAll();
        for (Produit p : lp)
        {
            System.out.println(p);
        }
        System.out.println("********************Fin************************");
    }


    static void afficherTousLesFactures()
    {
        System.out.println("********************Début**********************");
        System.out.println("Afficher tous les factures...");
        System.out.println("***********************************************");

        List<Facture> lf = factureRepos.findAll();
        for (Facture f : lf)
        {
            System.out.println(f);
        }
        System.out.println("********************Fin************************");
    }

    static void afficherFactureDetail(Facture fact)
    {
        System.out.println("********************Début**********************");
        System.out.println("Afficher detail facture...");
        System.out.println("***********************************************");

        List<FactureDetail> lfd =factureDetailRepos.findAll();
        for (FactureDetail f : lfd)
        {
            System.out.println(f);
        }
        System.out.println("********************Fin************************");
    }
}
