# Dockerfile
FROM openjdk:17-oracle

USER root

# Устанавливаем findutils (содержит xargs) через microdnf
RUN microdnf update && \
    microdnf install -y findutils && \
    microdnf clean all

USER 1000  # обычно Jenkins внутри контейнера запускается от uid 1000
