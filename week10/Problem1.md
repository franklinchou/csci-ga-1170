# Problem 1

## Nodes: Discovery & Finishing Times

```
q
	Discovery: 1
	Finish: 16
s
	Discovery: 2
	Finish: 7
v
	Discovery: 3
	Finish: 6
w
	Discovery: 4
	Finish: 5
t
	Discovery: 8
	Finish: 15
x
	Discovery: 9
	Finish: 12
z
	Discovery: 10
	Finish: 11
y
	Discovery: 13
	Finish: 14
r
	Discovery: 17
	Finish: 20
u
	Discovery: 18
	Finish: 19
```

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
