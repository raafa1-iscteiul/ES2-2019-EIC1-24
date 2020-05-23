def dockeruser = "es2ei24"
def imagename_wordpress = "wordpress:5.4.1"
def container_wordpress = "docker_wordpress_1"

def imagename_mysql = "mysql:5.7"
def container_mysql = "docker_db_1"

node {
   echo 'Building Apache Docker Image'

stage('Git Checkout') {
    git 'https://github.com/raafa1-iscteiul/ES2-2019-EIC1-24.git'
    }
    
stage('Build Docker Wordpress Image'){
     powershell "docker build -t  ${imagename_wordpress} ."
    }

stage('Build Docker MySQL Image'){
     powershell "docker build -t  ${imagename_mysql} ."
    }

stage('Stop Existing Wordpress Container'){
     powershell "docker stop ${container_wordpress}"
    }

stage('Stop Existing MySQL Container'){
    powershell "docker stop ${container_mysql}"
    }   
    
stage('Remove Existing Wordpress Container'){
     powershell "docker rm ${container_wordpress}"
    }

stage('Remove Existing Wordpress MySQL'){
     powershell "docker rm ${container_mysql}"
    }
    
stage ('Runing Wordpress Container to test built Docker Image'){
    powershell "docker run -dit --name ${container_wordpress} -p 80:80 ${imagename_wordpress}"
    }

stage ('Runing MySQL Container to test built Docker Image'){
    powershell "docker run -dit --name ${container_mysql} -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=wordpress -e MYSQL_USER=wordpress -e MYSQL_PASSWORD=wordpress ${imagename_mysql}"
    }
          
    
stage('Tag Wordpress Docker Image'){
    powershell "docker tag ${imagename_wordpress} ${env.dockeruser}/${imagename_wordpress}"
    }

stage('Tag MySQL Docker Image'){
    powershell "docker tag ${container_mysql} ${env.dockeruser}/${imagename_mysql}"
    }

stage('Docker Login and Push Image'){
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'dockerpasswd', usernameVariable: 'dockeruser')]) {
    powershell "docker login -u ${dockeruser} -p ${dockerpasswd}"
    }
    powershell "docker push ${dockeruser}/${imagename_wordpress}"
    powershell "docker push ${dockeruser}/${imagename_mysql}"

    }



}
