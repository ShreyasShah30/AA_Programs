import random
statespace = [[1,1],[1,2],[1,3],[2,1],[2,2],[2,3],[3,1],[3,2],[3,3]]
xspace = [[1,1],[3,1],[1,3]]
yspace = [[2,1],[3,3],[2,2]]
xcount = 0
ycount = 0
maxcount = 8
winningspace = [[[1,1],[2,1],[3,1]],[[1,2],[2,2],[3,2]],[[1,3],[2,3],[3,3]],[[1,1],[1,2],[1,3]],[[2,1],[2,2],[2,3]],[[3,1],[3,2],[3,3]],[[1,1],[2,2],[3,3]],[[3,1],[2,2],[1,3]]]

def randomfunc(maxcount):
    index= random.randint(0,maxcount)
    return index

def randomprobfunc(winningmatrix):
    winy = winningmatrix
    # find places in winy which are empty
    temp = []
    for i in range(0,len(winy)):
        for j in range(0,3):
            if yspace[j]!=winy[i][j]:
                temp.append(winy[i][j])
                



    



def moves(index):
    

    if xcount>ycount:
        if xcount>=2 or ycount>=2:
            probab()
        popped_y = statespace.pop(index)
        yspace.append(popped_y)
        ycount+=1
        print(yspace)
        print(statespace)
    else:
        if xcount>=2 or ycount>=2:
            probab()
        popped_x = statespace.pop(index)
        xspace.append(popped_x)
        print(xspace)
        print(statespace)

    

def probab():
    k=0
    winx=[]
    for k in range(0,len(xspace)):
        for i in range(0,len(winningspace)):
                if xspace[k] in winningspace[i]:
                        temp = winningspace[i]
                        winx.append(temp)
    temp = []
    for k in range(0,len(yspace)):
        for i in range(0,len(winx)):
                if yspace[k] in winx[i]:
                        temp.append(winx[i])
    

    for i in range(0,len(temp)):
        if temp[i] in winx:
            winx.remove(temp[i])

    print(winx)

    probx = (len(winx)/len(winningspace))*100
    print(probx)

    # repeat same for y 


    k=0
    winy=[]
    for k in range(0,len(yspace)):
        for i in range(0,len(winningspace)):
                if yspace[k] in winningspace[i]:
                        temp = winningspace[i]
                        winy.append(temp)
    temp = []
    for k in range(0,len(xspace)):
        for i in range(0,len(winy)):
                if xspace[k] in winy[i]:
                        temp.append(winy[i])
    print(temp)
    

    for i in range(0,len(temp)):
        if temp[i] in winy:
            winy.remove(temp[i])

    print(winy)

    proby = (len(winy)/len(winningspace))*100
    print(proby)

    randomprobfunc(winy)

def important():
    pass
    




        
probab()


    
