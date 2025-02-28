echo "Program to find table of given number N"
read -p "Enter a number to find table " num
i=1
while [ $i -le 10 ]
do
echo "$num * $i = `expr $num \* $i`"
i=`expr $i + 1`
done
