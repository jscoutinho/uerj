def encontrar_caminhos(piramide, chave):
    solucao = []
    n = len(piramide)

    def backtrack(i, j, caminho, soma_atual):
        valor = piramide[i][j]
        novo_caminho = caminho + [valor]
        nova_soma = soma_atual + valor
        if i == n - 1:
            if nova_soma == chave:
                solucao.append(novo_caminho)
            return
        if nova_soma > chave:
            return
        backtrack(i + 1, j, novo_caminho, nova_soma)

        backtrack(i + 1, j + 1, novo_caminho, nova_soma)

    # Começamos do topo da pirâmide
    backtrack(0, 0, [], 0)

    # Imprimir resultados
    if solucao:
        print("Soluções encontradas:")
        for caminho in solucao:
            print(caminho)
    else:
        print("Nenhuma solução")

# Exemplo de uso
piramide = [[5],[2, 3],[1, 2, 4],[3, 1, 2, 1]]

chave_secreta = 11

encontrar_caminhos(piramide, chave_secreta)