package algorithmsandconstructs.sb18011;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import algorithmsandconstructs.FeedInterface;
import algorithmsandconstructs.FeedItem;

public class Feed implements FeedInterface {

	private List<FeedItem> feedItems;

	public Feed() {
		this.setFeedItems(new ArrayList<FeedItem>());
	}

	@Override
	public void addItem(FeedItem item) {
		this.getFeedItems().add(item);
	}

	@Override
	public Collection<String> listTitles() {
		return feedItems.stream().map(f -> f.getTitle()).collect(Collectors.toList());
	}

	@Override
	public FeedItem getItem(String title) {
		for (FeedItem feedItem : feedItems) {
			if (feedItem.getTitle().equals(title))
				return feedItem;
		}
		return null;
	}

	@Override
	public int numItems() {
		return feedItems.size();
	}

	@Override
	public Collection<FeedItem> findItems(String keyword) {
		return feedItems.stream().filter(f -> f.getTitle().contains(keyword) || f.getContent().contains(keyword))
				.collect(Collectors.toList());
	}

	public List<FeedItem> getFeedItems() {
		return feedItems;
	}

	private void setFeedItems(List<FeedItem> feedItems) {
		this.feedItems = feedItems;
	}

	@Override
	public String toString() {
		return "FeedItems: " + feedItems;
	}

}