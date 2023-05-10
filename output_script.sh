#! /bin/bash
for i in {1..1000}
do
   docker run  -it --rm  img2  | awk '{print $4}' >> cold_outside.txt
done

