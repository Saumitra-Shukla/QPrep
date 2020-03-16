# Implement your solution by completing the below function
def travArr(heights):
    left=[]
    large=0
    for h in heights:
        left.append(large)
        if h>large:
            large=h
    return left




def trap(heights):
    
    heights.reverse()
    right=travArr(heights)
    right.reverse()
    
    heights.reverse()
    left=travArr(heights)

    ans=0
    for i,h in enumerate(heights):
        #print('left = ',left[i],'right = ',right[i],'min = ',min(left[i],right[i]),'h =',h,end='')
        water=min(left[i],right[i])-h
        #print('water = ',water)
        if water < 0:
            water = 0
        ans+=water
    #ans = 0

    return ans

if __name__ == '__main__':
    n = int(input())
    heights = []
    if (n != 0):
        heights = input().split()
        heights = [int(i) for i in heights]
    #print(heights)
    result = trap(heights)
    print(result)
    
