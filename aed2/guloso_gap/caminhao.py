W = 10
itens = [2, 5, 4, 7, 1, 3, 8]

def caminhao(itens, W):
    caminhoes = []
    itens.sort(reverse = True)
    #[8,7,5,4,3,2,1]
    while(len(itens)>0):
        soma = 0
        caminhao = []
        i = 0
        while(soma < W and i < len(itens)):
            if W - soma >= itens[i]:
                soma += itens[i]
                caminhao.append(itens[i])
                itens.pop(i)
            else:
                i += 1
        caminhoes.append(caminhao)
    return caminhoes

print(caminhao(itens,W))