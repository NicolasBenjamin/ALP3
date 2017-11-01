
# coding: utf-8

# ## Polynomaddition
# 
# Gegeben sei eine aufsteigend geordnete Tupel-Koeffizienten-Darstellung unserer Polynome, entsprechend wie in unserer Lösung beschrieben.

# In[12]:


def polynom_add(p1,p2):
  ergebnis_polynom = []
  p_zwischen = []
  
  if len(p1) == len(p2) and access_tupel(p1,0,1)>access_tupel(p2,0,1):
    p_zwischen= p2
    p2 = p1
    p1 = p_zwischen

  while len(p1)>0 or len(p2)>0:
      if len(p2) == 0 or access_tupel(p1,0,1)>access_tupel(p2,0,1):     # Fall p2 abgearbeitet oder p1 größerer Grad
          ergebnis_polynom.append(p1[0])
          p1.pop(0)
      elif len(p1) == 0 or access_tupel(p1,0,1)<access_tupel(p2,0,1):   # Fall p1 abgearbeitet oder p2 größerer Grad
          ergebnis_polynom.append(p2[0])
          p2.pop(0)
      else:                                                             # Fall p1 und p2 haben denselben Grad inne
          ergebnis_polynom.append((access_tupel(p1,0,0)+ access_tupel(p2,0,0), (access_tupel(p1,0,1))))
          p1.pop(0)
          p2.pop(0)
  return ergebnis_polynom


def access_tupel(polynom, stelle_von_tupel, position_in_tupel):    # Hilfsfunktion für den Zugriff auf die Tupelstruktur
    zwischenspeicher = polynom[stelle_von_tupel]
    zwischenspeicher2 = zwischenspeicher[position_in_tupel]
    return zwischenspeicher2


# In[14]:


print polynom_add([(2,3),(3,2),(1,0)],[(1,4),(2,2),(2,1)])
print polynom_add([(1,4),(2,2),(2,1)],[(2,3),(3,2),(1,0)])


# ## Polynommultiplikation

# In[133]:


def polynom_mult(p1,p2):
    ergebnis_polynom = []              # Initialisiere Ergebnispolynom
    iterationen = len(p1)+len(p2)    # Verwende Multiplikationsformel aus der Vorlesung
    for i in range(0, iterationen+1):
        ergebnis = berechne_koeffizienten(p1,p2,i)
        if ergebnis[0]>0:
            ergebnis_polynom.insert(0,ergebnis)
    return ergebnis_polynom


def berechne_koeffizienten(p1,p2,i_index):         # Liefert Koeffizienten im Tupelformat bereits mit Grad zurück
    ergebnistupel = 0
    for j in range(0,i_index+1):                    # Analog zum Index 0 bis i bei der Summenformel für c_i
        zwischenspeicher_tupel1 =0                  # Initialisiere bzw. setze zurück auf 1
        zwischenspeicher_tupel2 =0
        for tupel in p1:                            # Finde das richtige Tupel mit dem Grad i in p1, falls vorhanden
                if tupel[1]==j:
                    zwischenspeicher_tupel1 = tupel[0]  # Speichere Koeffizienten, falls vorhanden
        for tupel in p2:                            # Finde das richtige Tupel mit dem Grad i in p2, falls vorhanden
                if tupel[1]==(i_index-j):
                    zwischenspeicher_tupel2 = tupel[0]   # speichere den Koeffizienten, falls vorhanden
                    
        ergebnistupel = ergebnistupel + (zwischenspeicher_tupel1 * zwischenspeicher_tupel2) # Füge neu berechneten Koeffizienten zu Endergebnis hinzu
   
    return(ergebnistupel,i_index)
    
    


# In[134]:


polynom_mult([(3,2),(1,0)],[(1,0)])


# ## Polynomauswertung

# In[19]:


def polynom_auswertung(x,polynom):
    ergebnis = 0
    
    for i in range(0,len(polynom)):
        ergebnis= ergebnis + (access_tupel(polynom,i,0)*(x**access_tupel(polynom,i,1)))
    
    return ergebnis
        


# In[21]:


polynom_auswertung(5,[(3,2),(1,0)])

