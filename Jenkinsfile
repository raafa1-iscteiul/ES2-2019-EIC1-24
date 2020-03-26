pipeline {
  agent any
  stages {
    stage('Compile') {
      steps {
        sh 'mvn pom.xml clean compile -DskipTests'
      }
    }

    stage('Run tests') {
      steps {
        sh 'mvn pom.xml test'
        junit 'target/surefire-reports/*.xml'
      }
    }

    stage('Publish coverage') {
      steps {
        sh 'mvn pom.xml jacoco:prepare-agent test'
        jacoco(classPattern: '**/classes', sourcePattern: '**/src/main/java', sourceInclusionPattern: '**/*.java,**/*.groovy,**/*.kt,**/*.kts', execPattern: '**/**.exec')
      }
    }

    stage('Generate javadoc') {
      steps {
        sh 'mvn pom.xml javadoc:javadoc'
      }
    }

  }
}