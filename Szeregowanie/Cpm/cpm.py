import networkx as nx
import plotly.figure_factory as ff
import numpy as np
import matplotlib.pyplot as plt
import pylab

#klasa do definiowania zadan
class Task:

    #te wartosci sa zmienie w funkcji set_time w klasie An_network
    start_time = 0
    late_start_time = 0
    end_time = 0
    late_end_time = 0

    def __init__(self, name, length_of_task, tasks_before, tasks_after):
        self.name = name
        self.length_of_task = int(length_of_task)

        #parsowanie pliku tekskowego z zadaniami i zmienienie wartosci start na None
        self.tasks_before = tasks_before.split(",")
        for i in range(0, len(self.tasks_before)):
            if(self.tasks_before[i] == "start"):
                self.tasks_before = None

        #parsowanie pliku tekskowego z zadaniami i zmienienie wartosci start i finish na None
        self.tasks_after = tasks_after.split(",")
        for i in range(0, len(self.tasks_after)):
            if(self.tasks_after[i] == "finish"):
                self.tasks_after = None
            
#Klasa do definiowania sieci An               
class An_network:
    #modyfikowane przez funkcje gantt_set
    gantt = list()

    #Konstruktor
    def __init__(self, file_name):
        self.tasks = read_tasks_file(file_name)
        self.set_times()
        self.draw_gantt()
        self.draw_An_network()
        
    #ustawia czasy start_time, end_time i late_start_time, late_end_time klasy task
    def set_times(self):
        #ustawia start_time i end_time
        for task in self.tasks:
            if(task.tasks_before != None):                    
                predecessors = get_predecessors(task,self.tasks)
                task.start_time = max(predecessor.end_time for predecessor in predecessors)
            task.end_time = task.start_time + task.length_of_task
        #ustawia late_start_time i late_end_time
        for task in reversed(self.tasks):
            if(task.tasks_after != None):
                successors = get_successors(task,self.tasks)
                task.late_end_time = min(successor.start_time for successor in successors)
                task.late_start_time = task.late_end_time + task.length_of_task
            else:
                task.late_end_time = task.end_time
                task.late_start_time = task.start_time
    #tworzy haramongram to wykresu gantta
    def gantt_setup(self):
        for task in self.tasks:
            if len(self.gantt) == 0:
                process = []
                process.append(task)
                self.gantt.append(process)
            else:
                for process in self.gantt:
                    ifAdd = True
                    if len(process) == 0 or process[-1].end_time <= task.start_time:
                        process.append(task)
                        ifAdd = False
                        break
                if ifAdd:
                    process = []
                    process.append(task)
                    self.gantt.append(process)

    #funkcja rysowania wykresu gantta
    def draw_gantt(self):
        self.gantt_setup()
        dataframe = []
        for number in range(0,len(self.gantt)):
            for task in self.gantt[number]:
                dataframe.append(dict(Task=str(number), Start=str(task.start_time), Finish=str(task.end_time), Description="T"+str(task.name)))

        fig = ff.create_gantt(dataframe, group_tasks = True)
        fig.update_layout(xaxis_showgrid=True)
        fig.update_yaxes(title_text='Machine')
        fig['layout']['xaxis']['tickvals'] = np.arange(0, max([task.end_time for task in self.tasks]))
        fig.layout.xaxis.rangeselector = None
        fig.layout.xaxis.type = 'linear'
        fig.show()

    #funkcja rysowania sieci An
    def draw_An_network(self):
        G = nx.DiGraph()
        for task in self.tasks:
            if task.tasks_after != None:
                for successor_num in task.tasks_after:
                    for temp_task in self.tasks:
                        if successor_num == temp_task.name:
                            G.add_edges_from([("Z"+str(task.name)+", "+str(task.length_of_task), "Z"+str(temp_task.name)+", "+str(temp_task.length_of_task))])

       
        plt.figure(figsize = (12,12))
        nx.draw_networkx(G, with_label = True, node_color='green', node_size=100)
        pylab.show()

#zwraca liste poprzednikow jako obiekty dla danego zadania
def get_predecessors(task,tasks):
    predecessors = list()
    #szukanie zadania po nazwie w lisci nazw poprzednikow i dodanie obiektu do listy
    for task_number in task.tasks_before:
        for temp_task in tasks:
            if task_number == temp_task.name:
                predecessors.append(temp_task)
                break
            
    return predecessors

#zwraca liste nastepnikow jako obiekty dla danego zadania
def get_successors(task, tasks):
    successors = list()
    #szukanie zadania po nazwie w lisci nazw nastepnikow i dodanie obiektu do listy
    for task_number in task.tasks_after:
        for temp_task in tasks:
            if task_number == temp_task.name:
                successors.append(temp_task)
                break
    
    return successors
    
        
#funkcja odczytu pliku, zwraca liste zadan
def read_tasks_file(file_name):
    file = open(file_name,'r')
    lines = file.readlines()
    tasks = list()
        
    for line in lines:
        task = line.split(";")
        task = Task(task[0],task[1],task[2],task[3])
        tasks.append(task)
    
    return tasks
            




########## Program glowny ###########
network = An_network("tasks1.txt")

