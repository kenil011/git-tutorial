read -p "Enter the Number " n

count=1
num=2

echo "The first $n prime numbers are:"

while [ $count -le $n ]; do
	flag=1

	for((i=2;i<=num/2;i++)); do
		if [ $((num % i)) -eq 0 ]; then
			flag=0
			break
		fi
	done

	if [ $flag -eq 1 ]; then
		echo "$num"
		count=$((count+1))
	fi

	num=$((num+1))
done

