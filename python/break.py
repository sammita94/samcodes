import time
import webbrowser

total_breaks = 3
break_count = 0

while(break_count < total_breaks):
    time.sleep(600)
    webbrowser.open("https://www.youtube.com/watch?v=98WtmW-lfeE")
    break_count = break_count + 1
