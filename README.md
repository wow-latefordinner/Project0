<h1 align="center"> Project 0 </h1> <br>

<p align="center">
  Simple Command Line Interface Project
</p>


## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Testing](#testing)
- [API](#requirements)
- [Acknowledgements](#acknowledgements)


## Introduction

This is the Geico Java Boot Camp initial project.

## Features
This application allows the entry of Income and Expense items,

* Add (add) (I)ncome and (E)xpense items
* View (view) the cumulative list of entries added
* View a summary (summary) of the income, expense, and net amounts added
* Insomnia cure


## Requirements

1. Record Income and Expenses
    - Classify as income or expense
      - Condition:  I or E only valid choices
    - Provide description of income or expense
      - Condition:  Description required, as measured by not null (ignore quality of value)
    - Enter dollar amount
      - Condition:  positive number
2. View information
    - All entries
    - Summary
      - Total Income 
        - Sum of entries where classification = "I"
      - Total Expense
        - Sum of entries where classification = "E"
      - Net Income
        - Sum of entries where classification = "I" minus Sum of entries where classification = "E"'

### Local
* [Zulu Java 11 JDK][(http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)]
* [Maven](https://maven.apache.org/download.cgi)


## Quick Start
Within IntelliJ, run src.main.java.org.example.Main.java


### Run Local
Within IntelliJ, run src.main.java.org.example.Main.java


## Testing
TODO: Additional instructions for testing the application.


## API
TODO: API Reference with examples, or a link to a wiki or other documentation source.


## Acknowledgements
TODO: Show folks some love.
