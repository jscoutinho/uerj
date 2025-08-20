peso = [3,4,5,6]
dano = [4,7,10,12]
nomes = ["Poção", "Escudo", "Espada", "Machado"]
capacidade = 10
n = len(peso)

dp = [[0 for _ in range(capacidade+1)] for _ in range(n+1)]

for i in range(1, n+1):
    for w in range(1, capacidade+1):
        if peso[i-1] <= w:
            dp[i][w] = max(dp[i-1][w], dano[i-1] + dp[i-1][w - peso[i-1]])
        else:
            dp[i][w] = dp[i-1][w]

print(dp[n][capacidade])

itens = []
w = capacidade

for j in range(n, 0, -1):
    if dp[j][w] != dp[j-1][w]:
        itens.append(nomes[j-1])
        w = w - peso[j-1]

print(itens)
