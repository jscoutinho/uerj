nums = [3,34,4,12,5,2]
S = 9

def subsetSum(nums, S):
    n = len(nums)
    dp = [[0 for j in range(0, S+1)] for i in range(0, n+1)]
    for i in range(1, n+1):
        for j in range(1, S+1):
            if j < nums[i-1]:
                dp[i][j] = dp[i-1][j]
            elif j == nums[i-1]:
                dp[i][j] = 1
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-nums[i-1]])
                
    caminho = []
    w = S
    for x in range(n, 0, -1):   
        if dp[x][w] != dp[x-1][w]:
            caminho.append(nums[x-1])
            w -= nums[x-1]   
            
    return caminho,dp[n][S]

       


print(subsetSum(nums, S))
