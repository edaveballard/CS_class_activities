# -*- coding: utf-8 -*-
"""
Created on Sat Nov  2 17:14:39 2019

@author: evan.ballard
"""

my_history = []
other_history = []

name = "No Forgiveness"

def next_move():
    if 1 in other_history:
        return 1
    else:
        return 0