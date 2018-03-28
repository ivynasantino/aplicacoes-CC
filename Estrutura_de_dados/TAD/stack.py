# coding: utf-8

__author__ = "Ivyna Santino"

'''
Estrutura de dados do tipo LIFO(last-in, first-out), ou seja,
o último elemento a ser inserido é o primeiro a sair.

'''
# Vamos trabalhar com a pilha de 5 espaços
pilha = []
top = -1

def topo():
	saida = vazia()
	if (saida == False):
		saida = pilha[top]
		
	return saida
	
def vazia():
	saida = False
	if (len(pilha) == 0):
		saida = "Pilha vazia"
	return saida

def completa():
	saida = False
	if (len(pilha) == 5):
		saida = "Pilha completa"
	return saida

def empilha(valor):
	pilhaCheia = completa()
	saida = pilhaCheia
	if (pilhaCheia == False):
		pilha.append(valor)
		saida = pilha
	
	return saida
		
def desempilha():
	pilhaVazia = vazia()
	saida = pilhaVazia
	if (pilhaVazia == False):
		pilha.remove(pilha[-1])	
		saida = pilha
	return saida
