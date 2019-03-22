#!/bin/bash

touch check.txt
/home/ec2-user/app/travis/deploy.sh > /dev/null 2> /dev/null < /dev/null &
echo "execute-deploy 실행"