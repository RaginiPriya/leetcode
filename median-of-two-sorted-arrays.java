class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int size = (nums1.length + nums2.length) / 2;
        
        int[] arr = new int[size + 1];
        int n1 = 0;
        int n2 = 0;
        
        int index = 0;
        
        while(index < arr.length && n1 < nums1.length && n2 < nums2.length){
            if(nums1[n1] < nums2[n2]){
                arr[index++] = nums1[n1++];
            }
            else {
                arr[index++] = nums2[n2++];
            }
        }
        
        while(index < arr.length && n1 < nums1.length){
            arr[index++] = nums1[n1++];
        }
        
        while(index < arr.length && n2 < nums2.length){
            arr[index++] = nums2[n2++];
        }
        
        if((nums1.length + nums2.length) % 2 == 0){
            return (double) (arr[arr.length - 1] + arr[arr.length - 2]) / (double) 2;
        }
        else{
            return (double) arr[arr.length - 1];
        }

    }
}