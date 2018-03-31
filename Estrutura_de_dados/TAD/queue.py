# coding: utf-8
__author__ = 'Ivyna Santino'

'''
A fila é uma estrutura que respeita o política do FIFO(first in, 
first out), ou seja, o primeiro a entrar será o primeiro a sair.

Nessa implementação, a fila possui espaço para 5 valores.
'''

queue = []
capacity = 5
head = -1

def queueHead():
	if (isEmpty() == False):
		return queue[head]
		
def isEmpty():
	return (head == -1)
	
def isFull():
	return (len(queue) == capacity)

def enqueue(value):
	if (isFull() == False):
		queue.append(value)
		if (isEmpty() == True):
			global head
			head += 1
	return queue

def dequeue():
	if (isEmpty() == False):
		queue.pop(0)
		if (len(queue) == 0):
			global head
			head -= 1

	return queue
	
