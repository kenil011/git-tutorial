read -p "Enter a number: "

echo "The first $n fibonacci numbers are: "

num1=0
num2=1
count=0

while [ $count -lt $n ]; do
	echo "$num1"

	temp=$((num1+num2))
	num1=$num2
	num2=$temp

	count=$((count+1))
done
