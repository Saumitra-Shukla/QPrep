
# Implement your solution by completing the below function

def dfs(grid, i, j):
    if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j] != '1':
        return
    grid[i][j] = '2'
    dfs(grid, i+1, j)
    dfs(grid, i-1, j)
    dfs(grid, i, j+1)
    dfs(grid, i, j-1)



def numIslands(grid):
    if not grid:
        return 0
        
    count = 0
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == '1':
                dfs(grid, i, j)
                count += 1
    return count

if __name__ == '__main__':
    row = input().split()
    n = int(row[0])
    m = int(row[1])
    grid = []
    error=0
    for i in range(n):
        r = input()
        temp=[]
        for j in r:
            if j=='0' or j=='1':
                temp.append(j)
            else:
                print('0')
                error=1
        grid.append(temp)
    result = numIslands(grid)
    if error == 0:
        print(result)
