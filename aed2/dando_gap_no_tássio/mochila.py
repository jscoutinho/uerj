pesos = [3,4,5,6]
dano = [4,7,10,12]
nomes = ["Poção", "Escudo", "Espada", "Machado"]
capacidade = 10
n = len(pesos)


dp = [[0 for _ in range(capacidade + 1)] for _ in range(n+1)]

for i in range(1,n+1):
    for w in range(1, capacidade +1):
        if pesos[i-1] <= w:
            dp[i][w] = max(dp[i-1][w], dp[i-1][w-pesos[i-1]]+dano[i-1])
        else:
            dp[i][w] = dp[i-1][w]
            
w = capacidade
itens = []

for j in range(n,0,-1):
    if dp[j][w] != dp[j-1][w]:
        itens.append(nomes[j-1])
        w = w - pesos[j-1]

print(itens)
print(dp[n][capacidade])