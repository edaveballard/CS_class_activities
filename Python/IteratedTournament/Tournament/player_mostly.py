import random

my_history = []
other_history = []

name = "Mr. Ballar's Mostly Trustworthy Algorithm"

def next_move():
    if len(other_history) == 0:
        return 0
    else:
        if(random.randint(1,10) == 10):
            return 1
        else:
            return other_history[-1]