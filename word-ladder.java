class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> words = new HashSet<>(wordList);
        
        if(!words.contains(endWord)){
            return 0;
        }
        
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int length = 1;
        
        begin.add(beginWord);
        end.add(endWord);
        
        while(!begin.isEmpty() && !end.isEmpty()){
            if(begin.size() > end.size()){
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }
            Set<String> temp = new HashSet<>();
            for(String word : begin){
                char[] arr = word.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        char old = arr[i];
                        arr[i] = c;
                        String newWord = String.valueOf(arr);
                        if(end.contains(newWord)){
                            return length + 1;
                        }
                        if(!visited.contains(newWord) && words.contains(newWord)){
                            visited.add(newWord);
                            temp.add(newWord);
                        }
                        arr[i] = old;
                    }
                }
            }
            
            length++;
            begin = temp;
        }
        
        return 0;
    }
}