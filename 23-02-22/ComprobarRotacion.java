public class ComprobarRotacion {
    public static boolean comprobar(String str1, String str2) { // str1: original; str2: rotación
        if(str1.length() != str2.length()) return false;

        str1 += str1;
        for(int i = 0; i < str2.length(); i++) {
            if (str1.substring(i, i + str2.length()).equals(str2)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(comprobar("HOLA","LAHO"));
    }
}