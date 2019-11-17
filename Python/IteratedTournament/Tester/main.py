"""
This tester allows you to play against your own player.
Paste ALL your code into the "PlayerTest" file 
(replace anything that is there)

Then, play against your player to see how it does!
This is a good way to find errors and improve your player
"""


#Choose the game you are playing by uncommenting the appropriate line
# (delete the # at the beginning)
#Don't forget to add the # to the matrix you are NOT using!

##Prisoner's Dilemma
PAYOFF_MATRIX = [[[2,2],[0,3]],[[3,0],[1,1]]]  

##Chicken
#PAYOFF_MATRIX = [[[0,0],[0,1]],[[1,0],[-1,-1]]]

##Bach or Stravinski  #need to look at this, asymetric
#PAYOFF_MATRIX = [[[2,3],[0,0]],[[0,0],[3,2]]]

test_player = __import__("PlayerTest")

test_player.player = 1
test_player.my_score = 0
test_player.other_score = 0

def matrix_mirror(matrix):
    newmat = []
    for i in range(len(matrix[0])):
        newrow = []
        for j in range(len(matrix)):
            newrow.append(matrix[j][i])
        newmat.append(newrow)
    return newmat

ans = ""
my_score = 0
test_score = 0

while(ans != "bye"):
    ans = input("What is your next move, 0 or 1?  ('bye' to quit) ")
    if ans == "bye":
        break
    elif ans == "0" or ans == "1":
        my_move = int(ans)
        test_move = test_player.next_move()
        
        #payoffs from this round
        my_payoff = PAYOFF_MATRIX[my_move][test_move][0]
        test_payoff = PAYOFF_MATRIX[my_move][test_move][1]
        
        #adjust overall score based on this round
        my_score += my_payoff
        test_score += test_payoff
        
        #update histories
        test_player.my_history.append(test_move)
        test_player.other_history.append(my_move)
        
        #update scores
        test_player.my_score = test_score
        test_player.other_score = my_score
        
        #print out results
        print("Your Move".ljust(15) + "Test Move".ljust(15) + "Your Payoff".ljust(15) + "Test Payoff".ljust(15))
        print(str(my_move).ljust(15) + str(test_move).ljust(15) + str(my_payoff).ljust(15) + str(test_payoff).ljust(15))
        print("Total Scores -- \tYou: "+str(my_score)+"\tTest Player: "+str(test_score)+"\n")
        
    else:
        print("invalid input: try again!")
