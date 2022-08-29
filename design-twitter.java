class Twitter {
    
    int time = 0;
    
    Map<Integer, User> userMap;
    
    private class Tweet {
        int id;
        int timestamp;
        Tweet next;
        
        Tweet(int id){
            this.id = id;
            this.timestamp = time++;
        }
    }
    
    private class User {
        int id;
        Set<Integer> follows;
        Tweet head;
        
        User(int id){
            this.id = id;
            follows = new HashSet<>();
            follow(id);
        }
        
        void follow(int id){
            follows.add(id);
        }
        
        void unfollow(int id){
            follows.remove(id);
        }
        
        void post(int id){
            Tweet tweet = new Tweet(id);
            tweet.next = head;
            head = tweet;
        }
    }

    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(userMap.get(userId) == null){
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        List<Integer> feed = new ArrayList<>();
        
        PriorityQueue<Tweet> queue = new PriorityQueue<>((t1, t2) -> t2.timestamp - t1.timestamp);
        
        if(userMap.get(userId) == null){
            return feed;
        }
        
        Set<Integer> follows = userMap.get(userId).follows;
        
        for(int user : follows){
            Tweet tweet = userMap.get(user).head;
            if(tweet != null){
                queue.add(tweet);
            }
        }
        
        int count = 0;
        
        while(!queue.isEmpty() && count < 10){
            Tweet tweet = queue.poll();
            feed.add(tweet.id);
            count++;
            if(tweet.next != null){
                queue.add(tweet.next);
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(userMap.get(followerId) == null){
            userMap.put(followerId, new User(followerId));
        }
        if(userMap.get(followeeId) == null){
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */