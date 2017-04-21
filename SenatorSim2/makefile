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
	SenatorSim2.java \

MAIN = SenatorSim2

default: classes
	javac DistrictTypes.java Behavior.java Decision.java DecisionFactory.java District.java SenatorSim2.java

classes: $(CLASSES:.java=.class)


run: SenatorSim2
	$(JVM) $(SenatorSim2)

clean:
	$(RM) *.class