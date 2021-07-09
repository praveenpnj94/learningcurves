//https://leetcode.com/problems/best-team-with-no-conflicts/

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        if(scores==null||ages==null||scores.length==0||ages.length==0){
            return 0;
        }        
        int n = scores.length;
        Player[] players = new Player[n];        
        for(int i=0;i<n;i++){
            players[i]=new Player(ages[i],scores[i]);
        }        
        Arrays.sort(players,new PlayerComparator());
        int maxScore = 0;
        int[] dp = new int[n];
        
        for(int i=0;i<n;i++){
            dp[i]=players[i].score;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(doesQualify(players[j],players[i])){
                    dp[i]=Math.max(dp[i],dp[j]+players[i].score);
                }
            }
            maxScore=Math.max(maxScore,dp[i]);
        }
        return maxScore;
    }
    
    private boolean doesQualify(Player younger, Player older) {
        boolean sameAge = younger.age == older.age;
        boolean differentAge = (younger.age < older.age) && (younger.score <= older.score);
        return sameAge || differentAge;
    }
}
class Player{
    int age;
    int score;
    
    Player(int age, int score){
        this.age = age;
        this.score = score;
    }
}

class PlayerComparator implements Comparator<Player>{
    
    public int compare(Player p1, Player p2){
                if (p1.age != p2.age) {
                    return p1.age - p2.age;
                } else {
                    return p1.score - p2.score;
                }
    }
}