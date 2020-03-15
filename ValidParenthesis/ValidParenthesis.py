# Implement your solution by completing the below function

def isValid(s):
    res = 1
    open=0
    close=0
    stack=[]
    for bracket in s:
        if bracket == '{' or bracket == '[' or bracket == '(':
            stack.append(bracket)
            open+=1
        elif bracket =='}':
            if stack.pop() != '{':
                return 0
            close+=1
        elif bracket ==']':
            if stack.pop() != '[':
                return 0
            close+=1
        elif bracket ==')':
            if stack.pop() != '(':
                return 0
            close+=1
            
    if open != close:
        res=0
    return res

if __name__ == '__main__':
    s = input()
    result = isValid(s)
    if result == 1:
        print('true')
    else:
        print('false')
