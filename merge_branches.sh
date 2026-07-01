#!/bin/bash
for b in `git branch -a | grep sync`;do git pull . $b; done;
