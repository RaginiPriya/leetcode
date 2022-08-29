class Solution {

class Friend {
    int fid;
    int flevel;
    Friend(int fid, int flevel) {
        this.fid = fid;
        this.flevel = flevel;
    }
}

public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, 
                                           int[][] friends, int id, int level) {
    Map<String, Integer> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    visited.add(id);
    
    Queue<Friend> queue = new LinkedList<>();
    queue.offer(new Friend(id, level));
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Friend curr = queue.poll();
            int fid = curr.fid;
            int flevel = curr.flevel;
            if (flevel == 0) {
                for (String video : watchedVideos.get(fid))
                    map.put(video, map.getOrDefault(video, 0) + 1);
                continue;
            }
            for (int friend : friends[fid]) {
                if (!visited.contains(friend)) {
                    visited.add(friend);
                    queue.offer(new Friend(friend, flevel - 1));
                }
            }
        }
    }
    
    Map<Integer, Set<String>> treemap = new TreeMap<>();
    for (String key : map.keySet()) {
        int val = map.get(key);
        treemap.putIfAbsent(val, new TreeSet<>());
        treemap.get(val).add(key);
    }
    
    List<String> ans = new ArrayList<>();
    for (int key : treemap.keySet()) {
        ans.addAll(treemap.get(key));
    }
    
    return ans;
}
}