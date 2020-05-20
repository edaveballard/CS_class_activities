import random

#Words used to make random company names
COMPANY_NAME_WORDS = ("Food","Mine","Garden","Robot","Next","Tech","Sun","Electric","Forest","Road","Hat","Run","Play","Muscle","Cool","Fruit","Sea","Wire","Blue","Moon","Seven","Phone","Castle","Ship","Game","Loud","Cloud","Air","Punch","Pirate")

#Total number of companies you can invest in
NUM_STOCKS = 6
#Minimum starting stock price
MIN_START_PRICE = 50
#Maximum starting stock price
MAX_START_PRICE = 100
#Absolute minimum stock price
MIN_PRICE = 10
#Absolute maximum stock price
MAX_PRICE = 300
#Starting Money
STARTING_MONEY = 1000
#Winning Money
WINNING_MONEY = 100000

#Function to print out the day's stock prices
def print_prices(stocks):
    print("\n~~~~Today's Stock Prices~~~~\t\tShares Owned:")
    i = 1
    for s in stocks:
        print(str(i)+":   "+s+"   \t$"+str(stocks[s]["price"])+"\t\t"+str(stocks[s]["shares"]))
        i+=1
    print("\n")

#Function to print out the options users can choose
def print_menu():
    print("\nChoose an option:")
    print("1 - buy stocks")
    print("2 - sell stocks")
    print("3 - end day")
    print("4 - quit")
    #print("5 - print stock prices again")

#Change stock prices
def change_prices(stocks):
    for s in stocks:
        #randomly change stock by up to 10
        stocks[s]["price"] += random.randint(-10,10)
        #stock can't go higher than max_price
        if stocks[s]["price"] > MAX_PRICE:
            stocks[s]["price"] = MAX_PRICE
        #Stock can't go lower than min_price
        if stocks[s]["price"] < MIN_PRICE:
            stocks[s]["price"] = MIN_PRICE

#Company names and their stock prices are contained in a dictionary
stocks = {}

cash = STARTING_MONEY

#Generate the stocks
for i in range(NUM_STOCKS):
    #Make company name
    first = random.choice(COMPANY_NAME_WORDS)
    second = random.choice(COMPANY_NAME_WORDS)
    company_name = first+" "+second
    stocks[company_name] = {}
    #Set company stock price randomly
    stocks[company_name]["price"] = random.randint(MIN_START_PRICE,MAX_START_PRICE)
    #You don't own any shares yet, buster
    stocks[company_name]["shares"] = 0
    
#day number
day = 0

#Main game loop.  Runs until user quits, wins, or loses
user_input = ""
while user_input != "quit":
    day += 1
    print("\n***Day "+str(day)+"***")
    
    #Menu loop.  Keep responding to user commands
    while user_input != "quit":
        
        print_prices(stocks)
        print("You have $"+str(cash)+"\n")
        print_menu()
        
        #get user choice
        user_input = input("Choice: ")
        
        #Buy stock
        if(user_input == "1"):
            stock_num = input("Enter the stock's number (it's on the left of the name):")
            stock_name = ""
            #Make sure it's a valid stock
            try:
                if(round(float(stock_num)) <= 0):
                    print(stock_num+" is not a valid stock number")
                    continue
                stock_name = list(stocks.keys())[int(float(stock_num))-1]
            except:
                print(stock_num+" is not a valid stock number")
                continue
            #Check to see if we can afford it (also is it a valid number?)
            num_shares = input("Enter the number of shares you'd like to buy (whole numbers only!):")
            try:
                if round(float(num_shares),1) != round(float(num_shares),0) or int(num_shares) <= 0:
                    print("positive whole numbers only!")
                elif int(num_shares)*stocks[stock_name]["price"] > cash:
                    print("You cannot afford that many shares of "+ stock_name)
                else:
                    cash -= int(num_shares)*stocks[stock_name]["price"]
                    stocks[stock_name]["shares"] += int(num_shares)
                    print("Purchase successful")
                    
            except:
                print("There was a problem with one of your inputs")
                continue
            
        #Sell stock
        elif(user_input == "2"):
            stock_num = input("Enter the stock's number (it's on the left of the name):")
            stock_name = ""
            #Make sure it's a valid stock
            try:
                if(round(float(stock_num)) <= 0):
                    print(stock_num+" is not a valid stock number")
                    continue
                stock_name = list(stocks.keys())[int(float(stock_num))-1]
            except:
                print(stock_num+" is not a valid stock number")
                continue
            num_shares = input("Enter the number of shares you'd like to sell (whole numbers only!):")
            #Check to see if we can actually sell that much (also is it a valid number?)
            try:
                if round(float(num_shares),1) != round(float(num_shares),0) or int(num_shares) <= 0:
                    print("positive whole numbers only!")
                elif stocks[stock_name]["shares"] < int(num_shares):
                    print("You do not have that many shares of "+ stock_name)
                else:
                    cash += int(num_shares)*stocks[stock_name]["price"]
                    stocks[stock_name]["shares"] -= int(num_shares)
                    print("Sale successful")
                    
                    #check for win condition
                    if(cash >= WINNING_MONEY):
                        print("Congratulations, by making "+str(WINNING_MONEY)+", you win the game!")
                        print("You won the game in "+str(day)+" days.")
                        user_input = "quit"
                    
            except:
                print("There was a problem with one of your inputs")
                continue
            
        #Go to next day
        elif(user_input == "3"):
            print("A day passes and the stocks prices change...")
            break
        
        #Quit game
        elif(user_input == "4"):
            print("Thank you for playing")
            user_input = "quit"
            
        #cheat code
        elif(user_input == "poweroverwhelming"):
            cash = WINNING_MONEY - 1
            
        #Unrecognized input
        else:
            #invalid choice!  stop it!
            print("invalid input, please try again")
    change_prices(stocks)