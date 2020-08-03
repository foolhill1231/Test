import tkinter as tk

def callback_func(event):
  label["text"] = "x:{0},y:{1}".format(event.x, event.y)

root = tk.Tk()
root.geometry("300x200")
root.title("mouse motion")
label = tk.Label(root, text="mouse motion", relief="groove")

root.bind("<Motion>", callback_func)
label.pack()
root.mainloop()
