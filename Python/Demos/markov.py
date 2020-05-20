import random

#reading the file, tweets.txt in same dir
f = open("pickuplines.txt", "r", errors='ignore')
lines = f.readlines()
#place to put words
words = {}
last_word = ""

skips = ["http","@","#"]
ends = [".","?","!"]


#doing this line-by-line
#so long documents work
for line in lines:
   for word in line.translate(str.maketrans('', '', '"$%&\'()*+,-/:;<=>[\\]^_`{|}~â€œ™¦‡ºðÿ”')).lower().strip().split():
        end_of_line = False
        
        #check for end of sentence
        for e in ends:
            if e in word:
                end_of_line = True
                word = word.replace(e,"")
        
        #skip urls, hashtags, twitter handles
        skipword = False
        for s in skips:
            if s in word:
                skipword = True
                break
        if skipword:
            continue

        #link words
        if last_word == "":
            last_word = word
            continue
        if last_word not in words:
            words[last_word] = {}
        if word not in words[last_word]:
            words[last_word][word] = 0
        words[last_word][word] += 1
        last_word = word
        
        #make end_of_line possible
        if(end_of_line):
            if last_word not in words:
                words[last_word] = {}
            if "EOL" not in words[last_word]:
                words[last_word]["EOL"] = 0
            words[last_word]["EOL"] += 1
            
user_in = ""  
while user_in != "quit":
    user_in = input("First word (blank for random): ").lower()
    if(user_in == ""):
        current_word = random.choice(list(words.keys()))
    elif(user_in not in list(words.keys())):
        print("Word not found.")
        continue
    else:
        current_word = user_in
        
        
    sentence = current_word[0].upper() + current_word[1:]
    #do n words
    while(current_word != "EOL"):
        #count up the total incidences
        sum = 0
        for k in list(words[current_word].keys()):
            sum += words[current_word][k]
        #randomly choose a number
        choice = random.randint(0,sum)
        #walk through incidences until the number is reached
        for k in list(words[current_word].keys()):
            choice -= words[current_word][k]
            if choice <= 0:
                current_word = k
                break
        if current_word == "EOL":
            sentence += random.choice(ends)
        else:
            sentence += " " + current_word
    print(sentence)
