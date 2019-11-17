# -*- coding: utf-8 -*-
"""
Created on Sat Nov  2 16:56:53 2019

@author: evan.ballard
"""

my_history = []
other_history = []

name = "Tit for Tat"

def next_move():
    if len(other_history) == 0:
        return 0
    else:
        return other_history[-1]