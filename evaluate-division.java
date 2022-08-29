class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, String> rootMap = new HashMap<>();
        Map<String, Double> distMap = new HashMap<>();
        int i = 0;
        
        for(List<String> equation : equations){
            String x = equation.get(0);
            String y = equation.get(1);
            String p1 = find(rootMap, distMap, x);
            String p2 = find(rootMap, distMap, y);
            
            rootMap.put(p1, p2);
            
            distMap.put(p1, distMap.get(y) * values[i] / distMap.get(x));
            i++;
        }
        
        i = 0;
        double[] res = new double[queries.size()];
        
        for(List<String> query : queries){
            String x = query.get(0);
            String y = query.get(1);
            if(!rootMap.containsKey(x) || !rootMap.containsKey(y)){
                res[i++] = -1.0;
                continue;
            }
            String p1 = find(rootMap, distMap, x);
            String p2 = find(rootMap, distMap, y);
            if(!p1.equals(p2)){
                res[i++] = -1.0;
                continue;
            }
            res[i++] = distMap.get(x) / distMap.get(y);
        }
        return res;
    }
    
    private String find(Map<String, String> rootMap, Map<String, Double> distMap, String node){
        if(!rootMap.containsKey(node)){
            rootMap.put(node, node);
            distMap.put(node, 1.0);
            return node;
        }
        String parent = rootMap.get(node);
        if(node.equals(parent)){
            return node;
        }
        String lastParent = find(rootMap, distMap, parent);
        rootMap.put(node, lastParent);
        distMap.put(node, distMap.get(node) * distMap.get(parent));
        return lastParent;
    }
}