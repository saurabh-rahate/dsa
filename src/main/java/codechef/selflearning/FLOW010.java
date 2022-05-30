package codechef.selflearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class FLOW010 {
    private static Map<String, String> mappings = new HashMap<>();
    static {
        mappings.put("B", "BattleShip");
        mappings.put("C", "Cruiser");
        mappings.put("D", "Destroyer");
        mappings.put("F", "Frigate");
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            System.out.println(mappings.get(br.readLine().toUpperCase()));;
        }
    }
}
