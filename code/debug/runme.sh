!#/bin/bash

#basic usage: ./runme.sh theSketch 
#fullscreen : ./runme.sh theSketch --present

//** set directory locations */
$P5_CP=library/core.java

### compile the files
javac -cp $1:$P6_CP $1/*.class

### run the files ($2 can be set to '--present' for fullscreen mode, otherwise it should not be defined)
javac -cp ./$1:$P5_CP $1 $2 $1
