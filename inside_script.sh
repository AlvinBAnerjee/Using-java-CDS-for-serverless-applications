#! /bin/bash
for i in {1..1000}
do
   java Main | awk '{print $4}' >> cold_inside.txt
done