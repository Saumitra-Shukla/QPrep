# Implement your solution by completing the below function
class Stack:
    def __init(self):
        self.a=[]
    def push(self,s):
        self.a.append(s)
    def pop(self):
        return self.a.pop()


def isValid(s):
    res = 1
    open=0
    close=0
    stack=Stack()
    for bracket in s:
        if bracket == '{' or bracket == '[' or bracket == '(':
            stack.push(bracket)
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
    return res

if __name__ == '__main__':
    s = input()
    result = isValid(s)
    if result == 1:
        print('true')
    else:
        print('false')
