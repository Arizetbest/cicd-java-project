#!/bin/bash
set -e

if command -v yum >/dev/null 2>&1; then
  yum update -y
  yum install -y java-11-amazon-corretto-headless
elif command -v dnf >/dev/null 2>&1; then
  dnf install -y java-11-amazon-corretto-headless
fi

mkdir -p /opt/simple-java-http
mkdir -p /var/log/simple-java-http

id -u simplejava >/dev/null 2>&1 || useradd --system --no-create-home simplejava

chown -R simplejava:simplejava /opt/simple-java-http
chown -R simplejava:simplejava /var/log/simple-java-http