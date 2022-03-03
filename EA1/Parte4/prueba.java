public class prueba {
    public static <T> void printArr(T[] arr) {
        for (T elem : arr) System.out.println(elem);
    }

    public static void main(String[] args) {
        // Borrego Ye = new Borrego(44, "Kanye West");
        // Borrego Bunny = new Borrego(27, "Benito");
        // Borrego Edgar = new Borrego(20, "Edgar");
        // Borrego Carlos = new Borrego(20, "Carlos");
        // Borrego Cordero = new Borrego(21, "Marco");
        // Borrego[] borregos = {Ye, Bunny, Carlos, Edgar, Cordero};

        // Borrego[] borregos = {
        //     new Borrego(20, "C"), new Borrego(20, "A"),
        //     new Borrego(20, "B"), new Borrego(20, "D"),
        //     new Borrego(20, "F"), new Borrego(20, "E")
        // };

        // Integer[] borregos = {5, 8, 7, 9, 1, 3};

        // Borrego[] borregos = {
        //     new Borrego(21, "C"), new Borrego(23, "A"),
        //     new Borrego(23, "B"), new Borrego(25, "D"),
        //     new Borrego(23, "F"), new Borrego(22, "E")
        // };

        Borrego[] borregos = {
            new Borrego(21, "C"), new Borrego(21, "A"),
            new Borrego(21, "B"), new Borrego(21, "D"),
            new Borrego(21, "F"), new Borrego(21, "E")
        };

        System.out.println("Antes de sort");
        printArr(borregos);

        Heapsort.heapsort(borregos);

        System.out.println("\nDespués de sort");
        printArr(borregos);
    }
}