FROM ubuntu:22.04
RUN apt update && \
    apt install -y openjdk-17-jdk && \
    rm -rf /var/lib/apt/lists/*
LABEL maintainer="ASv"
LABEL contact="8888888"

COPY ./toyShop/ /toyShop/  

WORKDIR /toyShop/
RUN javac -encoding UTF-8 Program.java
ENTRYPOINT ["java","Program"]
