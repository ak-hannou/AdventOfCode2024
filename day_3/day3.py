import re

data = []
string_input = ""
with open("input.txt", 'r') as file:
    for line in file:
        string_input += line

regex = r'mul[(][\d]{1,3},\d{1,3}[)]'
x = re.findall(regex, string_input)

new_str = "".join(x)

regex2 = r'[(][\d]{1,3},\d{1,3}[)]'
y = re.findall(regex2, new_str)

sum1 = 0
for i in y:
    a, b = i.split(',')
    a = a.strip('(')
    b = b.strip(')')
    sum1 += int(a) * int(b)
print(sum1)

sum2 = 0
regex_2 = r"(?:mul\((\d{1,3}),(\d{1,3})\))|(do\(\)|don't\(\))"
current_state = True
x = re.findall(regex_2, string_input)
for (first, second, state) in x:
    match state:
            case "do()":
                current_state = True
            case "don't()":
                current_state = False
            case _:
                if current_state:
                    sum2 += int(first) * int(second)
print(sum2)