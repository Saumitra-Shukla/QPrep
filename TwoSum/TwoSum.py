from crio.python.io import PrintMatrix

# Implement your solution by completing the below function
def check(nums,i,j,target):
    if i==j:
        return [0,0]
    val=nums[i]+nums[j]
    if val == target:
        return [i,j]
    if val < target:
        return check(nums,i+1,j,target)
    if val > target:
        return check(nums,i,j-1,target)



def twoSum(nums, target):

    v = check(nums,0,len(nums)-1,target)
    return v

if __name__ == '__main__':
    n = int(input())
    nums = input().split()
    nums = [int(i) for i in nums]
    target = int(input())
    result = twoSum(nums, target)
    PrintMatrix.OneDMatrix(result, " ")
    
