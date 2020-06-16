import plotly.figure_factory as ff
import numpy as np

class Task:
    def __init__(self, task_number, run_time, due_date, req_start_time, successors):
        self.task_name = "Z"+str(task_number)
        self.run_time = int(run_time)
        self.req_start_time = int(req_start_time)
        self.due_date = int(due_date)
        self.successors = successors
        self.predecessors = list()
        self.finished = False


class Modified_Liu:
    def __init__(self, file_name):
        self.tasks = self.read_from_file(file_name)

    def run(self):
        self.setSuccessors()
        self.setPredecessors()
        for task in self.tasks:
           task.due_date = self.getLowestDueDate(task)
        self.draw_gantt()

    def draw_gantt(self):
        t = 0
        dataframe = list()
        while len(self.tasks) > 0:
            free_tasks = list()
            for task in self.tasks:
                #print("comparing "+str(task.req_start_time)+" to "+str(t))
                if int(task.req_start_time) <= int(t):
                    canStart = True
                    for pred in task.predecessors:
                        if pred.finished == False:
                            canStart = False
                    if canStart == True:
                        free_tasks.append(task)
            if len(free_tasks) != 0:
                task_to_do = free_tasks[0]
                for i in range(1, len(free_tasks)):
                    if free_tasks[i].due_date < free_tasks[i-1].due_date:
                        task_to_do = free_tasks[i]
                dataframe.append(dict(Task="0", Start =str(t), Finish = str(t+1), Description=task_to_do.task_name))
                task_to_do.run_time -= 1
                if task_to_do.run_time == 0:
                    task_to_do.finished = True
                    self.tasks.remove(task_to_do)
            t += 1
            
        fig = ff.create_gantt(dataframe, group_tasks = True)
        fig.update_layout(xaxis_showgrid=True)
        fig.update_yaxes(title_text='Machine')
        fig.layout.xaxis.rangeselector = None
        fig.layout.xaxis.type = 'linear'
        fig.show()

        

    def getLowestDueDate(self, task):
        if task.successors != None:
            dd = list()
            for successor in task.successors:
                dd.append(self.getLowestDueDate(successor))
            if task.due_date < min(dd):
                return task.due_date
            else:
                return min(dd)

        else:
            return task.due_date


    def setSuccessors(self):
        for task in self.tasks:
            if task.successors[0] == "NONE":
                task.successors = None
            else:
                for i in range(0, len(task.successors)):
                    for task2 in self.tasks:
                        if "Z"+task.successors[i] == task2.task_name:
                            task.successors[i] = task2
                            break
    
    def setPredecessors(self):
        for task in self.tasks:
            if task.successors != None:
                for successor in task.successors:
                    successor.predecessors.append(task)
    def print(self):
        for task in self.tasks:
            print(str(task.task_name)+" "+str(task.run_time)+" "+str(task.due_date)+" "+str(task.req_start_time))


    def read_from_file(self, file_name):
        file = open(file_name, 'r')
        lines = file.readlines()

        tasks = list()
        num_of_tasks = 0

        for line in lines:
            task = line.split(";")
            num_of_tasks += 1
            tasks.append(Task(num_of_tasks, task[0], task[1], task[2], task[3].split(",")))

        return tasks


ml = Modified_Liu("tasks.txt")
ml.print()
ml.run()

