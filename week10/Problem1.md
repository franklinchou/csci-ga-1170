# Problem 1

## Nodes: Discovery & Finishing Times

Node | Discovery | Finish
--- | --- | ---
s | 2 | 7 
r | 17 | 20 
y | 13 | 14 
u | 18 | 19 
z | 10 | 11 
v | 3 | 6 
t | 8 | 15 
q | 1 | 16 
x | 9 | 12 
w | 4 | 5 


## Edge classifications

Source | Destination | Class
---- | ---- | ---- 
q | s | TREE
q | w | FORWARD
s | v | TREE
v | w | TREE
w | s | BACK
q | t | TREE
t | x | TREE
x | z | TREE
z | x | BACK
t | y | TREE
r | y | CROSS
r | u | TREE
u | y | CROSS
y | q | BACK
