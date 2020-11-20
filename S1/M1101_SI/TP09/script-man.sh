#!/bin/bash

for f in $1 $2 $3
do
    man $f | head -n 8 >> $4
done