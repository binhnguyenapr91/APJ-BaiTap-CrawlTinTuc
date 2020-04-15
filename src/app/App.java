package app;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://dantri.com.vn/the-gioi.rss");

			Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
			scanner.useDelimiter("\\Z");
			
			String content = scanner.next();
			scanner.close();
			
			Pattern p = Pattern.compile("(<item><title>)([^<]+)");
			Matcher m = p.matcher(content);
			int count=1;
			while (m.find()) {
				System.out.println("News No "+count+": "+m.group(2));
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
