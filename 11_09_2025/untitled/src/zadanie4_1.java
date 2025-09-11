import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class zadanie4_1 {
    public static void main(String[] args) throws FileNotFoundException {
        File plik = new File("liczby.txt");
        Scanner skaner = new Scanner(plik);
        String linia = "";
        int licznik = 0;
        int liczbaZnakow = 0;
        Boolean czyPierwsza = false;
        int pierwsza = 0;
        while (skaner.hasNextLine()) {
            linia = skaner.nextLine();
            liczbaZnakow=linia.length();

            if(linia.charAt(0)==linia.charAt(liczbaZnakow-1)){
                licznik++;
                if(!czyPierwsza){
                    czyPierwsza=true;
                    pierwsza = Integer.parseInt(linia);
                }
            }
        }
        System.out.println(licznik);
        System.out.print(pierwsza);
    }
}