# Dynamic Programming (week 7)

- Rod cutting problem
- Elements of dynamic programming, i.e., what characteristics do DP problems exhibit? 
  - Optimal substructure = the optimal sol'n to the problem is composed of optimal sol'ns to sub-problems
  - Overlapping sub problems (of course in order to be memoized each new sub problem must be built on already solved subproblems, if a sub problem itself generates new sub problems there is no advantage gained from storing prior solutions) 
- Time memory tradeoff
  - Top down with memoization (save the result of re-computed subproblems and look them up in an array)
  - Bottom-up method
- Longest common subsequence
