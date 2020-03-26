pipeline {
  agent any
  stages {
    stage('Compile') {
      steps {
        sh 'mvn clean compile -DskipTests'
      }
    }

    stage('Run tests') {
      steps {
        sh 'mvn test'
        junit 'target/surefire-reports/*.xml'
      }
    }

    stage('Publish coverage') {
      steps {
        sh 'mvn jacoco:prepare-agent test'
        jacoco(classPattern: '**/classes', sourcePattern: '**/src/main/java', sourceInclusionPattern: '**/*.java,**/*.groovy,**/*.kt,**/*.kts', execPattern: '**/**.exec')
      }
    }

    stage('Generate javadoc') {
      steps {
        sh 'mvn javadoc:javadoc'
      }
    }

  }
}