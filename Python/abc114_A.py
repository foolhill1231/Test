_INPUT = """\
7
"""


def solver(num):
    return num


def main():
    x = int(input())
    ans = "NO"
    if (x == 7 or x == 5 or x == 3):
      ans ="YES"
    
    print(ans)


if __name__ == "__main__":
    import io, sys

    sys.stdin = io.StringIO(_INPUT)

    main()