package question3;

import question3.tp3.PileI;
import question3.tp3.PileVideException;
import question3.tp3.PilePleineException;

/**
 * Repr�sente le mod�le dans une impl�mentation MVC d'une calculette � pile.
 * 
 * @author Elie DAHER
 * @version 1.0
 */

public class PileModele<T> extends  java.util.Observable implements PileI<T> {

    private PileI<T> pile;

    /* à compléter */
    /**
     * Cr�e une nouvelle instance de {@see question3.PileModele}.
     * 
     * @param pile Instance de pile utilis�e pour empiler les op�randes.
     */

    public PileModele(PileI<T> pile) {
        this.pile = pile;
    }

    /**
     * Empile un op�rande dans la calculette.
     * 
     * @param o Op�rande � empiler.
     */

    public void empiler(T o) throws PilePleineException {
        pile.empiler(o);
        setChanged();
        notifyObservers(o);
    }

    /**
     * D�pile un op�rande de la calculette.
     * 
     * @return Op�rande d�pil�.
     */

    public T depiler() throws PileVideException {
        T item = pile.depiler();
        setChanged();
        notifyObservers(item);
        return item;
    }

    /**
     * Retourne le dernier op�rande empil� dans la calculette.
     */

    public T sommet() throws PileVideException {
        return pile.sommet();
    }

    /**
     * Retourne le taille de la pile interne de la calculette.
     */
    public int taille() {
        return pile.taille();
    }

    /**
     * Retourne la capacit� de la pile interne de la calculette.
     */
    public int capacite() {
        return pile.capacite();
    }

    
    /**
     * D�finit si la pile interne est vide.
     */
    public boolean estVide() {
        return pile.estVide();
    }

    
    /**
     * D�finit si la pile interne est pleine.
     */
    public boolean estPleine() {
        return pile.estPleine();
    }

    public String toString() {
        return pile.toString();
    }
}

/**
 * notez qu'un message d'alerte subsiste à la compilation (unsafe ...) dû à
 * l'emploi de notifyObservers, incontournable et sans conséquence ici
 */
