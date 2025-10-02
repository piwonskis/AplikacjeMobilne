import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int iloscKosci = 0;
        int punkty = 0;
        int rand = 0;
        Scanner sc = new Scanner(System.in);
        while (iloscKosci < 3 || iloscKosci > 10)
        {
            System.out.println("Ile kostek chcesz rzucić?(3 - 10)");
            iloscKosci = sc.nextInt();
            sc.nextLine();
        }
        punkt2(iloscKosci);
    }
    public static void punkt2(int ilosc)
    {
        int[] tab = new int[ilosc];
        int rand = 0;
        int punkty = 0;
        for (int i = 0; i < ilosc; i++)
        {
            rand = ((int)(Math.random() * 6) + 1);
            System.out.println("Kostka " + (int)(i+1) + ": " + rand);
            tab[i] = rand;
        }

        System.out.println("Liczba uzyskanych punktów: " + liczpunkty(tab));

        Scanner sc = new Scanner(System.in);
        System.out.println("Jeszcze raz? (t/n)");
        String wybor = sc.nextLine();
        switch (wybor)
        {
            case "t":
                punkt2(ilosc);
                break;
            case "n":
                return;
        }
    }

    public static int liczpunkty(int[] tabA)
    {
        int punkty = 0;
        int ile_razy_jest = 0;
        for (int i = 1; i <=6; i++)
        {
           for (int j = 0; j < tabA.length; j++){
               if(tabA[j] == i){
                   ++ile_razy_jest;
               }
           }
           if(ile_razy_jest > 1){
               punkty = punkty + ile_razy_jest*i;
           }
           ile_razy_jest = 0;
        }
        return punkty;
    }
}