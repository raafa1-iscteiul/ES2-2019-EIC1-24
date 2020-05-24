# Source Image name
from es2ei24/wordpress:5.4.1
from es2ei24/mysql
# Maintainer Name
maintainer ES2-2019-EIC1-24
# Command to update and install containers
RUN docker run -dit --name ${container_wordpress} -p 80:80 ${imagename_wordpress}
RUN docker run -dit --name ${container_mysql} -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=wordpress -e MYSQL_USER=wordpress -e MYSQL_PASSWORD=wordpress ${imagename_mysql}
# open port 
EXPOSE 80


