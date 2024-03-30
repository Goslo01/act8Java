import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMenu();
    }

    // Método para el menu de opciones
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        System.out.println("Bienvenido a Poker!");
        int option;

        do {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1 Mezclar Mazo");
            System.out.println("2 Sacar una carta");
            System.out.println("3 Carta al azar del mazo");
            System.out.println("4 Generar una mano de 5 cartas");
            System.out.println("0 Salir Del Menu");

            // Forma para escanear input de usuario
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            // Se ejecuta la opcion que se selecciono
            switch (option) {
                case 1:
                    deck.shuffle();
                    break;
                case 2:
                    deck.head();
                    break;
                case 3:
                    deck.pick();
                    break;
                case 4:
                    deck.hand();
                    break;
                case 0:
                    System.out.println("Gracias por jugar al juego de Poker!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción que sea válida!.");
            }
        } while (option != 0);
    }

    // Clase de cartas
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

    // Clase de mazo
    static class Deck {
        private List<Card> cards;

        public Deck() {
            cards = new ArrayList<>();
            initializeDeck();
        }

        // Inicialización del mazo de cartas
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

        // Metodo de mezcla
        public void shuffle() {
            Collections.shuffle(cards);
            System.out.println("Se ha mezclado tu Mazo.");
        }

        // Muestra y remueve la primera carta del mazo
        public void head() {
            if (!cards.isEmpty()) {
                Card card = cards.remove(0);
                System.out.println(card);
                System.out.println("Quedan " + cards.size() + " cartas en mazo");
            } else {
                System.out.println("Su mazo está vacío.");
            }
        }

        // Selecciona una carta al azar del mazo y la quita
        public void pick() {
            if (!cards.isEmpty()) {
                int randomIndex = (int) (Math.random() * cards.size());
                Card card = cards.remove(randomIndex);
                System.out.println(card);
                System.out.println("Quedan " + cards.size() + " cartas en mazo");
            } else {
                System.out.println("El deck está vacío!");
            }
        }

        // Forma para repartir el maazo de 5 cartas
        public void hand() {
            if (cards.size() >= 5) {
                for (int i = 0; i < 5; i++) {
                    Card card = cards.remove(0);
                    System.out.println(card);
                }
                System.out.println("Quedan " + cards.size() + " cartas en mazo");
            } else {
                System.out.println("No hay suficientes cartas en tu deck para poder repartir la mano.");
            }
        }
    }
}
