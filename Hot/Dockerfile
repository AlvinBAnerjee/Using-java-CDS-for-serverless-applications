FROM ubuntu

RUN apt update  -y

RUN apt install default-jdk -y

COPY . .

RUN java -Xshare:dump

RUN java -Xshare:on Main

RUN java -XX:DumpLoadedClassList=app-classes.txt Main

RUN java -Xshare:dump -XX:SharedClassListFile=app-classes.txt -XX:SharedArchiveFile=app-classes.jsa Main

#CMD java -XX:SharedArchiveFile=app-classes.jsa Main

