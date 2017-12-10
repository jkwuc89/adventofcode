# Day 3 - Part 1
# input = 265149
input = 23

from math import sqrt, ceil
circle = ceil(sqrt(input)) // 2
circle_zero = pow(circle * 2 - 1, 2)
centers = [ circle_zero + x * circle for x in [1, 3, 5, 7] ]
distance = circle + min([ abs(input - x) for x in centers ])
print(distance)
