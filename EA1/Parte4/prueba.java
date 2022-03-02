package Parte4;

public class prueba {
    public static <T> void printArr(T[] arr) {
        for (T elem : arr) System.out.println(elem);
    }

    public static void main(String[] args) {
        Borrego Ye = new Borrego(44, "Kanye West");
        Borrego Bunny = new Borrego(27, "Benito");
        Borrego Edgar = new Borrego(20, "Edgar");
        Borrego Carlos = new Borrego(20, "Carlos");
        Borrego Cordero = new Borrego(21, "Marco");
        Borrego[] borregos = {Ye, Bunny, Carlos, Edgar, Cordero};

        System.out.println("Antes de sort");
        printArr(borregos);

        Heapsort.heapsort(borregos);

        System.out.println("\nDespués de sort");
        printArr(borregos);
    }
}