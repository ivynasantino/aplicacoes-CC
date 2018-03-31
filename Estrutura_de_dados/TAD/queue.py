# coding: utf-8
__author__ = 'Ivyna Santino'

'''
A fila é uma estrutura que respeita o política do FIFO(first in, 
first out), ou seja, o primeiro a entrar será o primeiro a sair.

Nessa implementação, a fila possui espaço para 5 valores.
'''

queue = [1]
tail = -1

def head():
	if (isEmpty != False):
		return queue[0]
		
def isEmpty():
	return (len(queue) == 0)
	
def isFull():
	return (len(queue) == 5)

def enqueue(value):
	if (isFull() == False):
		queue.append(value)
	return queue

def dequeue():
	if (isEmpty() == False):
		queue.remove(queue[0])

	return queue
	
