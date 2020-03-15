# Implement your solution by completing the below function
def myAtoi(s):
    
    new=''
    for letter in s:
    	if (letter.isalpha()):
    		continue
    	new+=letter
    s=new
    #print(s)
    		
    sd=s.strip().strip('-')
    if len(sd) > 10 or sd == '':
        return 0
    if len(sd) == 10:
        if int(s) > 2**31:
            return 2**31
        if int(s) < (-1*(2**31)):
            return -2**31

    x = int(s)

    return x

if __name__ == '__main__':
    s = input()
    result = myAtoi(s)
    print(result)
    