from queue import Queue

def validateStackSequence(pushed, popped):

    j = 0

    stack = []

    for x in pushed:
        stack.append(x)

        while stack and j < len(popped) and stack[-1] == popped[j]:
            stack.pop()
            j = j + 1

    return j == len(popped)


# Driver code
pushed = [1, 2, 3, 4, 5]
popped = [4, 5, 3, 2, 1]
print(validateStackSequence(pushed, popped))

n = int(input("Enter n: "))
permutations = []
frontier = Queue()
frontier.put([])
while(not frontier.empty()):
    permutation = frontier.get()
    if(len(permutation) == n):
        permutations.append(permutation)
    else:
        for i in range(1,n+1):
            putVal = permutation.copy()
            flag = True
            for j in putVal :
                if (i == j):
                    flag = False

            if(flag):
                putVal.append(i)
                frontier.put(putVal)

print("All permutations: "+str(permutations))
pushed = []
for i in range(1,n+1):
    pushed.append(i)

valids = []
for permutation in permutations :
    if(validateStackSequence(pushed,permutation)):
        valids.append(permutation)

print("Valid permutations: "+str(valids))