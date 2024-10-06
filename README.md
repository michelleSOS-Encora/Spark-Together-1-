 
1 MEDIAN OF TWO SORTED ARRAYS 
OVERVIEW 
For the first problem, the goal is to fiddle with the median of two sorted arrays, named ‘nums1’, ‘nums2’, of sizes m and n respectively.  The median is the middle element in a stored list of numbers: 

- If the list has an odd number of elements, the median is the single middle number 

- If the list has an even number of elements, the median is the average of two numbers 

The tricky part of the problem is that while the arrays, are individually sorted, the arrays cannot be simply merged, and sort the result, since the approach would take  

CONTEXT 
Merge and sort generally take (as for in the most efficient solution), with O(log(m+n)) time complexity, for which binary solution is the best approach rather than using a merging then a sorting method separately.  

SOLUTION 
Fortunately for us, Java has a lot of methods implemented to the arrays class, such as merging and sorting the array before finding the median. Since the wanted complexity is Olog(m+n), a binary search must be performed on the smallest array, be it nums1(otherwise it will be sent exchanged using recursion), the variables ‘p1’ y ‘p2’(as for in “partition”) are used as the point where the arrays are split into left and right halves. Being the right parts checked to see if the partition is valid (is smaller o equal to the ones in the right), if the combined length is even, the median is the average of the maximum of the left half and the minimum of the right is the maximum of the left half.  

Since the two testing arrays are already sorted, we can exploit this property by using binary search, by merging the array. By comparing values at the partition between the two arrays. 

This algorithm is useful in scenarios where the dataset is large, and a real time searching is needed or performing statistical analysis on sorted data.  

ALTERNATIVE SOLUTIONS  
As a beta solution we used in Java, which was a shorter, more resourceful code: 

import java.util.Arrays; 

class Solution { 

    public double findMedianSortedArrays(int[] nums1, int[] nums2) { 

        int[] c=new int[nums1.length+nums2.length]; 

        System.arraycopy(nums1, 0, c,0,nums1.length); 

        System.arraycopy(nums2, 0, c, nums1.length, nums2.length); 

  

        Arrays.sort(c); 

        int size=c.length; 

        boolean isO=size%2!=0; 

        if(isO){ 

            return c[size/2]; 

        }else{ 

            return(c[size/2-1]+c[size/2])/2.0; 

  

        } 

    } 

 The thing about this code, while being just as effective and generating the same output and working, the issue is the complexity of the solution, the final version implements binary search effectively, while the beta version of this solution has a O((m+n)log(m+n)), while the final version has the looked-for response and a better complexity for the solution:  O(log(m+n)) 

 

 

2 LRU 
OVERVIEW 
A data structure that’s stores key-value pairs with fixed capacity, when a new key value pair is added and the cache exceeds its capacity, it removes the least recently accessed element. The “recently” used aspect means that an element that and are accessed more recently are kept in cache, and the least accessed elements are removed when needed.  

The operations needed to be executed for the extraction of a value are get(key), which returns a value if the given key exists in the cache. If it’s found and accessed correctly, it’ll be considered as “recently used” so it should be moved to the most recent position, in the case it doesn’t exist, shall return an exception. Another operation needed is put, which needs key and value, which adds or updates a key value pair in the cache if the key already exists update the value and mark the entry as recently used. If the cache exceeds its capacity, evict the least recently used element. 

CONTEXT 
Efficiently implementing a LRU cache is a very practical tool for later, because you need to keep track of the order in which elements are accessed while ensuring fast access and updates. Maintaining the order of usage and allowing O (1) access requires a combination of data structures. 

SOLUTION 
To meet the time complexity constraint of O (1) for both operations, the optimal solution uses a HashMap and double linked lists. 

HashMap was implemented, for it is the version of dictionaries from Python in Java which allows fast lookups by key (using get and put). 

And the second data structure implemented was the doubly inked lists, that keep track of the order of usage. The most recently used node is moved to the front, and the least used node is moved to the back, like a conveyor belt thing that can go backwards and upfront. And this data structure was key for it allows for O (1) insertion and deletion from both the front and the back, with a singly linked list moving elements from the middle or end to the front would be inefficient, generating a O(n^2) complexity. 

 

ALTERNATIVE SOLUTIONS 
The team did not consider another solution for this problem other than applying doubly linked lists and HashMaps in Java, dictionaries in python, for we consider is the most efficient form to solve it.  

 

3 LONGEST SUBSTRING OVERVIEW 
OVERVIEW 
This problem ought to find the length of the longest substring without repeating characters in a particular string.  

CONTEXT 
In the past known as a Turing machine, now a common algorithm called ‘sliding window’. Using a right pointer, which expands the ‘window’ to explore the reading from left to right of a string and to make sure reach the last element in it. And, in the inverse, the left pointer will reduce the window, meaning this pointer will make sure no element is repeated in the string. 

SOLUTION 
To solve this problem efficiently, the sliding window technique uses a combination of HashMap to track the most recent indices of characters and detect repeated characters in the substring. The ideal solution is to adjust the window dynamically as the string is iterated: 
We used two pointers (one to check the left and the right boundary) to track the current window of the substring. The r pointer expands by iterating over the string and shrinking it with the left pointer ‘l’ whenever a repeated character is found. As for in the HashMap in Java and dictionaries in python, the method “set” is used to store the most recent index of each character, if by iterating a character is found more than once, within the bifurcation window, ‘l’ is adjusted to make sure the substring remains with only one symbol each their own.  

The solution iterates the string only once, making it on O(n) complexity, where n is the length of the string thanks to using the ‘sliding window’ technique.  

ALTERNATIVE SOLUTIONS 
 We did not consider any other solution for this problem, for the sliding window is the most efficient approach

 

4 REGULAR EXPRESSION  
OVERVIEW 
This problem is to implement a regular expression matching algorithm for strings, where he matching is done against a pattern containing especial symbols such a dot (‘.’) which symbolizes any character and asterisk (*), which symbolizes zero or more occurrences of the character in question. 

The output must be the determination of whether the entire string s matches a pattern p or not (partial matches are not allowed) 

CONTEXT 
As we were not to use regular expressions, we had to make sure that the string ‘s’ and pattern ‘p’ are both up to 20 characters long, handling the interaction between characters from the string and the pattern and the symbols given to match the expressions.  

SOLUTION 
Considering the character ‘.’ as a matching of every single character connector an ‘*’ as a kind of counter to the zero or more occurrences of a character, the team decided to give this problem an application of dynamic progradation, so we used ‘Tabla’ as our dynamic table and we initialized as ‘True’ if the first i characters of s (string) match the first p (pattern) characters of p, otherwise it would be initialized as ‘False’. 

To iterate and check the s and p occurrences, we used ‘for’ cycles, in the cycle that handles the characters, we handled ‘*’ as if in the pattern in the position previous to the current in j (nestedcycle with i ), it means zero or more of the preceding character can either be ignored(match zero occurrences) or match one or more occurrences.  

This solution has a time and space complexity of O(m*n), where m is the length of the string and n is the length of the pattern, where the space complexity lies in the use of a dynamic table kind for it will expand or contract as for the number of occurrences ad length of s and p. 

ALTERNATIVE SOLUTIONS 
The most efficient way to solve this problem is using bifurcations with for and using an auxiliar to store the matches, but the really most efficient way to solve this problem is using regular expressions, which are already implemented in Java, TypeScript and python; as for the solution, the second best option in efficiency terms is dynamic programation, which was the implemented solution 
