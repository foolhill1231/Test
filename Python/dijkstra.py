
import queue

G = [{}]

def setNode(n):
  global G
  G = [{} for i in range(n)]

def addEdge(s,t,w):
  global G
  G[s][t]=w

def solve(s,t):
  global G
  fixed = {}
  q = queue.PriorityQueue()
  q.put((0,s))
  while q.empty() == False:
    w,x = q.get()
    if x == t: return w
    if x in fixed: continue;
    fixed[x] = w
    for y in G[x]:
      if (y in fixed) == False:
        q.put((w + G[x][y], y))
  return None


n,m = map(int,input().split())

setNode(n)

for i in range(m):
  s,t,w = map(int,input().split())
  G[s][t] = w
  G[t][s] = w
src, dst = map(int,input().split())

print(solve(src,dst))
