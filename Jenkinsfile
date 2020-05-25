def dockeruser = "es2ei24"
def imagename_wordpress = "wordpress:5.4.1"
def container_wordpress = "docker_wordpress_1"

def imagename_mysql = "mysql:5.7"
def container_mysql = "docker_db_1"

def imagename_mvn = "maven"
def container_mvn = "docker_maven_1"

node {
   echo 'Building Apache Docker Image'

stage('Git Checkout') {
    git 'https://github.com/raafa1-iscteiul/ES2-2019-EIC1-24.git'
    }
   
stage('Build Maven Docker Image'){
     powershell "docker build -t  ${imagename_mvn} ."
    }

stage('Run Maven Docker Image'){
   powershell "docker run --name es2-2019-eic1-24-${container_mvn} -d ${imagename_mvn} ."
    }
   
stage('Build Docker Wordpress & MySQL Image'){
     powershell "docker-compose up -d"
    }
 
stage('Tag Maven Docker Image'){
    powershell "docker tag ${imagename_mvn} ${env.dockeruser}/es2-2019-eic1-24-${container_mvn}"
    }
   
stage('Tag Wordpress Docker Image'){
    powershell "docker tag ${imagename_wordpress} ${env.dockeruser}/es2-2019-eic1-24-${container_wordpress}"
    }

stage('Tag MySQL Docker Image'){
    powershell "docker tag ${imagename_mysql} ${env.dockeruser}/es2-2019-eic1-24-${container_mysql}"
    }
   
stage('Docker Login and Push Image'){
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'dockerpasswd', usernameVariable: 'dockeruser')]) {
    powershell "docker login -u ${dockeruser} -p ${dockerpasswd}"
    }
    powershell "docker push ${dockeruser}/es2-2019-eic1-24-${container_mvn}"
    powershell "docker push ${dockeruser}/es2-2019-eic1-24-${container_wordpress}"
    powershell "docker push ${dockeruser}/es2-2019-eic1-24-${container_mysql}"
    }   
}
