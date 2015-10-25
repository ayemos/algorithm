def p(n)
    l = [0,0]+[1]*(n-1)
    i = 2
    while i*i<=n
        while not l[i]
            i += 1
        for j in xrange(i+i, n+1, i)
            l[j] = 0
        i += 1
    return [i for i in xrange(n+1) if l[i]]

def h(n, l)
    for i in xrange(10)
        t = ""
        for j, k in enumerate(str(n))
            if j in l
                t += str(i)
            else 
                t += k
            yield int(t)

def g(m, n)
    d = {}

