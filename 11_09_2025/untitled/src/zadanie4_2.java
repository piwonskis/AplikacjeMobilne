import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class zadanie4_2 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> noweCzynniki = new ArrayList<Integer>();
        List<Integer> stareCzynniki = new ArrayList<Integer>();
        File plik = new File("liczby.txt");
        Scanner skaner = new Scanner(plik);
        int linia = 0;
        int dzielnik = 2;
        while (skaner.hasNextInt()) {
            dzielnik = 2;
            linia = skaner.nextInt();
            while(linia>1)
            {
                if (linia%dzielnik==0)
                {
                    linia=linia/dzielnik;
                    noweCzynniki.add(dzielnik);
                }
                else{
                    dzielnik++;
                }
            }

            if(noweCzynniki.size()>stareCzynniki.size()){
                stareCzynniki.clear();
                stareCzynniki.addAll(noweCzynniki);

            }
            noweCzynniki.clear();
        }
        int liczba = 1;
        for(int x : stareCzynniki){
            liczba=liczba*x;
        }
        System.out.println(liczba + " " + stareCzynniki.size());

    }
}