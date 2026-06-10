package datannotations;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class SecretMessage {

    public static void printGrid(String docUrl) throws Exception {
        URL url = new URL(docUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "UTF-8")
        );

        StringBuilder rawHtml = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            rawHtml.append(line).append("\n");
        }
        reader.close();

        String html = rawHtml.toString();
        List<int[]> positions = new ArrayList<>();
        List<Character> characters = new ArrayList<>();

        int maxX = 0, maxY = 0;

        Pattern rowPattern = Pattern.compile("<tr[^>]*>(.*?)</tr>", Pattern.DOTALL);
        Pattern cellPattern = Pattern.compile("<td[^>]*>(.*?)</td>", Pattern.DOTALL);
        Pattern tagPattern  = Pattern.compile("<[^>]+>");

        Matcher rowMatcher = rowPattern.matcher(html);
        boolean firstRow = true;

        while (rowMatcher.find()) {
            String rowHtml = rowMatcher.group(1);
            Matcher cellMatcher = cellPattern.matcher(rowHtml);

            List<String> cells = new ArrayList<>();
            while (cellMatcher.find()) {
                String cellText = tagPattern.matcher(cellMatcher.group(1)).replaceAll("");
                cellText = cellText.replace("&amp;", "&")
                        .replace("&lt;", "<")
                        .replace("&gt;", ">")
                        .replace("&nbsp;", " ")
                        .trim();
                cells.add(cellText);
            }

            if (cells.size() < 3) continue;

            if (firstRow) {
                firstRow = false;
                continue;
            }

            try {
                int x  = Integer.parseInt(cells.get(0));
                char ch = cells.get(1).charAt(0);
                int y  = Integer.parseInt(cells.get(2));

                positions.add(new int[]{x, y});
                characters.add(ch);

                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                // Skip
            }
        }

        char[][] grid = new char[maxY + 1][maxX + 1];
        for (char[] row : grid) Arrays.fill(row, ' ');

        for (int i = 0; i < positions.size(); i++) {
            int x = positions.get(i)[0];
            int y = positions.get(i)[1];
            grid[maxY - y][x] = characters.get(i);
        }

        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }

    public static void main(String[] args) throws Exception {
//        String docUrl = "https://docs.google.com/document/d/e/2PACX-1vTMOmshQe8YvaRXi6gEPKKlsC6UpFJSMAk4mQjLm_u1gmHdVVTaeh7nBNFBRlui0sTZ-snGwZM4DBCT/pub";
        String docUrl = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub";
        printGrid(docUrl);
    }
}