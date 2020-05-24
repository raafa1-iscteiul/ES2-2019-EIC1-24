def dockeruser = "es2ei24"

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


}
