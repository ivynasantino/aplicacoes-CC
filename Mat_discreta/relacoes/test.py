# -*- coding: utf-8 -*-

from reflexiva import reflexiva
from simetrica import simetrica
from transitiva import transitiva
from anti_simetrica import anti_simetrica


conjunto = [1,2,3,4]

R1 = [(1, 1),(1, 2),(2, 1),(2, 2),(3, 4),(4, 1),(4, 4)]
R2 = [(1, 1),(1, 2),(2, 1)]
R3 = [(1, 1),(1, 2),(1, 4),(2, 1),(2, 2),(3, 3),(4, 1),(4, 4)]
R4 = [(2, 1),(3, 1),(3, 2),(4, 1),(4, 2),(4, 3)]
R5 = [(1, 1),(1, 2),(1, 3),(1, 4),(2, 2),(2, 3),(2, 4),(3, 3),(3, 4),(4, 4)]
R6 = [(3,4)]



# Testando a reflexividade...

assert not reflexiva(conjunto,R1)
assert not reflexiva(conjunto,R2)
assert reflexiva(conjunto,R3)
assert not reflexiva(conjunto,R4)
assert reflexiva(conjunto,R5)

# Testando a transitividade...

assert not transitiva(conjunto,R1)
assert not transitiva(conjunto,R2)
assert not transitiva(conjunto,R3)
assert transitiva(conjunto,R4)
assert transitiva(conjunto,R5)
assert transitiva(conjunto,R6)

# Testando a simetria...

assert not simetrica(conjunto,R1)
assert simetrica(conjunto,R2)
assert simetrica(conjunto,R3)
assert not simetrica(conjunto,R4)
assert not simetrica(conjunto,R5)


# Testando a anti-simetria...

assert not anti_simetrica(conjunto,R1)
assert not anti_simetrica(conjunto,R2)
assert not anti_simetrica(conjunto,R3)
assert anti_simetrica(conjunto,R4)
assert anti_simetrica(conjunto,R5)
assert anti_simetrica(conjunto,R6)