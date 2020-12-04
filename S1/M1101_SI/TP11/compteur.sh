#!/bin/bash

if [[ $1 == ?(-)+([:digit:]) ]] 2>/dev/null; then
    echo "error: Not a number"
    exit 1
else
    sum=0
    for (( i = $1; i <= $2; i++)); do
        (( sum += i ))
    done
    echo "Somme: $sum"
fi