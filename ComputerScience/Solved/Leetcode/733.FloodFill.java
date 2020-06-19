//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/
//https://leetcode.com/problems/flood-fill/
//https://www.youtube.com/watch?v=TClRuEZ-uDg

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColour = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        if(oldColour!=newColor){
            floodFillUtil(image,sr,sc,oldColour,newColor,m,n);            
        }
        return image;
    }
    public void floodFillUtil(int[][] image, int sr, int sc,int oldColour, int newColor,int m,int n){
        if(sr<0||sr>=m||sc>=n||sc<0){
            return;
        }
        if(image[sr][sc]!=oldColour){
            return;
        }
        image[sr][sc] = newColor;
        floodFillUtil(image,sr+1,sc,oldColour,newColor,m,n);
        floodFillUtil(image,sr-1,sc,oldColour,newColor,m,n);
        floodFillUtil(image,sr,sc+1,oldColour,newColor,m,n);
        floodFillUtil(image,sr,sc-1,oldColour,newColor,m,n);
    }
}