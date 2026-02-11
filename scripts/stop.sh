#!/bin/bash
set -e
systemctl stop simple-java-http.service || true
systemctl disable simple-java-http.service || true