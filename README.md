# A6 Card Sorting
CSC 210: Data Structures

## General Information

Your readme should include the following information.

Your name: Abigail Lei

Other collaborators: 

Was anyone particularly helpful? Give them a shout-out here:

## References

References used (besides JavaDoc and course materials):
https://www.geeksforgeeks.org/java/listiterator-in-java/
https://stackoverflow.com/questions/13013480/linkedlist-checkforcomodification-error-java 
https://www.w3schools.com/dsa/dsa_algo_quicksort.php 
https://www.geeksforgeeks.org/dsa/quicksort-on-singly-linked-list/ 

If you used AI at all for this assignment: How did you use it? What did this experience teach you?

## Reflection Questions

What did you notice about the differences in runtime across algorithms as you changed the number of cards you were sorting? If you had to split them into "slower" algorithms vs "faster" algorithms, which would you put in each category?

Linear:
100 - 11ms
1000 - 11ms
5000 - 11ms
10000 - 11ms

Insertion:
1000 - 16ms
5000 - 76ms
10000 - 361ms
100000 - 41104ms

Selection:
100 - 9ms
1000 - 21ms
5000 - 89ms
10000 - 332ms

Quick: 
100 - 8.7ms
1000 - 9.8ms
5000 - 20ms
10000 - 51ms
100000 - 1790ms

The time for linear search did not change, which implies that it is O(1), however I know that it should be O(n). I am surprised to see quick sort so much better than insertion and selection, which I know its name is quick but wow.

After implementing these algorithms with linked-list-style operations, which methods would have benefited most from using `ArrayList` instead of `LinkedList`, and why? Which methods do you think were a better fit for linked lists?

I think that linear search would be the same regardless of it is ArrayList of Linkedlist. I think that selection sort would have likely benefitted from ArrayList because you have to access various indicies but I think it is fine as Linkedlist as well. I think that Quick sort would have largely benefitted as well.

Why didn't we implement binary search for this assignment?
We need an already sorted array, or you need to access the middle point many times which would be pretty difficult with a linked list as you'd have to traverse it many times.

## Reflection

What was your overall experience with this assignment? What was most challenging? What was most interesting?

It was really fun seeing the visualizations and all of the steps! Even if it was confusing to start the set up, it ended up being helpful in the end. I thought it was challenging to code the Quick sort because of its recursive nature and also because the sorting algorithm was pretty hard to understand itself.
