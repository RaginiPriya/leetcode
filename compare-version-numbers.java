class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");
        
        int i = 0;
        int j = 0;
        
        while(i < first.length && j < second.length){
            int ver1 = Integer.valueOf(first[i]);
            int ver2 = Integer.valueOf(second[i]);
            if(ver1 != ver2){
                return Integer.compare(ver1, ver2);
            }
            i++;
            j++;
        }
        
        while(i < first.length){
            int ver1 = Integer.valueOf(first[i]);
            if(ver1 > 0){
                return 1;
            }
            i++;
        }
        
        while(j < second.length){
            int ver1 = Integer.valueOf(second[j]);
            if(ver1 > 0){
                return -1;
            }
            j++;
        }
        
        return 0;
    }
}