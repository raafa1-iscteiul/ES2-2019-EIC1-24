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
     powershell "docker-compose up -d"
    }

stage('Docker Login and Push Image'){
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'dockerpasswd', usernameVariable: 'dockeruser')]) {
    powershell "docker login -u ${dockeruser} -p ${dockerpasswd}"
    }
    powershell "docker push ${dockeruser}/${imagename_wordpress}"
    powershell "docker push ${dockeruser}/${imagename_mysql}"

    }



}
