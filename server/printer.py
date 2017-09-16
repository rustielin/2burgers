import csv
dictionary={}
def printer(filename):
	with open(filename+".csv",'rt') as f:
		reader = csv.reader(f)
		for row in reader:
			dictionary[row[0]]=row[1]
printer("data")
print(dictionary)