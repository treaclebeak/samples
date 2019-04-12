There's a staircase with N steps, and you can climb 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1

2, 1, 1

1, 2, 1

1, 1, 2

2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time. Generalize your function to take in X.

I usually start this kind of thing thinking of the brute force approach. In this case

for i = 1 to 2
    for j = 1 to 2
        for k = 1 to 2
            for l = 1 to 2 
                if i+j+k+l == 4 add it to the result list
            
that would give me the 2^4 permutations (repeats allowed) and I could just see which ones added to 4

1 1 1 1

1 1 1 2

1 1 2 1

1 1 2 2 

1 2 1 1

1 2 1 2

1 2 2 1

1 2 2 2

2 1 1 1

2 1 1 2

2 1 2 1

2 1 2 2

2 2 1 1

2 2 1 2

2 2 2 1

2 2 2 2

then after a while of staring at it I had the insight that what i really needed was a permutation tree


but how to codee that? 




 