#A simulation of the Monty Hall problem,
#run a number of times to test probability

#change string to 'switch' to always switch doors
#change to 'stay' to always stay on your first choice
stayorswitch = "stay"

#the number of trials to run (must be an integer > 0)
totaltrials = 1000



import random
cars = 0

for i in range(totaltrials):
    #3 doors
    doors = ['goat','goat','goat']
    
    #put a car in one of them
    cardoor = random.randrange(0,3)
    doors[cardoor] = 'car'
    
    #choose a door
    choice = random.randrange(0,3)
    hostchoices = [0,1,2]
    #print(doors)
    #print("player chose %s"%choice)
    
    #narrow down allowed host choices
    hostchoices.remove(choice)
    if choice != cardoor:
        hostchoices.remove(cardoor)
        
    #host opens a door
    hostdoor = random.choice(hostchoices)
    #print("host opens %s"%hostdoor)
    
    #determine which door is the unopened, unchosen one
    switchchoice = 0
    for j in range(0,2):
        if j != hostdoor and j != choice:
            switchchoice = j
    
    #now, decide!  Switch or stay?
    if(stayorswitch == "switch"):
        choice = switchchoice
        #print("switched to %s"%switchchoice)
    
    #the moment of truth
    if(doors[choice] == 'car'):
        cars += 1
        #winner!

#report results
print("Got the car %s times out of %s"%(cars,totaltrials))
print("Win rate: %s%%"%(cars/totaltrials*100))