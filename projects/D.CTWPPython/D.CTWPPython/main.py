def getN():
    n = int(input("please Enter the n: "))
    return n
def getW(n):
    W = []
    for i in range(n):
        row = []
        for j in range(n):
            if(i==j):
                row.append(-1)
            else :
                element = int(input("Please Enter path-cost of roud city "+str(i+1)+"->"+str(j+1)+"(if there is no any road enter -1): "))
                row.append(element)
        W.append(row)
    return W
def getSubset(N):
    subsets = []
    for i in range(2** (N - 1)):
        subset = []
        for j in range(N):
            if i & (1 << j):
                subset.append(j+1)
        subsets.append(subset)
    return subsets

def sortByLength(subsets):
    newSubset = []
    index = 0
    while(len(newSubset) != len(subsets)):
        for subset in subsets:
            if len(subset) == index:
                newSubset.append(subset)
        index += 1
    return newSubset
def TSP(N,W):
    subsets = getSubset(N)
    subsets = sortByLength(subsets)
    D = {}
    for subset in subsets :
        if(len(subset) == 0):
            col = []
            col.append(-1)
            for i in range(1,N):
                col.append(W[i][0])
            D[tuple(subset)] = tuple(col)
        else:
            if len(subset) == (N -1):
                col = []
                DValues = []
                for j in subset:
                    copySubset = subset.copy()
                    copySubset.remove(j)
                    if W[0][j] >= 0 and list(D[tuple(copySubset)])[j] >= 0:
                        DValues.append(W[0][j] + list(D[tuple(copySubset)])[j])
                if(DValues):
                    col.append(min(DValues))
                else:
                    col.append(-1)
                for i in range(1,N):
                    col.append(-1)
                D[tuple(subset)] = tuple(col)
            else:
                col = []
                col.append(-1)
                for i in range(1,N):
                    flag = True
                    for element in subset:
                        if(element == i):
                            flag = False
                    if(flag):
                        DValues = []
                        for j in subset:
                            copySubset = subset.copy()
                            copySubset.remove(j)
                            if(copySubset == None):
                                copySubset = []
                            if W[i][j] >= 0 and D[tuple(copySubset)][j] >= 0:
                                DValues.append(W[i][j] + list(D[tuple(copySubset)])[j])
                        if(DValues):
                            col.append(min(DValues))
                        else:
                            col.append(-1)
                    else:
                        col.append(-1)
                D[tuple(subset)] = tuple(col)
    return D

N = getN()
W = getW(N)

N2 = 2 ** (N-1)

D = TSP(N,W)
subsets = getSubset(N)
subsets = sortByLength(subsets)
print("D: "+str(D))
print("best path cost: "+str(D[tuple(subsets[N2-1])][0]))
