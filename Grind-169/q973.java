import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points.length == 1) return points;
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] point1, int[] point2){
                double distance1 = Math.sqrt(point1[0] * point1[0] + point1[1] * point1[1]);
                double distance2 = Math.sqrt(point2[0] * point2[0] + point2[1] * point2[1]);
                if (distance1 < distance2) {
                    return -1;
                } else if (distance1 > distance2) {
                    return 1;
                } else {
                    return 0;
                }
            }
            });
        return Arrays.copyOfRange(points, 0, k);
    }
}

class Solution2{
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int []> maxHeap = new PriorityQueue<>((a,b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        int [][] result = new int[k][2];
        for(int[]point: points){
            maxHeap.offer(point);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        int i=0;
        for(int [] num: maxHeap){
            result[i] = num;
            i++;
        }
        return result;
    }
}