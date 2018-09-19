import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */

public class WebScraper {
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main (String[] unused) {
        int count = 0;
        String a = "Waves";
        String s = urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt");
        StringTokenizer tok = new StringTokenizer(s," ");
        for (int i = 0; i < tok.countTokens(); i++) {
            if (tok.nextToken().equals(a))
                count++;
        }
        System.out.println(s);
        System.out.println("Number of Waves = " + count);
        System.out.println(tok.countTokens());


    }
}
