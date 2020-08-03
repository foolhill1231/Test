
#1-1-a
print("Hello World")

#1-1-b
print(int(input())**3)

# 1-1-c
a, b = map(int, input().split())
print(a * b, (a + b) * 2)

#1-1-d
s=int(input())
print(f"{s//3600}:{s%3600//60}:{s%60}")

#1-2-a
a, b = map(int, input().split())
if a > b:
    op = '>'
elif a < b:
    op = '<'
else:
    op ='=='
print("a %s b" % op)

#1-2-b
a,b,c=map(int,input().split())
if a < b < c:
  print("Yes")
else:
  print("No")

#1-2-c
a = list(map(int, input().split()))
a.sort()
print(a[0], a[1], a[2])

# 1-2-d
# 入力順　W,H,x,y,r
# x - r が0 より小さい、または、x + r がW より大きいならばNoと判定。
# x - r が0 以上、かつ、x + r がW 以下ならば
#y-rが0以上、かつ、y+rがh以下ならばYesと判定
w, h, x, y, r = map(int,input().split())

if x -r>=0 and y-r>=0 and x+r<=w and y+r<=h:
  print("Yes")
else:
  print("No")

#1-3-a
i=0
while i<1000:
    print("Hello World")
    i=i+1

#1-3-b
i =0
while True:
  x=input()
  if x == '0':
    break
  else:
    i +=1
    print("Case %d: %s" %  (i,x))

#1-3-c

while True:
  x,y=map(int,input().split())
  if x==0 and y==0:
    break
  else:
    if x < y:
      print(x, y)
    else:
      print(y, x)
      
#1-3-d

a, b, c = map(int, input().split())
count = 0
#range(a,b) aからbまでのリスト
for i in range(a, b + 1):
  if c % i == 0:
    count += 1
    
print (count)

#1-4-a
a, b = map(int,(input().split()))
print(a//b,a%b,f'{a/b:f}')
# print(f"{c:.5f}")           小数点以下五桁
# print(f"{a} {b} {c:.5f} {c:.6f}") 