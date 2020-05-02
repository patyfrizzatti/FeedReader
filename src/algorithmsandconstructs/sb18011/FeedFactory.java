package algorithmsandconstructs.sb18011;

import java.io.BufferedReader;
import java.io.IOException;

import algorithmsandconstructs.FeedFactoryInterface;
import algorithmsandconstructs.FeedInterface;
import algorithmsandconstructs.FeedItem;

public class FeedFactory implements FeedFactoryInterface {

	@Override
	public FeedInterface createFeed(BufferedReader in) throws IOException {
		int countPair = 1;
		String line;
		String title = null;
		Feed f = new Feed();

		while ((line = in.readLine()) != null) {
			if (countPair % 2 > 0) {
				title = line;
			} else {
				f.getFeedItems().add(new FeedItem(title, line));
			}
			countPair++;
		}
		return f;
	}

}
