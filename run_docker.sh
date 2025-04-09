#!/bin/bash

docker rm -f nullable 2>/dev/null || true

docker run --name nullable -d nullability:latest

docker exec -it nullable bash
