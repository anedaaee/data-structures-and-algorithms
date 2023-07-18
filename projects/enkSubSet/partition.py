def generate_partitions(input_set):
    partitions = []
    backtrack(partitions, [], input_set)
    return partitions

def backtrack(partitions, partition, remaining_set):
    if not remaining_set:
        partitions.append(partition[:])
        return

    element = remaining_set.pop(0)
    partition.append([element])
    backtrack(partitions, partition, remaining_set)
    partition.pop()

    for i in range(len(partition)):
        print(partition)
        subset = partition[i] + [element]
        partition[i] = subset
        backtrack(partitions, partition, remaining_set)
        partition[i] = partition[i][:-1]

    remaining_set.insert(0, element)

n = int(input("Enter n: "))
k = int(input("Enter k: ")) 
input_set = []
for i in range(0,n):
    input_set.append(i+1)

partitions = generate_partitions(input_set)

# Print all partitions
for partition in partitions:
    if len(partition) == 3: 
        print("Partition:")
        for subset in partition:
            print(subset)
        print()
