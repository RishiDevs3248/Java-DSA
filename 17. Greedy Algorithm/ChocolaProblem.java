
import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {

    public static void main(String[] args) {
        Integer vc[] = {2, 1, 3, 1, 4};
        Integer hc[] = {4, 1, 2};

        int hcc = 1;
        int vcc = 1;
        int vp = 0;
        int hp = 0;

        int totalCost = 0;

        Arrays.sort(vc, Collections.reverseOrder());
        Arrays.sort(hc, Collections.reverseOrder());

        while (vp < vc.length && hp < hc.length) {
            if (vc[vp] > hc[hp]) {
                totalCost += (vc[vp] * hcc);
                hcc++;
                vp++;
            } else {
                totalCost += (hc[hp] * vcc);
                vcc++;
                hp++;
            }
        }

        while (vp < vc.length) {
            totalCost += (vc[vp] * hcc);
            hcc++;
            vp++;
        }

        while (hp < hc.length) {
            totalCost += (hc[hp] * vcc);
            vcc++;
            hp++;
        }

        System.out.println("Total minimum cost : " + totalCost);

    }
}
