# Java Layers Example

## Introduction
This project is just an example for a friend from beginning to advanced using layers.

## Basic
- Person
- List
- Database in memory

### Benefits
- Requirements implemented

## Simple Layers
- Controller
- Service
- Repository

### Benefits
- Layers with specifics purposes
   - Controllers => handle basic ingress rules
   - Service => responsible for implementing business rules
   - Repository => responsible to abstract communication with data
- Dependency Inversion
- Manual dependency injection -- more control, but more work as well

## Spring Layers
- Controller
- Service
- Repository

### Benefits
- Dependency Injection
