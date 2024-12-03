data = []

with open("input.txt", 'r') as file:
    for line in file:
        parts = line.split()
        data.append([int(part) for part in parts])
safe_rows_1 = 0
safe_rows_2 = 0

safe_distance = 3

def check_safe(row):
    increasing = False
    for i in range(len(row)-1):
        if row[i] == row[i+1]:
            return False
        if i == 0:
            if row[i] < row[i+1]:
                increasing = True
        if (row[i] < row[i+1] and increasing) or (row[i] > row[i+1] and not increasing):   
            if not abs(row[i] - row[i+1]) <= safe_distance:
                return False
        else:
            return False
    return True
  
for row in data:
    if check_safe(row):
        safe_rows_1 += 1
        safe_rows_2 += 1
    else:
        for i in range(len(row)):
            if check_safe(row[:i] + row[i+1:]):
                safe_rows_2 += 1
                break
print(safe_rows_1)
print(safe_rows_2)