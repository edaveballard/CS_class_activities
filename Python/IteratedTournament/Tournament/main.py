# -*- coding: utf-8 -*-
"""
Created on Fri Oct 25 07:24:13 2019

@author: evan.ballard
"""

import glob

#print(glob.glob("player*"))
players = glob.glob("player*")
scores = {}
wins = {}

NUM_GAMES = 100

#Prisoner's dilemma
#strategies: 0 cooperate, 1 betray
PAYOFF_MATRIX = [[2,0],[3,1]]  #we only care about our payoff in this
#the other player will compute their payoff in a future game
#not efficient, yeah, I know, we'll do twice as many games


print("NAME".ljust(30)  + "SCORE TOTAL".ljust(30) +  "WINS".ljust(30))

#round-robin tournament
for p1 in players:
    player1 = __import__(p1[0:-3])
    
    scores[player1.name] = 0  #we'll do 2x too many games, but this is simpler
    wins[player1.name] = 0  
    
    for p2 in players:
        if p1 == p2:  #stop hitting yourself
            continue
        
        
        player2 = __import__(p2[0:-3])
        otherscore = 0
        myscore = 0
        #now we run a bunch of successive games
        for i in range(NUM_GAMES):
            move1 = player1.next_move()
            move2 = player2.next_move()
            
            #get the score from the match
            myscore += PAYOFF_MATRIX[move1][move2]
            otherscore += PAYOFF_MATRIX[move2][move1]
        
            #update the internal histories of the players
            #this way they can make decisions based on what has been happening
            player1.my_history.append(move1)
            player1.other_history.append(move2)
            
            player2.my_history.append(move2)
            player2.other_history.append(move1)
            
        if myscore >= otherscore:
            wins[player1.name] += 1
    #print the total score of the player at the end of the tournament
    print(player1.name.ljust(30)  + str(myscore).ljust(30) +  str(wins[player1.name]).ljust(30))
        
        
