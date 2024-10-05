class Solution(object):
    def isMatch(self, s, p):
        m, n=len(s), len(p)
#stores trueif the first characters (in i )of s is the same as the same characters of p
        tabla=[[False]*(n+1) for _ in range(m+1)]
        tabla[0][0]=True
        for i in range(2, n+1):
            if p[i-1]=='*':
                tabla[0][i]=tabla[0][i-2]
         #filling the table
        for i in range(1, m+1):
            for j in range (1,n+1):
                if p[j-1]==s[i-1] or p[j-1]=='.':
                    #matchesany character if . or if the character in p and s are the same
                    tabla[i][j]=tabla[i-1][j-1]
                elif p[j-1]=='*':
                    #in here zero or more characters can match
                    tabla[j-2]=tabla[i][j-2]
                    if p[j-2]==s[i-1] or p[j-2]=='.':
                        tabla[i][j]=tabla[i][j] or tabla[i-1][j]
        return tabla[m][n]

        
