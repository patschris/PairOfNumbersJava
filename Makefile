JC		=	javac
JVM		=	java
MAIN    =   Pairs


.SUFFIXES: .java .class

.java.class:
	$(JC) $*.java

CLASSES = Pairs.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

count:
	wc $(MAIN).java