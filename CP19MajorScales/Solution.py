def solve(lines):
    line = lines
    notes = ['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B']
    majors = []
    tones = [2, 2, 1, 2, 2, 2, 1]
    for i in notes:
        row = []
        p = notes.index(i)
        for j in tones:
            row.append(notes[p])
            p += j
            p %= len(notes)
        majors.append(row)

    results = []
    for i in majors:
        flag = True
        for j in line:
            if j not in i:
                flag = False
                break
        if flag:
            results.append(i[0])

    return ' '.join(results)
while True :
    lines = list()
    try :
        lines = input().split()
    except EOFError :
        break
    print(solve(lines))