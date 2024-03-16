import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Reparticion
        Deck deck = new Deck();

        deck.shuffle();

        System.out.println("\nSe esta Seleccionando la primera carta:");
        deck.head();

        System.out.println("\nSe esta Seleccionando una carta al azar:");
        deck.pick();

        System.out.println("\nSe esta Repartiendo una mano de 5 cartas:");
        deck.hand();
    }

    // Clase que representa una carta de poker
    static class Card {
        private String palo;
        private String color;
        private String valor;

        public Card(String palo, String color, String valor) {
            this.palo = palo;
            this.color = color;
            this.valor = valor;
        }

        public String getPalo() {
            return palo;
        }

        public String getColor() {
            return color;
        }

        public String getValor() {
            return valor;
        }

        @Override
        public String toString() {
            return palo + "," + color + "," + valor;
        }
    }

    // Clase que representa el deck de cartas de poker
    static class Deck {
        private List<Card> cards;

        public Deck() {
            cards = new ArrayList<>();
            initializeDeck();
        }

        // inicio de las barajas de poker
        private void initializeDeck() {
            String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
            String[] colores = {"Negro", "Rojo"};
            String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};


            for (String palo : palos) {
                for (String color : colores) {
                    for (String valor : valores) {
                        cards.add(new Card(palo, color, valor));
                    }
                }
            }
        }

        // Mezcla de deck
        public void shuffle() {
            Collections.shuffle(cards);
            System.out.println("Se ha mezclado tu Deck.");
        }

        // Muestra y remueve la primera carta del deck
        public void head() {
            if (!cards.isEmpty()) {
                Card card = cards.remove(0);
                System.out.println(card);
                System.out.println("Le Quedan " + cards.size() + " cartas en su deck");
            } else {
                System.out.println("Su deck está vacío.");
            }
        }

        // Escoge una carta al azar y la remueve
        public void pick() {
            if (!cards.isEmpty()) {
                int randomIndex = (int) (Math.random() * cards.size());
                Card card = cards.remove(randomIndex);
                System.out.println(card);
                System.out.println("Le Quedan " + cards.size() + " cartas en su deck");
            } else {
                System.out.println("Su deck está vacío.");
            }
        }

        // zona de la mano y condiciones
        public void hand() {
            if (cards.size() >= 5) {
                for (int i = 0; i < 5; i++) {
                    Card card = cards.remove(0);
                    System.out.println(card);
                }
                System.out.println("Quedan " + cards.size() + " cartas en el deck");
            } else {
                System.out.println("No hay suficientes cartas en el deck para repartir una mano.");
            }
        }
    }
}
