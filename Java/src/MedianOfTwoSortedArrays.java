//SUCCESSFUL

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int[] buf = new int[nums1.length + nums2.length];
        int item1 = 0, item2 = 0;
        for(int i = 0 ; i < nums1.length + nums2.length ; i++){
            if(item1 < nums1.length && item2 < nums2.length){
                if(nums1[item1] < nums2[item2]){
                    buf[i] = nums1[item1++];
                } else if(nums1[item1] > nums2[item2]){
                    buf[i] = nums2[item2++];
                } else if(nums1[item1] == nums2[item2]){
                    buf[i++] = nums1[item1++];
                    buf[i] = nums2[item2++];
                }
            } else if(item1 == nums1.length && item2 < nums2.length){
                buf[i] = nums2[item2++];
            } else if(item2 == nums2.length && item1 < nums1.length){
                buf[i] = nums1[item1++];
            }
        }
        if(buf.length%2 ==0){
            return (double) (buf[buf.length/2] + buf[buf.length/2-1])/2;
        } else {
            return (double) buf[buf.length/2];
        }

    }
}