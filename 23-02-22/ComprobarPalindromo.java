public class ComprobarPalindromo {

    public static boolean comprobar2(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        }

        return true;
    }

    public static boolean comprobar(String str) {
        if(str.length() == 0) return true;

        for(int i = 0, j = str.length() - 1; i != j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Prueba 1: PRUEBA1 --> " + comprobar("PRUEBA1"));
        System.out.println("Prueba 2: PRUEBA2ABEURP --> " + comprobar("PRUEBA2ABEURP"));
        System.out.println("Prueba 3:  --> " + comprobar(""));
        System.out.println("Prueba 4: PRUEBA4 --> " + comprobar2("PRUEBA4"));
        System.out.println("Prueba 5: PRUEBA4ABEURP --> " + comprobar2("PRUEBA4ABEURP"));
        System.out.println("Prueba 6: 0L0 --> " + comprobar2("0L0"));
    }
}