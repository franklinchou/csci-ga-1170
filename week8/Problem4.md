# Problem 4

<img src="https://github.com/franklinchou/csci-ga-1170/blob/master/week8/fsm-problem5.svg" style="float: left; margin-right: 10px;" />


The diagram describes the state transitions of the pattern `aabab` sought in the text `aaababaabaababaab`. 

- When the automata is initiated, the state begins at 0.
- The first character is `a`, so the state transitions to 1. 
- The second character is `a`, so the state transitions to 2. 
- The third character is `a`, so the state transitions to 2.
- The fourth character is `b`, so the state transitions to 3.
- The fifth character is `a`, so the state transitions to 4.
- The sixth character is `b`, so the state transitions to 5. State 5 is the acceptance state so the pattern `aabab` is within the given text.
