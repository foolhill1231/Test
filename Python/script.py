# 平方根を求める

# x = 2
def square_root(x):
    mew = x

    diff = mew - x / mew
    if (diff < 0):
       diff = -diff
      
    while (diff > 1.0E-6):
        r1 = mew
        r2 = x / r1
        mew = (r1 + r2) / 2
        print(r1, mew, r2)
        diff = r1 - r2
        if (diff < 0):
          diff = -diff
    return mew

v = 2
r = square_root(v)
print("結果は", r)
