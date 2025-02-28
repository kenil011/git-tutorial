echo "Program to print marksheet"
read -p "Enter marks of sub1 " m1
read -p "Enter marks of sub2 " m2
read -p "Enter marks of sub3 " m3
total=` expr $m1 + $m2 + $m3`
echo "Total marks are:" $total
percentage=` expr $total / 3`
echo "Percentage:" $percentage %
if [ $percentage -ge 60 ]
then
echo "Passed with distinction"
elif [ $percentage -ge 50 ]
then
echo "Passed with first class"
elif [ $percentage -ge 40 ]
then 
echo "passed with second class"
else
echo "Failed"
fi
