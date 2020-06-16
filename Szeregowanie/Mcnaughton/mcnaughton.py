import random
import plotly.figure_factory as ff


m = 3

tasks = [1,2,3,1,1]

cmax = max(sum(tasks)/m,max(tasks))
print(cmax)
time = 0
curr_mach = 1

df = []

for task in range(0, len(tasks)):
    if time + tasks[task] > cmax:
        while time+tasks[task] > cmax:
            temp_time = cmax-time
            df.append(dict(Task="M"+str(curr_mach), Start = time, Finish = cmax, Resource = str(task+1)))
            time = 0
            curr_mach = curr_mach + 1
            tasks[task] -= temp_time
        if tasks[task] > 0:
            df.append(dict(Task="M"+str(curr_mach), Start = time, Finish = tasks[task], Resource = str(task+1)))
            time += tasks[task]
            tasks[task] = 0
            if time == cmax:
                time = 0
                curr_mach += 1

    else:
        df.append(dict(Task="M"+str(curr_mach), Start = time, Finish = time+tasks[task], Resource = str(task+1)))
        time += tasks[task]
        tasks[task] = 0
        if time == cmax:
           time = 0
           curr_mach += 1


colors = []
for i in range(0, len(tasks)):
    r = random.randint(0,255)
    g = random.randint(0,255)
    b = random.randint(0,255)
    colors.append('rgb('+str(r)+', '+str(g)+', '+str(b)+')')

fig = ff.create_gantt(df, colors=colors, index_col='Resource', show_colorbar=True, group_tasks=True)
fig.show()