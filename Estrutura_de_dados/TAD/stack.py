# coding: utf-8
__author__ = "Ivyna Santino"

'''
Estrutura de dados do tipo LIFO(last-in, first-out), ou seja,
o último elemento a ser inserido é o primeiro a sair.

Nessa implementação, a pilha possui espaço para 5 valores.
'''

pilha = []
top = -1
capacity = 5

def topo():
	if (vazia() == False):
		return pilha[top]
	
def vazia():
	return (top == -1)

def completa():
	return (top == capacity - 1)

def empilha(valor):
	if (completa() == False):
		pilha.append(valor)
		global top
		top += 1
	return pilha
		
def desempilha():
	if (vazia() == False):
		pilha.remove(pilha[-1])
		global top
		top -= 1
	return pilha
