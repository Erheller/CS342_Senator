JFLAGS = -g
JC = javac
JVM = java

.SUFFIXES: .java .class

.java.class:
   $(JC)$(JFLAGS) $*.java

ClASSES = \

	DistrictTypes.java \
	Behavior.java \
	Decision.java \
	DecisionPopulation.java \
	District.java \
	SenatorSim.java \

MAIN = SenatorSim

default: classes

classes: $(CLASSES:.java=.class)


run: SenatorSim
	$(JVM) $(SenatorSim)

clean:
$(RM) *.class