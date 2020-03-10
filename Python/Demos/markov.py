import string
import random

#reading the file, input.txt in same dir
f = open("input.txt", "r")
lines = f.readlines()
#place to put words
words = {}
last_word = ""

#doing this line-by-line
#so long documents work
for line in lines:
   for word in line.translate(str.maketrans('', '', string.punctuation)).lower().strip().split():
        #line 1
        if last_word == "":
            last_word = word
            continue
        if last_word not in words:
            words[last_word] = {}
        if word not in words[last_word]:
            words[last_word][word] = 0
        words[last_word][word] += 1
        last_word = word

#print(words)

user_in = ""  
while user_in != "quit":
    user_in = input("length of chain: ")
    current_word = random.choice(list(words.keys()))
    sentence = current_word
    #do n words
    for i in range(int(user_in)):
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
                sentence += " " + current_word
                break
    print(sentence)
