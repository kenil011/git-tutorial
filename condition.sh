
:' username=$(whoami) 

echo "${username}"

if [[ "${username}" == "root" ]];
then
	echo "you have logged in with root user"
else
	echo "you are not root user"
fi '



<<comment
echo "Hello how are you doing?"
comment


echo "i just did a multiline comment."
