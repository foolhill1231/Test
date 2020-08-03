import tkinter as tk

def action_btn_press():
  print("pushed button")


root = tk.Tk()
root.title("widget made")
root.geometry("450x350+350+250")
lb = tk.Label(text="label")
bt = tk.Button(text="button")
bt = tk.Button(text="button", command=action_btn_press)

lb.pack()
bt.pack()
root.mainloop()
