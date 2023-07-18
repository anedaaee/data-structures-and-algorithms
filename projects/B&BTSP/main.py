class PriorityQueue :
    def __init__(self):
        self.queue = []
    def isEmpty(self):
        return len(self.queue) == 0
    def add(self,node):
        self.queue.append(node)
    def get(self):
        maxNode = None
        max = 1000000000
        for node in self.queue:
            if node.path_cost < max:
                max = node.path_cost
                maxNode = node
        self.queue.remove(maxNode)
        return maxNode

class Node:
    def __init__(self,W,path_cost):
        self.path_cost = path_cost
        self.W = W
        self.childs = []
        self.path = []

    def setCity(self , citys):
        self.path = citys
    def addToCity(self, city):
        self.path.append(city)
    def getChild(self ):
        element = self.path.pop()
        self.path.append(element)
        for i in range(0, len(self.W[element])):
            number = self.W[element][i]
            if number != -1:
                self.childs.append(i)
class TSP:
    def __init__(self):
        self.frontier = PriorityQueue()
        self.setW()

        node = Node(self.W,0)
        node.addToCity(0)
        node.getChild()
        self.frontier.add(node)

    def setW(self):
        self.numberOfCity = int(input("Enter number of city: "))
        self.W = []
        for i in range(0,self.numberOfCity):
            row = []
            for j in range(0, self.numberOfCity):
                if(i==j):
                    row.append(-1)
                else :
                    row.append(int(input("Enter pathCost of city "+str(i+1)+"->"+str(j+1)+":(Enter -1 if there is no road) ")))
            self.W.append(row)

    def search(self):
        while(not self.frontier.isEmpty()):
            node = self.frontier.get()
            self.expand(node)

            if self.checkSol(node):
                print("solution fide")
                print(node.path)
                return

        print("solution didnt find")

    def checkSol(self,node):
        element = node.path.pop()
        node.path.append(element)
        if(element == 0 and len(node.path) == self.numberOfCity + 1):
            return True
        return False

    def expand(self,node):

        for child in node.childs:
            flag = True
            for exist in node.path:
                if(child == exist and child != 0):
                    flag = False
            if(flag):
                current = node.path.pop()
                node.path.append(current)
                newNode = Node(self.W,node.path_cost+self.W[current][child])
                newNode.setCity(node.path.copy())
                newNode.addToCity(child)
                newNode.getChild()
                if(len(newNode.childs) <= self.numberOfCity + 1):
                    self.frontier.add(newNode)



tsp = TSP()
tsp.search()