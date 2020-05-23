def dockeruser = "es2ei24"
def imagename = "wordpress:5.4.1"
def container = "docker_wordpress_1"
node {
   echo 'Building Apache Docker Image'

stage('Git Checkout') {
    git 'https://github.com/raafa1-iscteiul/ES2-2019-EIC1-24.git'
    }
    
stage('Build Docker Image'){
     powershell "docker build -t  ${imagename} ."
    }
    
stage('Stop Existing Container'){
     powershell "docker stop ${container}"
    }
    
stage('Remove Existing Container'){
     powershell "docker rm ${container}"
    }
    
stage ('Runing Container to test built Docker Image'){
    powershell "docker run -dit --name ${container} -p 80:80 ${imagename}"
    }
    
stage('Tag Docker Image'){
    powershell "docker tag ${imagename} ${env.dockeruser}/${imagename}"
    }

stage('Docker Login and Push Image'){
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'dockerpasswd', usernameVariable: 'dockeruser')]) {
    powershell "docker login -u ${dockeruser} -p ${dockerpasswd}"
    }
    powershell "docker push ${dockeruser}/${imagename}"
    }

}
