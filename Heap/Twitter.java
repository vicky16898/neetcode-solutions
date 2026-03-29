package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {
    Map<Integer, Set<Integer>> followers;
    Map<Integer, List<Tweet>> tweetMap;
    int time;

    public Twitter() {
        followers = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        List<Tweet> tweets = tweetMap.get(userId);
        time++;
        tweets.add(new Tweet(userId, tweetId, time));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> following = followers.get(userId);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.tweet.time - a.tweet.time);
        if (following != null) {
            for (int followeeId : following) {
                List<Tweet> tweets = tweetMap.get(followeeId);
                pq.add(new Node(followeeId, tweets.get(tweets.size() - 1), tweets.size() - 2));
            }
        }
        if (tweetMap.get(userId) != null) {
            List<Tweet> tweets = tweetMap.get(userId);
            pq.add(new Node(userId, tweets.get(tweets.size() - 1), tweets.size() - 2));
        }

        while (pq.size() > 0 && res.size() < 10) {
            Node n = pq.remove();
            res.add(n.tweet.tweetId);
            List<Tweet> tweets = tweetMap.get(n.userId);
            if (tweets != null && n.lastIndex >= 0) {
                pq.offer(new Node(n.userId, tweets.get(n.lastIndex), n.lastIndex - 1));
            }
        }
        return res;

    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        Set<Integer> set = followers.get(followerId);
        set.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followers.get(followerId);
        if (set == null)
            return;
        if (set.contains(followeeId))
            set.remove(followeeId);
    }
}

class Tweet {
    int userId;
    int tweetId;
    int time;

    public Tweet(int userId, int tweetId, int time) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.time = time;
    }
}

class Node {
    int userId;
    Tweet tweet;
    int lastIndex;

    public Node(int userId, Tweet tweet, int lastIndex) {
        this.userId = userId;
        this.tweet = tweet;
        this.lastIndex = lastIndex;
    }
}
