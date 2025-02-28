read -p "Enter the number : " number
fact=1
while [ $number -gt 1 ]
do
fact=`expr $fact \* $number`
number=`expr $number - 1`
done
echo "Result:" $fact
