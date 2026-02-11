#!/bin/bash
set -e

cat > /etc/systemd/system/simple-java-http.service << 'EOF'
[Unit]
Description=Simple Java HTTP Service
After=network.target

[Service]
Type=simple
User=simplejava
WorkingDirectory=/opt/simple-java-http
Environment=APP_PORT=8080
ExecStart=/usr/bin/java -jar /opt/simple-java-http/simple-java-http.jar
Restart=always
RestartSec=3
StandardOutput=append:/var/log/simple-java-http/app.log
StandardError=append:/var/log/simple-java-http/app.err.log

[Install]
WantedBy=multi-user.target
EOF

systemctl daemon-reload
systemctl enable simple-java-http.service
systemctl restart simple-java-http.service