# CI/CD Java Project 

This project demonstrates a complete CI/CD pipeline for a Java application deployed on AWS. It showcases how modern DevOps practices can automate build, test, and deployment processes while improving reliability, visibility, and scalability.

# Project Overview

The application is a lightweight Java HTTP server built with Maven. The CI/CD pipeline integrates AWS services to automatically build and deploy the application to EC2 instances.

The goal of this project is to eliminate manual deployment steps and implement a repeatable, production-style deployment workflow.

# Architecture

The pipeline uses:

GitHub – Source code repository

AWS CodePipeline – Orchestrates the CI/CD workflow

AWS CodeBuild – Builds the Maven project

AWS CodeDeploy – Deploys the application to EC2

Amazon EC2 – Hosts the running application

IAM – Secure role-based access control

# Application

The Java application:

Runs on port 8080

Exposes a root endpoint (/)

Provides a health check endpoint (/health)

Is packaged using Maven

Build artifact generation is handled via pom.xml
📁 Repository Structure

# Business Value

This setup provides:

Faster, automated deployments

Reduced risk of human error

Version-controlled releases

Clear visibility into what is deployed

A scalable foundation for additional services
# How to Run Locally
mvn clean package
java -jar target/simple-java-http-1.0.0.jar
## Then visit:
http://localhost:8080
# Why This Matters

This project reflects real-world DevOps practices used in production environments.
It demonstrates automation, infrastructure understanding, 
CI/CD integration, and secure cloud deployment principles.

# How to Run Locally
