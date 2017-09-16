import csv 
import math

dictionary={}
foodPrices = []
def parseFile(fileName):
	with open(fileName + ".csv", "rt") as f:
		reader = csv.reader(f)
		for row in reader:
			dictionary[row[0]] = float(row[1])
			foodPrices.append((row[0], math.ceil(float(row[1]))))
parseFile("data")
# print(foodPrices)
# print(dictionary)


#Adapted from: https://discuss.leetcode.com/topic/10556/a-conise-python-solution-based-on-ksum/2
def fourSum(num, target):
        num = sorted(foodPrices, key = lambda x: x[1])
        def ksum(num, k, target):
            i = 0
            result = set()
            if k == 2:
                j = len(num) - 1
                while i < j:
                    if num[i][1] + num[j][1] == target:
                        result.add((num[i], num[j]))
                        i += 1
                    elif num[i][1] + num[j][1] > target:
                        j -= 1
                    else:
                        i += 1
            else:
                while i < len(num) - k + 1:
                    newtarget = target - num[i][1]
                    subresult = ksum(num[i+1:], k - 1, newtarget)
                    if subresult:
                        result = result | set( (num[i],) + nr for nr in subresult)
                    i += 1
                
            return result
        
        return [list(t) for t in ksum(num, 4, target)]

# array = [1,2,3,4,5,6,7,8]
result = fourSum(foodPrices, 10)
for elem in result:
	print(elem)
# print(result)