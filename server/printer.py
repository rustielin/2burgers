import csv
def printer(filename,dict):
	with open(filename+".csv",'rt') as f:
		reader = csv.reader(f)
		for row in reader:
			dict[row[0]]=row[1]
def string_matcher(s,t,k):
	indices=[]
	for i in range (len(t)-len(s)+1):
		errors=0
		for j in range(len(s)):
			if t[i+j]!=s[j]:
				errors+=1
				if errors>k:
					break
		if errors<=k:
			indices.append(i)
	return indices
def matcher(keys, s,dict):
	matched=[]
	for k in keys:
		if len(string_matcher(s.lower(),k.lower(),0))>0:
			matched.append((k,dict[k]))
	return matched
def main():
	dictionary={}
	printer("data",dictionary)
	print(matcher(list(dictionary.keys()),"po",dictionary))

if __name__=="__main__": main()
