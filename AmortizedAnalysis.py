f = open("DynamicArray.py", "r")
# print(f.read())

temp = f.readlines()
count = 0

for i in temp:
    if i == "append":
        count += 1
    print(i)
print(count)
