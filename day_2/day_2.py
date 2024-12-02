data = []

with open("input.txt", 'r') as file:
    for line in file:
        parts = line.split()
        data.append([int(part) for part in parts])
safe_rows = 0
safe_distance = 3
for row in data:
    increasing = False
    row_safe = True
    for i in range(len(row)-1):
        if row[i] == row[i+1]:
            row_safe = False
            break
        if i == 0:
            if row[i] < row[i+1]:
                increasing = True
        if (row[i] < row[i+1] and increasing) or (row[i] > row[i+1] and not increasing):   
            if not abs(row[i] - row[i+1]) <= safe_distance:
                row_safe = False
                break
        else:
            row_safe = False
            break
    if row_safe:
        safe_rows += 1
print(safe_rows)