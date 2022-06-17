FROM java:8-alpine
LABEL maintainer="lance shan"
WORKDIR /app/note
VOLUME /app/note

ADD ./target/note-latest.jar /app/note-core/
EXPOSE 8888
CMD java -jar note-latest.jar -Duser.timezone="Asia/Shanghai"
