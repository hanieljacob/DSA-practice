class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)  return image;
        filledFlood(image,sr,sc,color,image[sr][sc]);
        return image;
    }

    private void filledFlood(int [][] image, int sr, int sc, int color, int sColor) {
        if(sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0 || image[sr][sc] != sColor)
            return;
        image[sr][sc] = color;
        filledFlood(image, sr+1, sc, color, sColor);
        filledFlood(image, sr, sc+1, color, sColor);
        filledFlood(image, sr-1, sc, color, sColor);
        filledFlood(image, sr, sc-1, color, sColor);
    }
}