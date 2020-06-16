import networkx as nx
import plotly.figure_factory as ff
import numpy as np
import matplotlib.pyplot as plt
import pylab

#klasa do definiowania zadan
class Task:

    level = 0
    def __init__(self, name, successors):
        self.name = name
        self.length_of_task = 1
        self.successors = list()
        #parsowanie pliku tekskowego z zadaniami i zmienienie none na None
        for successor in successors:
            if(successor == "none"):
                self.successors = None
            else:
                self.successors.append(successor)
        self.new_successor = None

#klasa algorytmu
class Hu_algorithm:
    
    #ilosc zadan zwiekszane gdy wrzucamy zadanie do listy zadan
    n = 0
    
    #konstruktor definiujemy jaki typ wrzucilismy out-forest, in-forest, in-tree
    def __init__(self, file_name, times, machines):
        self.tasks, self.type_of_forest = self.read_from_file(file_name)
        self.times = times
        self.machines = machines

    #odczyt, parsowanie, stworzenie obiektu zadania i wrzucenie do listy zadan
    def read_from_file(self, file_name):
        file = open(file_name,'r')
        lines = file.readlines()
        type_of_forest = lines[0].split("\n")[0]
        lines.pop(0)

        tasks = list()
        for line in lines:
            task = line.split(";")
            tasks.append(Task(task[0],task[1].split(",")))
            self.n += 1
        return tasks, type_of_forest

    #funkcja przemiany oraz algorytmu
    def process_data(self):
        #jesli out-forest to ma zmienic na in-forest
        if self.type_of_forest == "outforest":
            for task in self.tasks:
                if task.successors != None:
                    for successor in task.successors:
                        for temp_task in self.tasks:
                            if successor == temp_task.name:
                                temp_task.new_successor = task.name
            for task in self.tasks:
                task.successors = task.new_successor
            
            self.type_of_forest = "inforest"
        
        #jesli in-forest to zmiana na na in-tree
        if self.type_of_forest == "inforest":
            self.set_level()
            roots = list()
            for task in self.tasks:
                if task.level == 1:
                    roots.append(task)
            if len(roots) > 1:
                for i in range(0, len(roots)-1):
                    new_task = Task(str(self.n+i+1), successors = ["none"])
                    self.tasks.append(new_task)
                    roots[i].successors = new_task.name
                    roots[i+1].successors = new_task.name
                    self.set_level()
                    
            for task in self.tasks:
                if int(task.name) > self.n:
                    self.tasks.remove(task)
            self.type_of_forest ="intree"

            
        #wykonanie algorytmu Hu dla in-tree oraz rysowanie gantta
        if self.type_of_forest == "intree":
            self.set_level()
            dataframe = []
            current_machine = 0
            t = 1
            while len(self.tasks) != 0:
                self.tasks.sort(key=lambda parameter_list: parameter_list.level)
                to_do_list = self.tasks[:self.machines]

                for task in to_do_list:
                    dataframe.append(dict(Task=str(current_machine), Start=str(t), Finish=str(task.length_of_task+t), Description="T"+str(task.name)))
                    self.tasks.remove(task)
                    current_machine = current_machine + 1
                    if current_machine == self.machines:
                        current_machine = 0
                t = t + 1
            fig = ff.create_gantt(dataframe, group_tasks = True)
            fig.update_layout(xaxis_showgrid=True)
            fig.update_yaxes(title_text='Machine')
            #fig['layout']['xaxis']['tickvals'] = np.arange(0, max([task.end_time for task in self.tasks]))
            fig.layout.xaxis.rangeselector = None
            fig.layout.xaxis.type = 'linear'
            fig.show()



             

    #ustawienie poziomu zadania
    def set_level(self):
        for task in self.tasks:
            self.levels_to_root(task)
                
    #obliczenie poziomu zadania
    def levels_to_root(self, task):
        task.level = 1
        if task.successors != None:
            for temp_task in self.tasks:
                if task.successors == temp_task.name:
                    task.level = task.level + self.levels_to_root(temp_task)

        return task.level

            
        
        
####### program glowny ########
hu1 = Hu_algorithm("tasks_outforest.txt",1,3)
hu1.process_data()



    

