class Solution {
    public boolean isMatch(String s, String p) {
        //gets n stores string lengths for itaeration
        int m=s.length();
        int n=p.length();
        //table for dp
        boolean [][]tabla=new boolean[m+1][n+1];
        tabla[0][0]=true;
        for(int j=2;j<=n;j++){
            if(p.charAt(j-1)=='*'){
                tabla[0][j]=tabla[0][j-2];
            }
        }
        //fill up the table 
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='.'){//if the character has been found in the las position checked or if the charactee equals '.'
                    tabla[i][j]=tabla[i-1][j-1];//asigns the same character from the last iteration for its an occurrence
                }else if(p.charAt(j-1)=='*'){//* being not found, no ocurrences
                    tabla[i][j]=tabla[i][j-2];
                if(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.'){
                    tabla[i][j]=tabla[i][j]||tabla[i-1][j];//* is for one or more occurrence
                }
                }
            }
        }
        return tabla[m][n];
    }
}
