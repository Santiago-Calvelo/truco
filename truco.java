package truco;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class truco {
    public static void main(String[] args) {
        String[] palo = {"basto", "espada", "copa", "oro"};
        int[] cartas = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
        int[] mc = new int[3];
        String[] mp = new String[3];

        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            mc[i] = darNumeros(cartas, mc, random);
            mp[i] = darPalos(palo, mp, random);
        }

        System.out.println("Tu mano es:");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d %s ", mc[i], mp[i]);
        }
        System.out.println();
    }

    public static int darNumeros(int[] cartas, int[] mc, Random random) {
        int rc;
        do {
            rc = random.nextInt(cartas.length);
        } while (existeEnArray(mc, cartas[rc]));
        return cartas[rc];
    }

    public static String darPalos(String[] palo, String[] mp, Random random) {
        int rp;
        do {
            rp = random.nextInt(palo.length);
        } while (existeEnArray(mp, palo[rp]));
        return palo[rp];
    }

    public static boolean existeEnArray(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeEnArray(String[] array, String value) {
        for (String str : array) {
            if (str != null && str.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
