
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import algorithmsandconstructs.FeedFactoryInterface;
import algorithmsandconstructs.FeedInterface;
import algorithmsandconstructs.sb18011.FeedFactory;

public class FeedReader {

	public static void main(String[] args) throws IOException {
		FeedFactoryInterface factory = new FeedFactory();

		String file = "test.rss";
		BufferedReader in = new BufferedReader(new FileReader(file));

		FeedInterface feed = factory.createFeed(in);

		System.out.println("=== News items ===");

		for (String title : feed.listTitles()) {
			System.out.println(title);
		}
		
		//printing to see if it's working
		System.out.println(feed.getItem("BREAKING NEWS")); 
		
		System.out.println("NumItems: " + feed.numItems()); 
		
		System.out.println("keyword is 'less': " + feed.findItems("less")); 

	}
}
