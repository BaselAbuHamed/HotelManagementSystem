FROM ubuntu:latest
LABEL authors="basel"

ENTRYPOINT ["top", "-b"]