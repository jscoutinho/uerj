tempos = [
    [1, 4],
    [3, 5],
    [0, 6],
    [5, 7],
    [3, 9],
    [5, 9],
    [6, 10],
    [8, 11],
    [8, 12],
    [2, 14],
    [12, 16]
    ]

def atividade(tempos):
    atividades = []
    tempos.sort(key = lambda x:x[1])
    atividades.append(tempos[0])
    for i in range(1, len(tempos)):
        if tempos[i][0] > atividades[-1][1]:
            atividades.append(tempos[i])
    return atividades, len(atividades)

print(atividade(tempos))