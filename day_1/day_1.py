column1 = []
column2 = []

with open("input.txt", 'r') as file:
    for line in file:
        parts = line.split()
        column1.append(int(parts[0]))
        column2.append(int(parts[1]))

column1.sort()
column2.sort()
total_distance = 0
for i in range(len(column1)):
    total_distance += abs(column1[i] - column2[i])

print(total_distance)

counts = {}
for i in range(len(column1)):
    for j in range(len(column2)):
        if column1[i] == column2[j]:
            if column1[i] in counts:
                counts[column1[i]] += 1
            else:
                counts[column1[i]] = 1
total_similarity = 0
for key in counts:
    total_similarity += counts[key]*key
print(total_similarity)