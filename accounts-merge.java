class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Set<String>> parentToChildren = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        
        for(List<String> account : accounts){
            for(int i = 1; i < account.size(); i++){
                parentMap.put(account.get(i), account.get(i));
                owner.put(account.get(i), account.get(0));
            }
        }
        
        for(List<String> account : accounts){
            String parent = find(parentMap, account.get(1));
            for(int i = 2; i < account.size(); i++){
                parentMap.put(find(parentMap, account.get(i)), parent);
            }
        }
        
        for(List<String> account : accounts){
            String parent = find(parentMap, account.get(1));
            Set<String> set = parentToChildren.get(parent);
            if(set == null){
                set = new TreeSet<>();
                parentToChildren.put(parent, set);
            }
            for(int i = 1; i < account.size(); i++){
                set.add(account.get(i));
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for(Map.Entry<String, Set<String>> entry : parentToChildren.entrySet()){
            List<String> emails = new ArrayList<>(entry.getValue());
            emails.add(0, owner.get(entry.getKey()));
            res.add(emails);
        }
        
        return res;
        
    }
    
    private String find(Map<String, String> parents, String account){
        String parent = parents.get(account);
        if(parent.equals(account)){
            return parent;
        }
        return find(parents, parent);
    }
}