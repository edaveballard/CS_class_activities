import random

TREE_HEIGHT = 70
BRANCH_JUMP = 3
LEAVES_R = 15
speed(0)
penup()
setposition(-150,-150)
pendown()
def drawtree():
    pendown()
    pensize(10)
    color("orange")
    forward(TREE_HEIGHT)
    pensize(3)
    color("green")
    left(90)
    for i in range(12):
        circle(LEAVES_R)
        right(30)
        penup()
        forward(BRANCH_JUMP)
        pendown()
    penup()
    left(90)
    forward(TREE_HEIGHT)
    left(180)
    
    
left(90)
drawtree()



for x in range(10):
    setposition(300*random.random()-150,300*random.random()-150)
    drawtree()