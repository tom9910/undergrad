#Thomas Sanchez
#lab2
#mergesort quick sort bubble sort
#09-16-20

import random
import time


length = input("Enter a length of a list to be sorted: ")
toBeSorted1 = [0] * int(length)
toBeSorted2 = [0] * int(length)
toBeSorted3 = [0] * int(length)

def createList():


    for f in range(0, int(length)):
        rand = random.randrange(0, 1000)
        toBeSorted1[f] = rand
        toBeSorted2[f] = rand
        toBeSorted3[f] = rand


def mergeSort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2  #find middle point

        #declare sizes of left and right subproblems
        left = [0] * mid
        right = [0] * (len(arr)-mid)

        #copy info to sub lists
        for j in range(0, mid):

            left[j] = arr[j]


        for j in range(len(arr)-mid):
            right[j] = arr[j + mid]



        mergeSort(left)     #call mergesort on left and right
        mergeSort(right)

        l = r = final = 0

        while l < len(left) and r < len(right):
            if left[l] < right[r]:      #if left is smaller add to final
                arr[final] = left[l]
                l += 1

            else:
                arr[final] = right[r]   #if right is smaller add to final
                r+= 1

            final += 1; #increment result list

        #remaining

        while l < len(left):
            arr[final] = left[l]
            final+=1
            l+=1

        while r < len(right):
            arr[final] = right[r]
            final+=1
            r+=1

#test

def setUpquick(A, low, high):
    if(low >= high):
        return
    p = quickSort(A, low, high)

    setUpquick(A, low, p-1)
    setUpquick(A, p+1, high)

def quickSort(list, low, high):  #when the pivot is low
    i = low + 1
    j = high

    pivot = list[low]
    while True:
        while(list[i] <= pivot and i <= j):
            i += 1
        while (list[j] >= pivot and i <= j):
            j -=1
        if(i <= j):
            list[i], list[j] = list[j], list[i]
        else:
            break

    list[low], list[j] = list[j], list[low]

    return j

def bubbleSort(list):
    for j in range(0, len(list) - 1):
        for i in range(0, len(list) - j - 1):
            if(list[i] > list[i+1]):
                list[i], list[i+1] = list[i+1] , list[i]





createList()

for i in toBeSorted1:
    print(i)
    print(" ")

print("\n")
start = time.time()
mergeSort(toBeSorted1)
end = time.time()
print("\n")
print("List after merge sort")
for i in toBeSorted1:
    print(i)
    print(" ")

msortTime = end - start

start = time.time()
setUpquick(toBeSorted2, 0, len(toBeSorted2) - 1)
end = time.time()

Qsorttime = end - start
print("list after quick sort")
for i in toBeSorted2:
    print(i)
    print(" ")

start = time.time()
bubbleSort(toBeSorted3)
end = time.time()

bsortTime = end - start

print("list after bubble sort")
for i in toBeSorted3:
    print(i)
    print(" ")

print("total time for merge sort = " + str(msortTime) + " ms")
print("total time for quick sort = " + str(Qsorttime) + " ms")
print("total time for bubble sort= " + str(bsortTime) + " ms")

test = [1,4, 2, 1, 5]

quickSort(test, 0, len(test) - 1)