import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

//        URL url = new URL("https://docs.oracle.com/javase/10/language");
//
//        URLConnection conn = url.openConnection();
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));

        withInference();
        testar("Marcos Daniel");
        printarSoma(10, 5, 5);
        withInferenceTwo();
    }

    //var só pode ser utilizado a nível de método, não pode ser utilizado a nível de classe e nem como parametro
    public static void withInference () throws IOException {

        var url = new URL("https://docs.oracle.com/javase/10/language");

        var conn = url.openConnection();

        var bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
    }

    //var só pode ser utilizado a nível de método, não pode ser utilizado a nível de classe e nem como parametro
    public static void withInferenceTwo () throws IOException {

        var url = new URL("https://docs.oracle.com/javase/10/language");
        var conn = url.openConnection();

        try (var bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));) {
            System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testar(String nome) {

        var nomeCompleto = new StringBuilder().append(nome)
                .append(" ").append("Budtinger");
        System.out.println(nomeCompleto);
    }

    public static void printarSoma(int... numeros) {

        var soma = 0;
        if (numeros.length > 0) {
            for (var numero: numeros) {
                soma += numero;
            }
            System.out.println("A soma é : " + soma);
        }
    }
}
