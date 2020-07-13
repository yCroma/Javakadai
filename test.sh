#!/bin/sh

echo "# Javakadai" >> README.md
git init
git add *
git commit -m "initial commit"
git remote add origin https://github.com/yCroma/Javakadai.git
git push -u origin master
                
